package effj.ch08.item51;

import javax.xml.stream.events.Characters;

/**
 * Created by den on 2017-11-06
 */
public class StringConcat {

    // Inappropriate use of string concatenation - Performs horribly!
    public static String badStatement() {
        String result = "";
        for (int i = 0; i < numItems(); i++)
            result += lineForItem(i); // String concatenation
        return result;
    }

    public static String okStatement() {
        StringBuilder b = new StringBuilder(numItems() *2);
        for (int i = 0; i < numItems(); i++)
            b.append(lineForItem(i));
        return b.toString();
    }

    private static String lineForItem(int i) {
        return String.valueOf(i)+" ";
    }

    private static int numItems() {
        return 2_000_000_000;
    }

    public static void main(String[] args) {
//        System.out.println(badStatement());
        System.out.println(okStatement());
//        System.out.println("\uD801");
//        System.out.println(Character.getNumericValue('Z'));
    }

}
