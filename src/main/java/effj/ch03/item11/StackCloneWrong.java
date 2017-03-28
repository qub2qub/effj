package effj.ch03.item11;

import java.util.Arrays;

public class StackCloneWrong implements Cloneable{
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public StackCloneWrong() {
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

    // Ensure space for at least one more element.
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    @Override
    protected StackCloneWrong clone() {
        try {
            return (StackCloneWrong)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning failed!", e);
        }
    }

    public static void main(String[] args) {
        StackCloneWrong orig = new StackCloneWrong();
        orig.push("AAA");
        orig.push("BB");
        orig.push("C");
        StackCloneWrong clone = orig.clone();
        System.out.println(orig.pop());
        System.out.println(orig.pop());
        System.out.println(clone.pop());
        System.out.println(clone.pop());
//        C
//        BB
//        null
//        null
    }
}