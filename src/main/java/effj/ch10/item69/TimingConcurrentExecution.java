package effj.ch10.item69;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * Created on 2017-11-26
 */
public class TimingConcurrentExecution {

    // Simple framework for timing concurrent execution
    public static long timeSchedule(Executor executor, int concurrency, final Runnable action)
        throws InterruptedException {

        final CountDownLatch threadsReady = new CountDownLatch(concurrency);
        final CountDownLatch peersToStart = new CountDownLatch(1);
        final CountDownLatch workIsdone = new CountDownLatch(concurrency);
        for (int i = 0; i < concurrency; i++) {
            executor.execute(() ->  {
                    threadsReady.countDown(); // Tell timer we're ready
                    try {
                        peersToStart.await(); // Wait till peers are ready
                        action.run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        workIsdone.countDown(); // Tell timer we're done
                    }
            });
        }
        /*
        The first, ready, is used by worker threads to tell the timer thread when they’re ready.
        The worker threads then wait on the second latch, which is start.
        When the last worker thread invokes ready.countDown, the timer thread records the start time
        and invokes start.countDown, allowing all of the worker threads to proceed.
        Then the timer thread waits on the third latch, done, until the last of the worker threads finishes running
        the action and calls done. countDown. As soon as this happens, the timer thread awakens
        and records the end time.
         */
        threadsReady.await(); // Wait for all workers to be ready
        long startNanos = System.nanoTime();
        peersToStart.countDown(); // And they're off!
        workIsdone.await(); // Wait for all workers to finish
        return System.nanoTime() - startNanos;
    }
}
