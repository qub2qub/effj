package effj.ch10.item69;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created on 2017-11-26
 */
public class ConcurrentCollections {

    private static final ConcurrentMap<String, String> map = new ConcurrentHashMap<String, String>();

    public static String intern(String s) {
        String previousValue = map.putIfAbsent(s, s);
        return previousValue == null ? s : previousValue;
    }

    // Concurrent canonicalizing map atop ConcurrentMap - faster!
    // ConcurrentHashMap is optimized for retrieval operations, such as .get()
    public static String internFast(String s) {
        String result = map.get(s);
        if (result == null) {
            result = map.putIfAbsent(s, s);
            if (result == null)
                result = s;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
