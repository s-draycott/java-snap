package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Card {
    private String suits;
    private String symbols;
    private int values;

    public Card(String suits, String symbols, int values) {
        this.suits = suits;
        this.symbols = symbols;
        this.values = values;
    }

    @Override
    public String toString(){
        return this.symbols + " of " + this.suits;
    }

    public String getSuit() {
        return suits;
    }

    public void setSuit(String suit) {
        this.suits = suit;
    }

    public String getSymbol() {
        return symbols;
    }

    public void setSymbol(String symbol) {
        this.symbols = symbol;
    }

    public int getValues() {
        return values;
    }
    public void setValues(int values) {
        this.values = values;
    }

}
