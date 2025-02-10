package org.example;

import java.util.Comparator;

public class comparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2){
        return o1.getValues() - o2.getValues();
    }
}
