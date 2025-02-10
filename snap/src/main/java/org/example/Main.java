package org.example;

import java.util.Arrays;

public class Main{
    public static void main(String[] args){

        CardGame newGame = new CardGame();
        newGame.getDeck();
        newGame.dealCard();
        newGame.dealCard();
        newGame.getDeck();
        newGame.shuffleDeck();
        newGame.getDeck();
    }
}