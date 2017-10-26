// What does this program print? - Page 194
package effj.ch07.item41;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetList {
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<Integer>();
		List<Integer> list = new ArrayList<Integer>();

		for (int i = -3; i < 3; i++) {
			set.add(i);
			list.add(i);
		}
		System.out.println("1 set = " + set);
		System.out.println("1 list = " + list);
		System.out.println("remove 0,1,2");
		for (int i = 0; i < 3; i++) {
			//removing the positive values from the set.
			set.remove(i); // remove(Object o);

			// remove the zeroth element, then the first, and then the second, you’re left with [-2, 0, 2],
			list.remove(i); // remove(int index)
			//solution:
//			list.remove(Integer.valueOf(i)); //  remove(Object o)
		}
		System.out.println("2 set = " + set);
		System.out.println("2 list = " + list);
	}
}
