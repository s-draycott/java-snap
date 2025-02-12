package org.example;
import java.util.*;

public class CardDeck {
    private final ArrayList<Card> deckOfCards = new ArrayList<>(52);

    public void getDeck() {
        System.out.println("Here's your deck of cards:");
        for (Card card : deckOfCards) {
            System.out.println(card);
        }
    }

    public Card dealCard() {
        if(!deckOfCards.isEmpty()){
            System.out.println(deckOfCards.getFirst());
            return deckOfCards.removeFirst();
        } else return null;
    }

    public void shuffleDeck() {
        Collections.shuffle(deckOfCards);
        System.out.println("The deck has been shuffled");
    }

    public void sortDeckInNumberOrder(){
        deckOfCards.sort(new CardValueComparator());
        System.out.println("Deck has been shuffled into number order");
    }

    public void sortDeckInSuitOrder() {
        deckOfCards.sort(new CardValueComparator());
        deckOfCards.sort(new CardSuitComparator());
        System.out.println("Deck has been shuffled into suit order");
    }

    public ArrayList<Card> generateCardDeck(){
        for(int i =0; i<4; i++){
            CardSuit suit = CardSuit.values()[i];
            int counter = 2;
            for(int j=0; j<13; j++){
                Card card = new Card(suit, CardSymbol.values()[j], counter++);
                deckOfCards.add(card);
            }
        } return deckOfCards;
    }
}
