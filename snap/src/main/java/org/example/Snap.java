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
    private boolean timerEnd;
    private String playerColour;

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
                    timerEnd = true;
                    System.out.println("\n⌛ ⌛ ⌛ ⌛ ⌛ ⌛ ⌛ ⌛ ⌛\n TIME'S UP. YOU LOSE\n⌛ ⌛ ⌛ ⌛ ⌛ ⌛ ⌛ ⌛ ⌛");
                    System.out.println("Press Enter for options...");

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

        System.out.println("\n♠ ♥ ♦ ♣ ♠ ♥ ♦ ♣ ♠ ♥\n♦ Welcome to SNAP! ♠\n♥ ♠ ♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠\n");
        System.out.println("THE RULES:\n⮞Press enter on your turn to draw the next card or type 'SNAP' if two card values match!\n⮞⮞i.e. 2 ♥ and 2 ♠ = SNAP!\n⌛ You have 3 seconds to take your turn. Take too long and you will lose ❌");

        System.out.println("\nOK let's get started...\nPress enter to shuffle the deck...");
        scanner.nextLine();
        deck.shuffleDeck();

        System.out.println("Press enter to deal the cards between 2 players");
        scanner.nextLine();
        deck.dealDeck(deck, player1, player2);

        System.out.println("You are ready to play!\nPress enter to start the game...");
        scanner.nextLine();

        currentPlayersTurn = 1;
        lastCard = new Card(null, null, 0);
        currentCard = lastCard;
    }

    public boolean checkPlayerWon(int currentPlayerTurn) {
        timerEnd = false;
        String userInput;
        System.out.printf("%s Player %d - Your card is: ",currentPlayerColour(), currentPlayerTurn);

        //Ensures the correct person is playing a card from the correct persons deck.
        if (currentPlayerTurn == 1) {
            currentCard = player1.playCard();
        } else if (currentPlayerTurn == 2) {
            currentCard = player2.playCard();
        }

        System.out.printf("Player %d press enter to end your turn or SNAP\n", currentPlayerTurn);

        //logic for if the current and previous cards match
        if (Objects.equals(currentCard.getSymbol(), lastCard.getSymbol())) {
            Timer timer1 = new Timer();
            startTimer(3, timer1);
            userInput = scanner.nextLine();
            if (userInput.toUpperCase().equals("SNAP")) {
                timer1.cancel();
                System.out.printf("\n⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐\n %s SNAP! PLAYER %d WINS! %s\n⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐\n",currentPlayerColour(), currentPlayerTurn, currentPlayerColour());
                return true;
            } else {
                timer1.cancel();
                System.out.printf("❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌\n %s PLAYER %d LOSES - You missed a SNAP! %s\n❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌\n",currentPlayerColour(), currentPlayerTurn, currentPlayerColour());
                return true;
            }
        //logic for if the current and previous cards do NOT match
        } else if (!Objects.equals(currentCard.getSymbol(), lastCard.getSymbol()) && player2.hasPlayerCards()) {
            Timer timer2 = new Timer();
            startTimer(3, timer2);
            userInput = scanner.nextLine();
            if (userInput.toUpperCase().equals("SNAP")) {
                timer2.cancel();
                System.out.printf("\n❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌\n%s PLAYER %d LOSES! That wasn't a SNAP! %s\n❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌❌\n",currentPlayerColour(), currentPlayerTurn, currentPlayerColour());
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
            System.out.println("IT'S A DRAW! \uD83D\uDD35 \uD83D\uDFE1 You have ran out of cards before reaching a SNAP!\nGoodbye...");
            return true;
        }
        return false;
    }

    public void playSnap() {
        while (player2.hasPlayerCards()) {
            if (checkPlayerWon(currentPlayersTurn) || timerEnd) {
                System.out.println("\n GAME OVER - What would you like to do?\n1. Play again?\nor press ENTER to Exit...");
                restartGame();
            }
        }
    }

    public void restartGame() {
        String userInput = scanner.nextLine();
        if(Objects.equals(userInput, "1")){
            snapIntro();
            playSnap();
        } else if (Objects.equals(userInput, "2"));
        System.exit(0);
    }

    public String currentPlayerColour(){
        if(currentPlayersTurn ==1){
            return playerColour = "\uD83D\uDD35";
        } else {
            return playerColour = "\uD83D\uDFE1";
        }
    }
}


