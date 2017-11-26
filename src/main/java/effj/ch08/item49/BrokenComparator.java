// Broken comparator - can you spot the flaw? - Page 221
package effj.ch08.item49;

import java.util.Comparator;

public class BrokenComparator {

    public static void main(String[] args) {

        // Broken comparator - can you spot the flaw? - Page 221
        Comparator<Integer> naturalOrder1 = new Comparator<Integer>() {
            public int compare(Integer first, Integer second) {
//                return first < second ? -1 : (first == second ? 0 : 1); // BUG
                return first < second ? -1 : (first.intValue() == second.intValue() ? 0 : 1); // FIXED
            }
        };

//		 Fixed Comparator - Page 222
        Comparator<Integer> naturalOrder2 = new Comparator<Integer>() {
            public int compare(Integer first, Integer second) {
                int f = first; // Auto-unboxing
                int s = second; // Auto-unboxing
                return f < s ? -1 : (f == s ? 0 : 1); // No unboxing
            }
        };

        int result = naturalOrder2.compare(new Integer(42), new Integer(42));
        System.out.println(result);
    }
}
