package org.example;
import java.util.*;

public class CardDeck {
    private final ArrayList<Card> deckOfCards = new ArrayList<>(52);

    public ArrayList<Card> getDeck() {
        System.out.println("Here's your deck of cards:");
        for (Card card : deckOfCards) {
            System.out.println(card);
        }
        return deckOfCards;
    }

    public Card dealCard() {
        if(!deckOfCards.isEmpty()){
            System.out.println(deckOfCards.getFirst());
            return deckOfCards.removeFirst();
        } else return null;
    }

    public ArrayList<Card> shuffleDeck() {
        Collections.shuffle(deckOfCards);
        System.out.println("The deck has been shuffled");
        return deckOfCards;
    }

    public ArrayList<Card> sortDeckInNumberOrder(){
        deckOfCards.sort(new CardValueComparator());
        System.out.println("Deck has been shuffled into number order");
        return deckOfCards;
    }

    public void sortDeckInSuitOrder() {
        deckOfCards.sort(new CardValueComparator());
        deckOfCards.sort(new CardSuitComparator());
        System.out.println("Deck has been shuffled into suit order");
    }

    public ArrayList<Card> generateCardDeck() {
        deckOfCards.add(new Card("♥", "2", 2));
        deckOfCards.add(new Card("♥", "3", 3));
        deckOfCards.add(new Card("♥", "4", 4));
        deckOfCards.add(new Card("♥", "5", 6));
        deckOfCards.add(new Card("♥", "6", 6));
        deckOfCards.add(new Card("♥", "7", 7));
        deckOfCards.add(new Card("♥", "8", 8));
        deckOfCards.add(new Card("♥", "9", 9));
        deckOfCards.add(new Card("♥", "10", 10));
        deckOfCards.add(new Card("♥", "J", 11));
        deckOfCards.add(new Card("♥", "Q", 12));
        deckOfCards.add(new Card("♥", "K", 13));
        deckOfCards.add(new Card("♥", "A", 14));
        deckOfCards.add(new Card("♦", "2", 2));
        deckOfCards.add(new Card("♦", "3", 3));
        deckOfCards.add(new Card("♦", "4", 4));
        deckOfCards.add(new Card("♦", "5", 6));
        deckOfCards.add(new Card("♦", "6", 6));
        deckOfCards.add(new Card("♦", "7", 7));
        deckOfCards.add(new Card("♦", "8", 8));
        deckOfCards.add(new Card("♦", "9", 9));
        deckOfCards.add(new Card("♦", "10", 10));
        deckOfCards.add(new Card("♦", "J", 11));
        deckOfCards.add(new Card("♦", "Q", 12));
        deckOfCards.add(new Card("♦", "K", 13));
        deckOfCards.add(new Card("♦", "A", 14));
        deckOfCards.add(new Card("♣", "2", 2));
        deckOfCards.add(new Card("♣", "3", 3));
        deckOfCards.add(new Card("♣", "4", 4));
        deckOfCards.add(new Card("♣", "5", 6));
        deckOfCards.add(new Card("♣", "6", 6));
        deckOfCards.add(new Card("♣", "7", 7));
        deckOfCards.add(new Card("♣", "8", 8));
        deckOfCards.add(new Card("♣", "9", 9));
        deckOfCards.add(new Card("♣", "10", 10));
        deckOfCards.add(new Card("♣", "J", 11));
        deckOfCards.add(new Card("♣", "Q", 12));
        deckOfCards.add(new Card("♣", "K", 13));
        deckOfCards.add(new Card("♣", "A", 14));
        deckOfCards.add(new Card("♠", "2", 2));
        deckOfCards.add(new Card("♠", "3", 3));
        deckOfCards.add(new Card("♠", "4", 4));
        deckOfCards.add(new Card("♠", "5", 6));
        deckOfCards.add(new Card("♠", "6", 6));
        deckOfCards.add(new Card("♠", "7", 7));
        deckOfCards.add(new Card("♠", "8", 8));
        deckOfCards.add(new Card("♠", "9", 9));
        deckOfCards.add(new Card("♠", "10", 10));
        deckOfCards.add(new Card("♠", "J", 11));
        deckOfCards.add(new Card("♠", "Q", 12));
        deckOfCards.add(new Card("♠", "K", 13));
        deckOfCards.add(new Card("♠", "A", 14));
        return deckOfCards;
    }
}
