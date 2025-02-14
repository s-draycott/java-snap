package org.example;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Timer;

public class Snap extends CardDeck {
    private Scanner scanner;
    private Player player1;
    private Player player2;
    private int currentPlayersTurn;
    private Card currentCard;
    private Card lastCard;
    private final CardDeck deck = new CardDeck();

    // Having constructor opens possibility to add extra field to child class
    public Snap() {
        super();
    }

    public void startSnap() {
        player1 = new Player();
        player2 = new Player();

        scanner = new Scanner(System.in);
        deck.generateCardDeck();

        System.out.println("\n♠ ♥ ♦ ♣ ♠ ♥ ♦ ♣ ♠ ♥\n♦ Welcome to SNAP! ♠\n♥ ♠ ♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠\nYour card deck has been generated.");
        System.out.println("Press enter to shuffle the deck...");
        String userInput = scanner.nextLine();
        deck.shuffleDeck();

        System.out.println("Press enter to deal the cards between 2 players");
        scanner.nextLine();
        deck.dealDeck(deck, player1, player2);

        System.out.println("You are ready to play Snap!\nBut first THE RULES:\nPress enter on your turn to draw the next card or type 'SNAP' if two card values match!");
        System.out.println("Press enter to start the game...");
        scanner.nextLine();

        currentPlayersTurn = 1;
        GameTimer timer = new GameTimer();
        lastCard = new Card(null, null, 0 );
        currentCard = lastCard;
    }


    public boolean checkPlayerWon(int currentPlayerTurn, Player currentPlayer, Player otherPlayer) {
        System.out.printf("Player %d - Your card is:\n", currentPlayerTurn);
        currentCard = currentPlayer.playCard();
//                timer.startTimer();
        System.out.printf("Player %d press enter to end your turn or SNAP\n", currentPlayerTurn);
        String userInput;
        if(Objects.equals(currentCard.getSymbol(), lastCard.getSymbol())) {
            userInput = scanner.nextLine().toUpperCase();
            if (userInput.equals("SNAP")) {
                System.out.printf("\n⭐ ⭐ ⭐ ⭐ ⭐ ⭐ ⭐\n SNAP! PLAYER %d WINS! \n⭐ ⭐ ⭐ ⭐ ⭐ ⭐ ⭐\n", currentPlayerTurn);
                return true;
            } else {
                System.out.printf("PLAYER %d LOSES ☠ - YOU MISSED A SNAP! Goodbye...\n", currentPlayerTurn);
                return true;
            }
        } else if (!Objects.equals(currentCard.getSymbol(), lastCard.getSymbol()) && currentPlayer.hasPlayerCards() && otherPlayer.hasPlayerCards()) {
            userInput = scanner.nextLine().toUpperCase();
            if(userInput.equals("SNAP")){
                System.out.printf("PLAYER %d LOSES! That wasn't a SNAP - Goodbye...\n", currentPlayerTurn);
                System.out.println(currentPlayersTurn);
                return true;
            } else {
                lastCard = currentCard;
                if (currentPlayerTurn == 1){
                    currentPlayersTurn += 1;
                } else if (currentPlayersTurn == 2) {
                    currentPlayersTurn -= 1;
                }
            }
        }  else if(!player1.hasPlayerCards()) {
        scanner.nextLine();
        System.out.println("IT'S A DRAW! You have ran out of cards before reaching a SNAP!");
        return true;
    } return false;
    };

    public void playSnap() {
        while (player1.hasPlayerCards() && player2.hasPlayerCards()) {
            //LOGIC FOR PLAYER 1s TURN
            if(currentPlayersTurn == 1) {
                System.out.println("player 1s turn if statement");
//                checkPlayerWon(currentPlayersTurn, player1, player2);
                if(checkPlayerWon(currentPlayersTurn, player1, player2)) {
                    System.out.println("executed1");
                    break;
                } else if (checkPlayerWon(currentPlayersTurn, player2, player1)) {
                    System.out.println("executed 1a");
                    break;
                }
//            } else if (currentPlayersTurn == 2) {
//                System.out.println("player 2s turn if statement");
////                checkPlayerWon(currentPlayersTurn, player2, player1);
//                if(checkPlayerWon(currentPlayersTurn, player2, player1)) {
//                    System.out.println("executed 2");
//                    break;
//                }else if (checkPlayerWon(currentPlayersTurn, player1, player2))
//                    break;
            } else System.out.println("executed 3");;
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
//
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