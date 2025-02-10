package org.example;

import java.util.Arrays;

public class Main{
    public static void main(String[] args){

        CardGame newGame = new CardGame();
        newGame.getDeck();
        newGame.shuffleDeck();
        newGame.getDeck();
//        newGame.sortDeckInNumberOrder();
//        newGame.getDeck();
//        newGame.dealCard();
        newGame.sortDeckInSuitOrder();
        newGame.getDeck();

//        Card myCard = new Card("♦", "A", 14);
//        Card myCard1 = new Card("♥", "A", 14);
//        Card myCard2 = new Card("♥", "A", 14);
//        Card myCard3 = new Card("♦", "A", 14);
//        Card myCard4 = new Card("♦", "A", 14);
//        Card myCard5 = new Card("♦", "A", 14);
//        Card myCard6 = new Card("♦", "A", 14);
//        System.out.println(myCard.getSuit().hashCode());
//        System.out.println(myCard1.getSuit().hashCode());
//        System.out.println(myCard2.getSuit().hashCode());
//        System.out.println(myCard3.getSuit().hashCode());
//        System.out.println(myCard4.getSuit().hashCode());
//        System.out.println(myCard5.getSuit().hashCode());
//        System.out.println(myCard6.getSuit().hashCode());



    }
}