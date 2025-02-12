package org.example;

import java.util.SimpleTimeZone;

public enum CardSymbol {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("8"),
    TEN("10"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    ACE("A");

    private final String cardSymbol;

    private CardSymbol(String value) {
        this.cardSymbol = value;
    }

    public String getCardSymbol() {
        return cardSymbol;
    }
}
