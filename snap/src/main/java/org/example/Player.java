package org.example;

import java.util.ArrayList;

public class Player {
    private final ArrayList<Card> playersCards;

    public Player() {
        playersCards = new ArrayList<>();
    }

    public void addCard(Card card) {
        playersCards.add(card);
    }

    public Card playCard(){
        if(!playersCards.isEmpty()){
            return playersCards.removeFirst();
        } else return null;
    }

    public boolean hasCards() {
        return !playersCards.isEmpty();
    }

    public ArrayList<Card> getPlayersCards() {
        for(Card card: playersCards) {
            System.out.println(card);
        };
        return playersCards;
    }
}
