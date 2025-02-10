package org.example;

import java.util.ArrayList;

public class CardGame {
    private ArrayList<Card> deckOfCards;
    public CardGame() {
        System.out.println("Welcome to Snap!");
        deckOfCards = new ArrayList<>(52);
        Card card1 = new Card("♥", "2", 2);
        Card card2 = new Card("♥", "3", 3);
        Card card3 = new Card("♥", "4", 4);
        Card card4 = new Card("♥", "5", 5);
        Card card5 = new Card("♥", "6", 6);
        Card card6 = new Card("♥", "7", 7);
        Card card7 = new Card("♥", "8", 8);
        Card card8 = new Card("♥", "9", 9);
        Card card9 = new Card("♥", "10", 10);
        Card card10 = new Card("♥", "J", 11);
        Card card11 = new Card("♥", "Q", 12);
        Card card12 = new Card("♥", "K", 13);
        Card card13 = new Card("♥", "A", 14);
        deckOfCards.add(card1);
        deckOfCards.add(card2);
        deckOfCards.add(card3);
        deckOfCards.add(card4);
        deckOfCards.add(card5);
        deckOfCards.add(card6);
        deckOfCards.add(card7);
        deckOfCards.add(card8);
        deckOfCards.add(card9);
        deckOfCards.add(card10);
        deckOfCards.add(card11);
        deckOfCards.add(card12);
        deckOfCards.add(card13);
    }

    public void getDeck() {
        System.out.println("Here's your deck of cards:");
        for (Card card: deckOfCards){
            System.out.println(card);
        }
    }
}
