// Set obeserver callback interface - Page 266
package effj.ch10.item67;

public interface ExternalObserver<E> {
	// Invoked when an element is added to the observable set
	void notifyAdded(ObservableSet<E> set, E element);
}
