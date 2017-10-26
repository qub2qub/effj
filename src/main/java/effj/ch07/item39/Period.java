// Broken "immutable" time period class - Page 184
package effj.ch07.item39;

import java.util.Date;

public final class Period {

//    It is, however, easy to violate this invariant by exploiting the fact that Date is mutable:
    private final Date start;
    private final Date end;

    /**
     * @param start the beginning of the period
     * @param end the end of the period; must not precede start
     * @throws IllegalArgumentException if start is after end
     * @throws NullPointerException if start or end is null
     */
    public Period(Date start, Date end) {
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + " after " + end);
        }
//        this.start = start;
//        this.end = end;
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
    }

    public Date start() {
//        return start;
        return new Date(start.getTime());
    }

    public Date end() {
//        return end;
        return new Date(end.getTime());
    }

    public String toString() {
        return start + " - " + end;
    }
}