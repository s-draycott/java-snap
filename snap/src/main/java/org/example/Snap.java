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

    public void startSnap() {
        Player player1 = new Player();
        Player player2 = new Player();

        CardDeck deck = new CardDeck();
        Scanner scanner = new Scanner(System.in);
        deck.generateCardDeck();


        System.out.println("\nWelcome to SNAP! \nYour card deck has been generated.");
        System.out.println("Press enter to shuffle the deck");
        String userInput = scanner.nextLine();
        deck.sortDeckInNumberOrder();


        System.out.println("Press enter to deal the cards between 2 players");
        scanner.nextLine();
        deck.dealDeck(deck, player1, player2);


        System.out.println("You are ready to play Snap!\nBut first THE RULES:\nPress enter on your turn to draw the next card or type 'SNAP' if two card values match!");
        System.out.println("Press enter to start the game...");
        scanner.nextLine();


        int currentPlayersTurn =1;
//        System.out.println("Player 1s press enter to reveal the first card ...");
//        scanner.nextLine();
//        Card lastCard = player1.playCard();
//        currentPlayersTurn+=1;
//        System.out.println(currentPlayersTurn);
//
//        System.out.println("Player 2s turn press enter to reveal the next card ...");
//        scanner.nextLine();
//        Card currentCard = player1.playCard();
//        System.out.println("Player 2 press enter to end your go or SNAP");
//        scanner.nextLine();
//        currentPlayersTurn-=1;
//
//        String userSelection1 = scanner.nextLine().toUpperCase();
        Card lastCard = new Card(null, null, 0 );
        Card currentCard = lastCard;

        while (player1.hasPlayerCards() && player2.hasPlayerCards()) {
            //LOGIC FOR PLAYER 1s TURN
            if(currentPlayersTurn == 1) {
                System.out.println("Player 1 - it's your turn");
                currentCard = player1.playCard();
                System.out.println("Player 1 press enter to end your turn or SNAP");
                String player1Input = scanner.nextLine().toUpperCase();
                if(Objects.equals(currentCard.getSymbol(), lastCard.getSymbol())) {
                    if(player1Input.equals("SNAP")) {
                        System.out.println("SNAP! PLAYER 1 WINS!");
                        break;
                    } else if (!Objects.equals(currentCard.getSymbol(), lastCard.getSymbol()) && player1.hasPlayerCards() && player2.hasPlayerCards()) {
                        String userInput2= scanner.nextLine().toUpperCase();
                        if(userInput2.equals("SNAP")){
                            System.out.println("YOU LOSE! That wasn't a SNAP - Goodbye...");
                        } else {
                            lastCard = currentCard;
//                            currentCard = player1.playCard();
                            currentPlayersTurn += 1;
                        }
                    }
                }

            //LOGIC FOR PLAYER 2's TURN
            } else if (currentPlayersTurn == 2) {
                System.out.println("Player 2 - it's your turn");
                currentCard = player2.playCard();
                System.out.println("Player 1 press enter to end your turn or SNAP");
                String player2Input = scanner.nextLine().toUpperCase();
                if(Objects.equals(currentCard.getSymbol(), lastCard.getSymbol())) {
                    if(player2Input.equals("SNAP")) {
                        System.out.println("SNAP! PLAYER 2 WINS!");
                        break;
                    } else if (!Objects.equals(currentCard.getSymbol(), lastCard.getSymbol()) && player1.hasPlayerCards() && player2.hasPlayerCards()) {
                        String userInput2= scanner.nextLine().toUpperCase();
                        if(userInput2.equals("SNAP")){
                            System.out.println("YOU LOSE! That wasn't a SNAP - Goodbye...");
                        } else {
                            lastCard = currentCard;
                            currentCard = player1.playCard();
                            currentPlayersTurn -= 1;
                        }
                    }
                }
            }
        }

//        int currentPlay = 1;
//        for(int card = 0; card <=52; card++) {
//            if(Objects.equals(currentCard.getSymbol(), lastCard.getSymbol())) {
//                if(userSelection1.equals("SNAP")) {
//                    System.out.println("YOU WIN");
//                } else if (!Objects.equals(currentCard.getSymbol(), lastCard.getSymbol()) && player1.hasPlayerCards() && player2.hasPlayerCards()) {
//                String userInput2= scanner.nextLine().toUpperCase();
//                if(userInput2.equals("SNAP")){
//                    System.out.println("YOU LOSE! That wasn't a SNAP - Goodbye...");
//                } else {
//                    lastCard = currentCard;
//                    currentCard = player1.playCard();
//                }
//            }
//        }}




//        //LOGIC FOR SINGLE PLAYER MODE
//        Card lastCard = deck.dealCard();
//        scanner.nextLine();
//        Card currentCard = deck.dealCard();

//        for(int card = 0; card <= 52; card++) {
//            if (Objects.equals(currentCard.getSymbol(), lastCard.getSymbol())) {
//                String userInput1 = scanner.nextLine().toUpperCase();
//                if(userInput1.equals("SNAP")){
//                    System.out.println("SNAP! YOU WIN");
//                } else {
//                    System.out.println("YOU LOSE - You missed a SNAP! Goodbye....");
//                }break;
//            } else if (!Objects.equals(currentCard.getSymbol(), lastCard.getSymbol()) && deckHasCards()) {
//                String userInput2= scanner.nextLine().toUpperCase();
//                if(userInput2.equals("SNAP")){
//                    System.out.println("YOU LOSE! That wasn't a SNAP - Goodbye...");
//                    break;
//                } else {
//                    lastCard = currentCard;
//                    currentCard = deck.dealCard();
//                }
//            } else if (!deckHasCards()) {
//                scanner.nextLine();
//                System.out.println("YOU LOSE! The deck is empty. Goodbye...");
//                break;
//            } else System.out.println("Sorry we have encountered an unforeseen error, please restart the game");;
//        }
//    }


    }
}