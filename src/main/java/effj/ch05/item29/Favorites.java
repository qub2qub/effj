// Typesafe heterogeneous container - Pages 142-145
package effj.ch05.item29;

import java.util.HashMap;
import java.util.Map;

public class Favorites {
	// Typesafe heterogeneous container pattern - implementation
	private Map<Class<?>, Object> favorites = new HashMap<Class<?>, Object>();

	public <T> void putFavorite(Class<T> type, T instance) {
		if (type == null) {
			throw new NullPointerException("Type is null");
		}
		favorites.put(type, instance);

		// Achieving runtime type safety with a dynamic cast
//		favorites.put(type, type.cast(instance));
	}

	public <T> T getFavorite(Class<T> type) {
		return type.cast(favorites.get(type));
	}

	// Typesafe heterogeneous container pattern - client
	public static void main(String[] args) {
		Favorites f = new Favorites();
		f.putFavorite(String.class, "Java");
		f.putFavorite(Integer.class, 0xcafebabe);
		f.putFavorite(Class.class, Favorites.class);

		String favoriteString = f.getFavorite(String.class);
		int favoriteInteger = f.getFavorite(Integer.class);
		Class<?> favoriteClass = f.getFavorite(Class.class);
		System.out.printf("%s || %x || %s%n",
			favoriteString, favoriteInteger, favoriteClass.getName());

		Integer casted = Integer.class.cast(0b11);
		System.out.println(Integer.class + "__ casted = " + casted);
	}
}