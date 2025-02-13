package org.example;

public class Card {
    private CardSuit suits;
    private CardSymbol symbols;
    private int values;

    public Card(CardSuit suits, CardSymbol symbols, int values) {
        this.suits = suits;
        this.symbols = symbols;
        this.values = values;
    }

    @Override
    public String toString(){
        return this.symbols.getCardSymbol() + " of " + this.suits.getCardSymbol() + " value of " + this.values;
    }

    public CardSuit getSuit() {
        return suits;
    }

    public void setSuit(String suit) {
        this.suits = CardSuit.valueOf(suit);
    }

    public CardSymbol getSymbol() {
        return symbols;
    }

    public void setSymbol(String symbol) {
        this.symbols = CardSymbol.valueOf(symbol);
    }

    public int getValues() {
        return values;
    }

}
