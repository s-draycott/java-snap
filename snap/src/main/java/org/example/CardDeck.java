package org.example;
import java.util.*;

public class CardDeck {
    public CardDeck() {}

    private final ArrayList<Card> deckOfCards = new ArrayList<>(52);

    public void getDeck() {
        System.out.println("Here's your deck of cards:");
        for (Card card : deckOfCards) {
            System.out.println(card);
        }
    }

    public boolean deckHasCards(){
        return !deckOfCards.isEmpty();
    }

    public Card dealCard() {
        if(deckHasCards()){
            System.out.println(deckOfCards.getFirst());
            return deckOfCards.removeFirst();
        } else return null;
    }

    public Card dealCardToPlayer() {
        if(deckHasCards()){
            return deckOfCards.remove(deckOfCards.size() -1);
        } else return null;
    }

    public void dealDeck(CardDeck deck, Player player1, Player player2) {
        for(int card = 0; card < 26; card++) {
            Card card1 = deck.dealCardToPlayer();
            player1.addCard(card1);
            Card card2 = deck.dealCardToPlayer();
            player2.addCard(card2);
        }
        System.out.println("Great! The deck has been dealt between players!");
    }

    public void shuffleDeck() {
        Collections.shuffle(deckOfCards);
        System.out.println("Great! The deck has been shuffled.");
    }

    public void sortDeckInNumberOrder(){
        deckOfCards.sort(new CardValueComparator());
        System.out.println("Deck has been shuffled into number order.");
    }

    public void sortDeckInSuitOrder() {
        deckOfCards.sort(new CardValueComparator());
        deckOfCards.sort(new CardSuitComparator());
        System.out.println("Deck has been shuffled into suit order.");
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
