// Broken - Inappropriate use of inheritance!
package effj.ch04.item16;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSet<E> extends HashSet<E> {
	// The number of attempted element insertions
	private int addCount = 0;

	public InstrumentedHashSet() {
	}

	public InstrumentedHashSet(int initCap, float loadFactor) {
		super(initCap, loadFactor);
	}

	@Override
	public boolean add(E e) {
		addCount++;
		System.out.print("  "+addCount);
		return super.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		addCount += c.size();
		System.out.print("  "+addCount);
		return super.addAll(c);
	}

	public int getAddCount() {
		return addCount;
	}

	public static void main(String[] args) {
		InstrumentedHashSet<String> s = new InstrumentedHashSet<String>();
		s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
		System.out.println("\n"+s.getAddCount());
		System.out.println("s = " + s);

	}
}
