package effj.ch04.item21;

class StringLengthComparator implements Comparator<String> {

    private StringLengthComparator() {
    }

    public static final StringLengthComparator INSTANCE = new StringLengthComparator();

    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
}