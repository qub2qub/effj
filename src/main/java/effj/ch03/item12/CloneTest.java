package effj.ch03.item12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Denis on 2017-04-01
 */
public class CloneTest implements Cloneable {

    public static final Long[] LONGS = {12L, 34L, 111L};
    private static final Object[] PRIVATE_VALUES = { 123, 345L, "Str1",
        new CloneHolder(LONGS) };

    public String name;
    public Object obj;
    public CloneHolder holder;

    @Override
    public String toString() {
        return "CloneTest{" +
                "name='" + name + '\'' +
                ", obj=" + obj +
                ", holder=" + holder +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneTest n1 = new CloneTest();
        n1.name = "n1";
        n1.obj = 123L;
        n1.holder = new CloneHolder(new HashMap());
        ((HashMap)n1.holder.hold).put("a", 1);

        CloneTest n2 = (CloneTest) n1.clone();
        System.out.println("orig n1 = " + n1);
        System.out.println("orig n2 = " + n2);

        n1.obj = 999L; // изменил ссылку в первом классе
        // во втором классе ссыка осталась на 1й лонг.
        ((HashMap)n1.holder.hold).put("b", 2);
//        n1.holder.hold = new Object();
        System.out.println("n1changed __ n1 = " + n1);
        System.out.println("n1changed __ n2 = " + n2);

//        StackCloneWrong num = new StackCloneWrong();
//        num.clone();

        System.out.println("arr1__ LONGS __ " + Arrays.toString(LONGS));
        System.out.println("arr1__ PRIVATE_VALUES __ " + Arrays.toString(PRIVATE_VALUES));
        System.out.println(" = " + Arrays.toString((Object[])((CloneHolder)PRIVATE_VALUES[3]).hold));
        LONGS[2] = 567L;
        System.out.println("arr2__ LONGS __ " + Arrays.toString(LONGS));
        System.out.println("arr2__ PRIVATE_VALUES __ " + Arrays.toString(PRIVATE_VALUES));
        System.out.println(" = " + Arrays.toString((Object[])((CloneHolder)PRIVATE_VALUES[3]).hold));
    }
    static class InnerStatic {

    }
}

// как такой класс обозначается?
class OuterClass {

}