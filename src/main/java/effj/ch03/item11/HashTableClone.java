package effj.ch03.item11;

public class HashTableClone  implements Cloneable {
    private Entry[] buckets = new Entry[10];

    private static class Entry {
        final Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        // Recursively copy the linked list headed by this Entry
        Entry deepCopy1() {
            return new Entry(key, value,
                    next == null ? null : next.deepCopy1());
        }

        // Iteratively copy the linked list headed by this Entry
        Entry deepCopy() {
            Entry result = new Entry(key, value, next);
            for (Entry p = result; p.next != null; p = p.next) {
                p.next = new Entry(p.next.key, p.next.value, p.next.next);
            }
            return result;
        }
    }

    /**
     * The deep-copy method on Entry invokes itself recursively to
              copy the entire linked list headed by the entry.
     it consumes one stack frame for each element in the list.
            If the list is long, this could easily cause a stack overflow.
     */
    @Override
    public HashTableClone clone() {
        try {
            HashTableClone result = (HashTableClone) super.clone();
            result.buckets = new Entry[buckets.length];
            for (int i = 0; i < buckets.length; i++)
                if (buckets[i] != null)
                    result.buckets[i] = buckets[i].deepCopy();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
//... // Remainder omitted
}