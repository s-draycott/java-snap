package org.example;

import java.util.Comparator;
import java.util.Objects;

public class CardSuitComparator implements Comparator<Card> {
    public CardSuitComparator() {}

    @Override
    public int compare(Card c1, Card c2) {
        if(c1.getSuit().hashCode() < c2.getSuit().hashCode()) {
            return 1;
        } else if (c1.getSuit().hashCode() > c2.getSuit().hashCode()) {
            return -1;
        } else return 0;
    }
}
