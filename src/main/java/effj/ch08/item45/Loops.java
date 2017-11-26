package effj.ch08.item45;

/**
 * Created by den on 2017-11-05
 */
public class Loops {

    public static void main(String[] args) {
        /*
        for (Iterator<Element> i = c.iterator(); i.hasNext(); ) {
            doSomething(i.next());
        }

        // Compile-time error - cannot find symbol i
        for (Iterator<Element> i2 = c2.iterator(); i.hasNext(); ) {
            doSomething(i2.next());
        }


        //Here is another loop idiom that minimizes the scope of local variables:
        for (int i = 0, n = expensiveComputation(); i < n; i++) {
            doSomething(i);
        }
        */
        int[] arr = {1, 2, 3};
//        arr[Long.MAX_VALUE]// 0x7fff_ffff_ffff_ffffL
//        Integer.MAX_VALUE// 0x7fff_ffff
        for (int i = 0, n = arr.length, z = 1; i < n; i++, z = 2) {
//            doSomething(arr[i]);
            System.out.println(i +" -- " + z);
        }
//        for (int e : arr ) {
//            System.out.println(e);
//        }
    }
}
