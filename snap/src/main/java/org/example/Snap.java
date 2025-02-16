package org.example;

import java.util.*;

public class Snap extends CardDeck {
    private Scanner scanner;
    private Player player1;
    private Player player2;
    private int currentPlayersTurn;
    private Card currentCard;
    private Card lastCard;
    private final CardDeck deck = new CardDeck();
    private Timer timer1 = new Timer();

    public Snap() {
        super();
    }

    public void startTimer(int timerSeconds, Timer timer) {
        TimerTask task = new TimerTask() {
            int time = timerSeconds;
            @Override
            public void run() {
                time--;
                if (time == 0) {
                    timer.cancel();
                    System.out.println("\n⌛ ⌛ ⌛ ⌛ ⌛ ⌛ ⌛ ⌛ ⌛ ⌛ ⌛ ⌛ ⌛ ⌛\n⌛ TIME'S UP. YOU LOSE! Goodbye...⌛\n⌛ ⌛ ⌛ ⌛ ⌛ ⌛ ⌛ ⌛ ⌛ ⌛ ⌛ ⌛ ⌛ ⌛");
                    System.exit(0);
                }
            }
        };
        timer.schedule(task, 0, 1000);
    }

    public void snapIntro() {
        player1 = new Player();
        player2 = new Player();

        scanner = new Scanner(System.in);
        deck.generateCardDeck();

        System.out.println("\n♠ ♥ ♦ ♣ ♠ ♥ ♦ ♣ ♠ ♥\n♦ Welcome to SNAP! ♠\n♥ ♠ ♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠\nYour card deck has been generated.");
        System.out.println("Press enter to shuffle the deck...");
        scanner.nextLine();
        deck.shuffleDeck();

        System.out.println("Press enter to deal the cards between 2 players");
        scanner.nextLine();
        deck.dealDeck(deck, player1, player2);

        System.out.println("You are ready to play Snap!\n\nBut first THE RULES:\nPress enter on your turn to draw the next card or type 'SNAP' if two card values match!\ni.e. 2 ♥ and 2 ♠ = SNAP!\n");
        System.out.println("Press enter to start the game...");
        scanner.nextLine();

        currentPlayersTurn = 1;
        lastCard = new Card(null, null, 0);
        currentCard = lastCard;
    }

    public boolean checkPlayerWon(int currentPlayerTurn) {
        String userInput;
        System.out.printf("Player %d - Your card is:\n", currentPlayerTurn);

        //Ensures the correct person is playing a card from the correct persons deck.
        if (currentPlayerTurn == 1) {
            currentCard = player1.playCard();
        } else if (currentPlayerTurn == 2) {
            currentCard = player2.playCard();
        }

        System.out.printf("Player %d press enter to end your turn or SNAP\n", currentPlayerTurn);

        //logic for if the current and previous cards match
        if (Objects.equals(currentCard.getSymbol(), lastCard.getSymbol())) {
            startTimer(5, timer1);
            userInput = scanner.nextLine();
            if (userInput.toUpperCase().equals("SNAP")) {
                timer1.cancel();
                System.out.printf("\n⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐\n⭐ SNAP! PLAYER %d WINS! ⭐\n⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐\n", currentPlayerTurn);
                return true;
            } else {
                timer1.cancel();
                System.out.printf("❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌\n PLAYER %d LOSES - You missed a SNAP! Goodbye...\n❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌\n", currentPlayerTurn);
                return true;
            }
        //logic for if the current and previous cards do NOT match
        } else if (!Objects.equals(currentCard.getSymbol(), lastCard.getSymbol()) && player2.hasPlayerCards()) {
            Timer timer2 = new Timer();
            startTimer(5, timer2);
            userInput = scanner.nextLine();
            if (userInput.toUpperCase().equals("SNAP")) {
                timer2.cancel();
                System.out.printf("\n❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌\nPLAYER %d LOSES! That wasn't a SNAP - Goodbye... \n❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌\n", currentPlayerTurn);
                return true;
            } else {
                lastCard = currentCard;
                if (currentPlayerTurn == 1) {
                    timer2.cancel();
                    currentPlayersTurn += 1;
                } else if (currentPlayerTurn == 2) {
                    timer2.cancel();
                    currentPlayersTurn -= 1;
                }
            }
        //logic for if player 1 runs out of cards (player 1 will always run out first)
        } else if (!player1.hasPlayerCards()) {
            System.out.println("IT'S A DRAW! You have ran out of cards before reaching a SNAP!\nGoodbye...");
            return true;
        }
        return false;
    }

    public void playSnap() {
        while (player2.hasPlayerCards()) {
            if (checkPlayerWon(currentPlayersTurn)) {
               System.exit(0);
            }
        }
    }
}


