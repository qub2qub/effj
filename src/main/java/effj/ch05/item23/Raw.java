package effj.ch05.item23;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Raw {
	// Uses raw type (List) - fails at runtime! - Page 112
	public static void main2(String[] args) {
		List<String> strings = new ArrayList<String>();
		unsafeAdd(strings, new Integer(42));
		// ClassCastException: java.lang.Integer cannot be cast to java.lang.String
		String s = strings.get(0); // Compiler-generated cast

//		unsafeAdd2(strings, 11);
	}

	private static void unsafeAdd(List list, Object o) {
		list.add(o);
	}

	private static void unsafeAdd2(List<Object> list, Object o) {
		list.add(o);
	}

	// Use of raw type for unknown element type - don't do this! - Page 113
	static int rawNumElementsInCommon(Set s1, Set s2) {
		int result = 0;
		for (Object o1 : s1)
			if (s2.contains(o1))
				result++;
		return result;
	}

	// Unbounded wildcard type - typesafe and flexible - Page 113
	static int numElementsInCommon(Set<?> s1, Set<?> s2) {
		int result = 0;
		for (Object o1 : s1)
			if (s2.contains(o1)) {
				result++;
			} else {
				System.out.println("not contains");
			}
		return result;
	}

	public static void main(String[] args) {
			Set<String> s1 = new HashSet<>();
			s1.add("1");
			s1.add("b");
			s1.add("c");

		Set<String> s2 = new HashSet<>();
		s2.add("b");
		s2.add("c");
		s2.add("d");
		Set<?> s3 = new HashSet<>();
//		s3.add(new Object());
		s3.add(null);

		Set<Integer> s4 = new HashSet<>();
		s4.add(1);
		s4.add(2);
		System.out.println(numElementsInCommon(s1, s4));
		System.out.println(String[].class);
		if (s1 instanceof Set) { 		// Raw type
			Set<?> m = (Set<?>) s1; 		// Wildcard type
			// This is a checked cast, so it will not cause a compiler warning.
			m.add(null);
			System.out.println(m);
			for (Object o : m) {
				System.out.println(o.getClass());
			}
//			System.out.println(m.);
			Set<Object> obj = new HashSet<>();
			obj.add("1");
			obj.add(1);
		}
	}
}
