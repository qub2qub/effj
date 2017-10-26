// Sample uses of varargs
package effj.ch07.item42;

import java.util.Arrays;

public class Varargs {

	// Simple use of varargs - Page 197
	static int sum(int... args) {
		int sum = 0;
		for (int arg : args)
			sum += arg;
		return sum;
	}

	// The WRONG way to use varargs to pass one or more arguments! - Page 197
	static int minWrong(int... args) {
		if (args.length == 0) {
			throw new IllegalArgumentException("Too few arguments");
		}
		int min = args[0];
		for (int i = 1; i < args.length; i++) {
			if (args[i] < min) {
				min = args[i];
			}
		}
		return min;
	}

	// The right way to use varargs to pass one or more arguments - Page 198
	static int minRight(int firstArg, int... remainingArgs) {
		int min = firstArg;
		for (int arg : remainingArgs)
			if (arg < min)
				min = arg;
		return min;
	}

	public static void main(String[] args) {
		System.out.println(sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		System.out.println(minRight(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

		int[] digits = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 4 };
		System.out.println(Arrays.asList(digits)); // compiles w/o warning
		System.out.println(Arrays.toString(digits)); // right solution

	}
}
