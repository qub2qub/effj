// Broken - invokes alien method from synchronized block! - Page 265
package effj.ch10.item67;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class ObservableSet<E> extends ForwardingSet<E> {
	public ObservableSet(Set<E> set) {
		super(set);
	}

	/*private final List<ExternalObserver<E>> observers = new ArrayList<ExternalObserver<E>>();

	public void addObserver(ExternalObserver<E> observer) {
		synchronized (observers) {
			observers.add(observer);
		}
	}

	public boolean removeObserver(ExternalObserver<E> observer) {
		synchronized (observers) {
			return observers.remove(observer);
		}
	}*/

	// This method is the culprit //  виновный; преступник
	/*private void notifyElementAdded(E element) {
		synchronized (observers) {
			for (ExternalObserver<E> observer : observers)
				observer.notifyAdded(this, element);
		}
	}*/

	// Alien method moved outside of synchronized block - open calls - Page 268
	/*private void notifyElementAdded(E element) {
		List<ExternalObserver<E>> observersSnapshot = null;
		synchronized (observers) {
			observersSnapshot = new ArrayList<ExternalObserver<E>>(observers);
		}
		for (ExternalObserver<E> observer : observersSnapshot) {
			observer.notifyAdded(this, element);
		}
	}*/

	// Thread-safe observable set with CopyOnWriteArrayList - Page 269
	private final List<ExternalObserver<E>> observers =
		new CopyOnWriteArrayList<ExternalObserver<E>>();

	public void addObserver(ExternalObserver<E> observer) {
		observers.add(observer);
	}

	public boolean removeObserver(ExternalObserver<E> observer) {
		return observers.remove(observer);
	}

	private void notifyElementAdded(E element) {
		for (ExternalObserver<E> observer : observers) {
			observer.notifyAdded(this, element);
		}
	}

	@Override
	public boolean add(E element) {
		boolean added = super.add(element);
		if (added) {
			notifyElementAdded(element);
		}
		return added;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		boolean result = false;
		for (E element : c) {
			result |= add(element); // calls notifyElementAdded
		}
		return result;
	}
}
