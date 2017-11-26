// Simple test of ObservableSet - Page 266
package effj.ch10.item67;

import java.util.HashSet;

public class Test1 {

    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<Integer>(
            new HashSet<Integer>());

		/*set.addObserver(new ExternalObserver<Integer>() {
            public void notifyAdded(ObservableSet<Integer> s, Integer e) {
				System.out.println(e);
			}
		});*/
        set.addObserver((s, e) -> System.out.println(s.size() + " -- " + e));

        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
    }
}
