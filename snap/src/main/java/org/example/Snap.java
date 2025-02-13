package org.example;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Snap extends CardDeck {

//    public void userInputHandler(String userInput){
//        if(userInput.equals("1")){
//            shuffleDeck();
//        } else if (userInput.equals("2")){
//            getDeck();
//        } else System.out.println("Please enter a valid input");
//    }

    public void startSnap(){
        CardDeck deck = new CardDeck();
        Scanner scanner = new Scanner(System.in);
        deck.generateCardDeck();

        System.out.println("\nWelcome to SNAP! \nYour card deck has been generated.");

        System.out.println("Press enter to shuffle the deck");
        String userInput = scanner.nextLine();
        deck.shuffleDeck();

        Player player1 = new Player();
        Player player2 = new Player();
        System.out.println("Press enter to deal the cards between 2 players");
        scanner.nextLine();
        deck.dealDeck(deck, player1, player2);

        System.out.println("player1s cards");
        player1.getPlayersCards();
        System.out.println("player2s cards");
        player2.getPlayersCards();

        System.out.println("You are ready to play Snap! \nPress enter to draw the next card or type 'SNAP' if two card values match!");
        scanner.nextLine();
        Card lastCard = deck.dealCard();
        scanner.nextLine();
        Card currentCard = deck.dealCard();

//        for(int card = 0; card <= 52; card++) {
//            if (Objects.equals(currentCard.getSymbol(), lastCard.getSymbol())) {
//                String userInput1 = scanner.nextLine().toUpperCase();
//                if(userInput1.equals("SNAP")){
//                    System.out.println("SNAP! YOU WIN");
//                } else {
//                    System.out.println("YOU LOSE - You missed a SNAP! Goodbye....");
//                }break;
//            } else if (!Objects.equals(currentCard.getSymbol(), lastCard.getSymbol()) && !deckOfCards.isEmpty()) {
//                String userInput2= scanner.nextLine().toUpperCase();
//                if(userInput2.equals("SNAP")){
//                    System.out.println("YOU LOSE! That wasn't a SNAP - Goodbye...");
//                    break;
//                } else {
//                    lastCard = currentCard;
//                    currentCard = deck.dealCard();
//                }
//            } else if (deckOfCards.isEmpty()) {
//                scanner.nextLine();
//                System.out.println("YOU LOSE! The deck is empty. Goodbye...");
//                break;
//            } else System.out.println("Sorry we have encountered an unforeseen error, please restart the game");;
//        }
    }



}