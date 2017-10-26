package effj.ch07.item38;

import java.math.BigInteger;

/**
 * Created by den on 2017-10-22
 */
public class Assertions {

    public BigInteger mod(BigInteger m) {
        if (m.signum() <= 0)
            throw new ArithmeticException("Modulus <= 0: " + m);
 // Do the computation
        return null;
    }

    // Private helper function for a recursive sort
    private static void sort(long a[], int offset, int length) {
        assert a != null;
        assert offset >= 0 && offset <= a.length;
        assert length >= 0 && length <= a.length - offset;
 // Do the computation
    }

}
