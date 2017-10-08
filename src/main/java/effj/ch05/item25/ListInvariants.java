package effj.ch05.item25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Denis on 2017-04-16
 */
public class ListInvariants {

    public static void main2(List<Integer>... args) {

    }
    public static void main(String[] args) {
        // Fails at runtime!
        Object[] objectArray = new Long[2];
        objectArray[0] = 22L;
        objectArray[1] = "I don't fit in"; // Throws ArrayStoreException

        // Only unbounded wildcars possible
        List<?>[] arrayOfUnboundedWildcard = new List[10];
        List<String> str = new ArrayList<>();
        List<Long> lon = new ArrayList<>();
        List<Object> obj = new ArrayList<>();

        arrayOfUnboundedWildcard[0] = str;
        arrayOfUnboundedWildcard[1] = lon;
        arrayOfUnboundedWildcard[2] = obj;

        List<?> strings = arrayOfUnboundedWildcard[0];
        Object o = strings.get(1);
//  Won't compile!
//        List<Object> ol = new ArrayList<Long>(); // Incompatible types
//        ol.add("I don't fit in");

        // Why generic array creation is illegal -
//        List<String>[] stringLists = new List<String>[1]; // (1) won't compile!

        List<String>[] stringLists = null;
        List<Integer> intList = Arrays.asList(42); // (2)
        intList.toArray(stringLists); // test
        Object[] objects = stringLists; // (3)
        // == List<String>[] objects -- т.е. массив, к-й в ячейке хранит листы стрингов
        // а мы ему в ячейку добавим лист интов
        objects[0] = intList; // (4)
        String s = stringLists[0].get(0); // (5)*/
        /*
        Let’s pretend that line 1, which creates a generic array, is legal.
        Line 2 creates and initializes a List<Integer> containing a single element.
        Line 3 stores the List<String> array into an Object array variable, which is legal because arrays are covariant.
        Line 4 stores the List<Integer> into the sole element of the Object array,
        which succeeds because generics are implemented by erasure: the runtime type of a List<Integer> instance
        is simply List, and the runtime type of a List<String>[] instance is List[],
        so this assignment doesn’t generate an ArrayStoreException.

        Now we’re in trouble.
        We’ve stored a List<Integer> instance into an array that is declared to hold only List<String> instances.
        In line 5, we retrieve the sole element from the sole list in this array.
        The compiler automatically casts the retrieved element to String,
        but it’s an Integer, so we get a ClassCastException at runtime.
        In order to prevent this from happening, line 1 (which creates a generic array) generates a compile-time error.
         */


    }
}
