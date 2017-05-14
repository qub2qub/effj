// Using a recursive type bound with wildcards - Page 138-139
package effj.ch05.item28;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class RecursiveTypeBoundPECS {

	public static <T extends Comparable<? super T>> T max(List<? extends T> list) {

		Iterator<? extends T> i = list.iterator();
		T result = i.next();

		/* The elements returned by the iterator’s next() method
		are of some subtype of T,
		so they can be safely stored in a variable of type T. */
		while (i.hasNext()) {
			T t = i.next();
			if (t.compareTo(result) > 0) {
				result = t;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		List<String> argList = Arrays.asList(args);
		System.out.println(max(argList));
	}
}