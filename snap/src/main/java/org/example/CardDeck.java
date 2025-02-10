package org.example;
import java.util.*;

public class CardDeck {
    private final ArrayList<Card> deckOfCards = new ArrayList<>(52);

    public void getDeck() {
        System.out.println("Here's your deck of cards:");
        for (Card card : deckOfCards) {
            System.out.println(card);
        }
    }

    public Card dealCard() {
//        System.out.println("Here's the card from the top of the deck");
        if(!deckOfCards.isEmpty()){
            System.out.println(deckOfCards.getFirst());
            return deckOfCards.removeFirst();
        } else return null;
    }

    public void shuffleDeck() {
        Collections.shuffle(deckOfCards);
        System.out.println("The deck has been shuffled");
    }

    public void sortDeckInNumberOrder(){
        deckOfCards.sort(new CardValueComparator());
        System.out.println("Deck has been shuffled into number order");
    }

    public void sortDeckInSuitOrder() {
        deckOfCards.sort(new CardValueComparator());
        deckOfCards.sort(new CardSuitComparator());
        System.out.println("Deck has been shuffled into suit order");
    }

    static Scanner scanner = new Scanner(System.in);
    public CardDeck() {
        System.out.println("Welcome to Snap!");
        deckOfCards.add(new Card("♥", "2", 2));
        deckOfCards.add(new Card("♥", "3", 3));
        deckOfCards.add(new Card("♥", "4", 4));
        deckOfCards.add(new Card("♥", "5", 6));
        deckOfCards.add(new Card("♥", "6", 6));
        deckOfCards.add(new Card("♥", "7", 7));
        deckOfCards.add(new Card("♥", "8", 8));
        deckOfCards.add(new Card("♥", "9", 9));
        deckOfCards.add(new Card("♥", "10", 10));
        deckOfCards.add(new Card("♥", "J", 11));
        deckOfCards.add(new Card("♥", "Q", 12));
        deckOfCards.add(new Card("♥", "K", 13));
        deckOfCards.add(new Card("♥", "A", 14));
        deckOfCards.add(new Card("♦", "2", 2));
        deckOfCards.add(new Card("♦", "3", 3));
        deckOfCards.add(new Card("♦", "4", 4));
        deckOfCards.add(new Card("♦", "5", 6));
        deckOfCards.add(new Card("♦", "6", 6));
        deckOfCards.add(new Card("♦", "7", 7));
        deckOfCards.add(new Card("♦", "8", 8));
        deckOfCards.add(new Card("♦", "9", 9));
        deckOfCards.add(new Card("♦", "10", 10));
        deckOfCards.add(new Card("♦", "J", 11));
        deckOfCards.add(new Card("♦", "Q", 12));
        deckOfCards.add(new Card("♦", "K", 13));
        deckOfCards.add(new Card("♦", "A", 14));
        deckOfCards.add(new Card("♣", "2", 2));
        deckOfCards.add(new Card("♣", "3", 3));
        deckOfCards.add(new Card("♣", "4", 4));
        deckOfCards.add(new Card("♣", "5", 6));
        deckOfCards.add(new Card("♣", "6", 6));
        deckOfCards.add(new Card("♣", "7", 7));
        deckOfCards.add(new Card("♣", "8", 8));
        deckOfCards.add(new Card("♣", "9", 9));
        deckOfCards.add(new Card("♣", "10", 10));
        deckOfCards.add(new Card("♣", "J", 11));
        deckOfCards.add(new Card("♣", "Q", 12));
        deckOfCards.add(new Card("♣", "K", 13));
        deckOfCards.add(new Card("♣", "A", 14));
        deckOfCards.add(new Card("♠", "2", 2));
        deckOfCards.add(new Card("♠", "3", 3));
        deckOfCards.add(new Card("♠", "4", 4));
        deckOfCards.add(new Card("♠", "5", 6));
        deckOfCards.add(new Card("♠", "6", 6));
        deckOfCards.add(new Card("♠", "7", 7));
        deckOfCards.add(new Card("♠", "8", 8));
        deckOfCards.add(new Card("♠", "9", 9));
        deckOfCards.add(new Card("♠", "10", 10));
        deckOfCards.add(new Card("♠", "J", 11));
        deckOfCards.add(new Card("♠", "Q", 12));
        deckOfCards.add(new Card("♠", "K", 13));
        deckOfCards.add(new Card("♠", "A", 14));

        System.out.println("Press enter to shuffle the deck");
        String userInput = scanner.nextLine();
        shuffleDeck();

        System.out.println("You are ready to play Snap! \nPress enter to draw the first card");
        String userInput2 = scanner.nextLine();
        Card lastCard = dealCard();
        System.out.println("Press enter to draw next card");
        String userInput3 = scanner.nextLine();
        Card currentCard = dealCard();

        for(int card = 0; card < 53; card++) {
            if (currentCard.getSymbol() == lastCard.getSymbol()) {
                System.out.println("SNAP! YOU WIN");
                break;
            } else if (currentCard.getSymbol() != lastCard.getSymbol() && !deckOfCards.isEmpty()) {
                lastCard = currentCard;
                System.out.println("Press enter to draw next card");
                String userInput4 = scanner.nextLine();
                currentCard = dealCard();
            } else if (deckOfCards.isEmpty()) {
                System.out.println("Press enter to draw next card");
                String userInput5 = scanner.nextLine();
                System.out.println("YOU LOSE! The deck is empty. Goodbye...");
                break;
            } else System.out.println("Sorry we have encountered an unforeseen error, please restart the game");;
        }

    }
}
