package effj.ch04.item21;

// Strategy interface
public interface Comparator<T> {

    public int compare(T t1, T t2);
}