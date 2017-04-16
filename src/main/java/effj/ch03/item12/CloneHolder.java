package effj.ch03.item12;

/**
 * Created by Denis on 2017-04-02
 */
public class CloneHolder {
    public final Object hold;

    public CloneHolder(Object hold) {
        this.hold = hold;
    }

    @Override
    public String toString() {
        return
                "[hold=" + hold + "]";
    }

    public static void main(String[] args) {
    		OuterClass ok = new OuterClass();
    }
}
