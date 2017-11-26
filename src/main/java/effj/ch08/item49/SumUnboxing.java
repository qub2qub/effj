package effj.ch08.item49;

/**
 * Created by den on 2017-11-05
 */
public class SumUnboxing {

    public static void main(String[] args) {
        Long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            //  the variable is repeatedly boxed and unboxed,
            // causing the observed performance degradation.
            sum += i;
        }
        System.out.println(sum);
    }
}
