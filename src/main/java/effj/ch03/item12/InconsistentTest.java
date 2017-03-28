package effj.ch03.item12;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by Denis on 2017-03-26
 */
public class InconsistentTest {
    public static void main(String[] args) {
        BigDecimal one = new BigDecimal("1.0");
        BigDecimal one1 = new BigDecimal("1.00");
        HashSet<Object> hash = new HashSet<>();
        TreeSet<Object> tree = new TreeSet<>();
        hash.add(one);
        hash.add(one1);
        tree.add(one);
        tree.add(one1);
        System.out.println("hash = " + hash);
        System.out.println("tree = " + tree);
//        hash = [1.0, 1.00]
//        tree = [1.0]

//        String.CASE_INSENSITIVE_ORDER.compare(s1, s2);
    }
}
