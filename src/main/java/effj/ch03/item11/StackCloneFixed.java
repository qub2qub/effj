// A cloneable version of Stack - Pages 56-57
package effj.ch03.item11;

import java.util.Arrays;

public class StackCloneFixed implements Cloneable {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public StackCloneFixed() {
		this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public Object pop() {
		if (size == 0)
			throw new EmptyStackException();
		Object result = elements[--size];
		elements[size] = null; // Eliminate obsolete reference
		return result;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public StackCloneFixed clone() {
		try {
			StackCloneFixed result = (StackCloneFixed) super.clone();
			result.elements = elements.clone();
			return result;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}

	// Ensure space for at least one more element.
	private void ensureCapacity() {
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}

	// To see that clone works, call with several command line arguments
	public static void main(String[] args) {
		StackCloneFixed orig = new StackCloneFixed();
		orig.push("AAA");
		orig.push("BB");
		orig.push("C");
		StackCloneFixed clone = orig.clone();
		while (!orig.isEmpty()) {
			System.out.print(orig.pop() + " ");
		}
		System.out.println();
		while (!clone.isEmpty()) {
			System.out.print(clone.pop() + " ");
		}
	}
}
