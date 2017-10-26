package effj.ch07.item43;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by den on 2017-10-26
 */
public class ReturnNewCollection {

    // zero-length arrays are immutable and immutable objects may be shared freely
    private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];

    private final List<Cheese> cheesesInStock = new ArrayList<>();

    //     an array containing all of the cheeses in the shop, or null if no cheeses are available for purchase.
    public Cheese[] getCheeses() {
        if (cheesesInStock.size() == 0) {
            return null;
        }
        return new Cheese[5];
    }

    public Cheese[] getCheeses2() {
        return cheesesInStock.toArray(EMPTY_CHEESE_ARRAY);
    }

    // The right way to return a copy of a collection
    public List<Cheese> getCheeseList() {
        if (cheesesInStock.isEmpty()) {
            return Collections.emptyList(); // Always returns same list
        } else {
            return new ArrayList<Cheese>(cheesesInStock);
        }
    }

    public static void main(String[] args) {

        ReturnNewCollection shop = new ReturnNewCollection();

        Cheese[] cheeses = shop.getCheeses();
        // BAD OLD STYLE
        if (cheeses != null && Arrays.asList(cheeses).contains(Cheese.STILTON)) {
            System.out.println("Jolly good, just the thing.");
        }

        // BETTER STYLE
        if (Arrays.asList(shop.getCheeses()).contains(Cheese.STILTON)) {
            System.out.println("Jolly good, just the thing.");
        }
    }

}
