package org.example;

public enum CardSuit {
    HEARTS("♥"),
    DIAMONDS("♦"),
    CLUBS("♣"),
    SPADES("♠");

    private final String cardSymbol;

    private CardSuit(String symbol){
        this.cardSymbol = symbol;
    }

    public String getCardSymbol(){
        return cardSymbol;
    }


}
