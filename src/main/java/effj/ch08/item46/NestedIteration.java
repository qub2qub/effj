// Can you spot the bug? - Page 46
package effj.ch08.item46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

enum Suit {
    CLUB, DIAMOND, HEART, SPADE
}

enum Rank {
    ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
}

class Card {

    final Suit suit;
    final Rank rank;

    Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }
}

public class NestedIteration {

    public static void main(String[] args) {
        Collection<Suit> suits = Arrays.asList(Suit.values());
        Collection<Rank> ranks = Arrays.asList(Rank.values());

        List<Card> deck = new ArrayList<Card>();
        for (Iterator<Suit> i = suits.iterator(); i.hasNext(); ) {
            Suit suit = i.next(); // fix
            for (Iterator<Rank> j = ranks.iterator(); j.hasNext(); ) {
                // BUG!!!
                // next method is called too many times on the iterator for the outer collection (suits).
//                deck.add(new Card(i.next(), j.next()));
                deck.add(new Card(suit, j.next())); // fixed
            }
        }

        // Preferred idiom for nested iteration on collections and arrays
        for (Suit suit : suits)
            for (Rank rank : ranks)
                deck.add(new Card(suit, rank));
    }
}