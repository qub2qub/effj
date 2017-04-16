// Generic stack using Object[] - Pages 125-127
package effj.ch05.item26;

import java.util.Arrays;

public class SecondStack<E> {
	private Object[] elements; // here !!!
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public SecondStack() {
		// here !!!
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}

	// Appropriate suppression of unchecked warning
	public E pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}

		// push requires elements to be of type E, so cast is correct
		@SuppressWarnings("unchecked")
		E result = (E) elements[--size]; // here !!!

		elements[size] = null; // Eliminate obsolete reference
		return result;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private void ensureCapacity() {
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}

	// Little program to exercise our generic Stack
	public static void main(String[] args) {
		SecondStack<String> stack = new SecondStack<String>();
		for (String arg : args) {
			stack.push(arg);
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop().toUpperCase());
		}
	}
}
