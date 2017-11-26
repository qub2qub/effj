package effj.ch10.item66;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by den on 2017-11-19
 */
public class Increment {

    private static final AtomicLong nextSerialNum = new AtomicLong();

    public static long generateSerialNumber() {
        return nextSerialNum.getAndIncrement();
    }

    // Broken - requires synchronization!
    private static volatile int nextSerialNumber = 0;

    public static int generateSerialNumberBAD() {
        return nextSerialNumber++;
    }

}
