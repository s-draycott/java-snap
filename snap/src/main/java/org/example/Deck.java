//package org.example;
//
//import java.util.ArrayList;
//
//public class Deck {
//    public Deck(){
//        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
//        String[] symbols = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
//        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
//
//        ArrayList<Card> cards = new ArrayList<>(52);
//
//
//        int index = 0;
//        for(String suit : suits) {
//            for(String symbol: symbols) {
//                for(int value: values) {
//                    cards.set(index++, new Card(suit, symbol, value));
//                }
//            }
//        }
//
//    }
//
//}
