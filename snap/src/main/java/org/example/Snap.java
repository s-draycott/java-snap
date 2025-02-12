package org.example;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Snap extends CardDeck {
    public static void main(String[] args){
        CardDeck newDeck = new CardDeck();
        startGame(newDeck);
    }

    public static void startGame(CardDeck deck){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Card> deckOfCards = deck.generateCardDeck();
        System.out.println("\nWelcome to SNAP! \nYour card deck has been generated.");

        System.out.println("Press enter to shuffle the deck");
        scanner.nextLine();
        deck.shuffleDeck();


        System.out.println("You are ready to play Snap! \nPress enter to draw the next card or type 'SNAP' if two card values match!");
        scanner.nextLine();
        Card lastCard = deck.dealCard();
        scanner.nextLine();
        Card currentCard = deck.dealCard();

        for(int card = 0; card <= 52; card++) {
            if (Objects.equals(currentCard.getSymbol(), lastCard.getSymbol())) {
                String userInput1 = scanner.nextLine().toUpperCase();
                if(userInput1.equals("SNAP")){
                    System.out.println("SNAP! YOU WIN");
                } else {
                    System.out.println("YOU LOSE - You missed a SNAP! Goodbye....");
                }break;
            } else if (!Objects.equals(currentCard.getSymbol(), lastCard.getSymbol()) && !deckOfCards.isEmpty()) {
                String userInput2= scanner.nextLine().toUpperCase();
                if(userInput2.equals("SNAP")){
                    System.out.println("YOU LOSE! That wasn't a SNAP - Goodbye...");
                    break;
                } else {
                    lastCard = currentCard;
                    currentCard = deck.dealCard();
                }
            } else if (deckOfCards.isEmpty()) {
                scanner.nextLine();
                System.out.println("YOU LOSE! The deck is empty. Goodbye...");
                break;
            } else System.out.println("Sorry we have encountered an unforeseen error, please restart the game");;
        }

    }


}