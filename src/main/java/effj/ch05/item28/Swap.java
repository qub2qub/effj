// Private helper method for wildcard capture - Pages 139-140
package effj.ch05.item28;

import java.util.Arrays;
import java.util.List;

public class Swap {

	public static void swapBad(List<?> list, int i, int j) {
		/*
		Wrong 2nd argument type. Found: '?', required: '?'
		set(int,capture<?>) in List cannot be applied to (int,capture<?>) 
		*/
//		list.set(i, list.set(j, list.get(i)));
	}
	public static void swap(List<?> list, int i, int j) {
		swapHelper(list, i, j);
	}

	// Private helper method for wildcard capture
	private static <E> void swapHelper(List<E> list, int i, int j) {
		/*
		The swapHelper method knows that list is a List<E>.
		Therefore, it knows that any value [ it gets out of this list ] is of type E,
		and that it’s safe to put [ any value of type E ] into the list.
		 */
		list.set(i, list.set(j, list.get(i)));
	}

	public static void main(String[] args) {
		// Swap the first and last argument and print the resulting list
		List<String> argList = Arrays.asList(args);
		swap(argList, 0, argList.size() - 1);
		System.out.println(argList);
	}
}
