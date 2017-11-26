package effj.ch08.item50;

// Broken - inappropriate use of string as capability!
public class StringThreadLocal {

    private StringThreadLocal() { } // Noninstantiable
    // Sets the current thread's value for the named variable.
    public static void set(String key, Object value) {
        /* if two clients independently decide to use the same name for their thread-local variable,
        they unintentionally share a single variable, which will generally cause both clients to fail.*/
    }
    // Returns the current thread's value for the named variable.
    public static Object get(String key) {
        return null;
    }

    // FIX
    /*public static class Key { // (Capability)
        Key() { }
    }
    // Generates a unique, unforgeable key
    public static Key getKey() {
        return new Key();
    }
    public static void set(Key key, Object value);
    public static Object get(Key key);*/

}
