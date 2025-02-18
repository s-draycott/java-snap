# SNAP! ♠ ♥ ♣ ♦

## 💭 The Concept:

A java game for two players based on the common card game SNAP played within the command line.
Each player is dealt half of the shuffled card deck.
Players then take it in turns to either press enter (end their go and pass onto the next player) or type 'snap' if the current card and the previous card values match.
Each player has 3 seconds to make their move.
If either player runs out of cards before a SNAP is reached then it's a draw!

## 🏁 Getting Started:

-   To play the game, first the repository needs to be cloned and opened with your preferred IDE (e.g. IntelliJ).
-   The repository can be cloned using the following command

```console
git clone git@github.com:s-draycott/java-snap.git
```

-   Open the repository in your IDE and click the `Run` button within the `PlayCardGame.java` class.

## 🃏 Playing the Game:

-   Press `Run` button within the `PlayCardGame.java` class.
-   Once the game has started all controls can now be executed in the command line interface.
-   Instructions on how to play will be displayed.
-   Follow the prompts to shuffle and deal the deck between players
    -   Player 1 = 🔵
    -   Player 2 = 🟡
-   Players then take turns by pressing **enter** until their card value matches the value of the previous card
-   To win players must type **SNAP** (not case sensitive) if the value of their card matches the value of previous card.
-   Player will lose if they enter **SNAP** when values don't match, if they miss a **Snap** or if the timer runs out.
-   Players can then chose whether to **Play Again** or to exit.

## 🖥️ The Code Breakdown

### Create Deck of Cards:

-   Create **CardGame** class
    -   Create **ArrayList<Card>** of cards containg 52 cards which is created and populated when the game is contructed
    -   Create a **getDeck** method to list all of the cards in the deck
-   Create **Card** class
    -   **String suit** = unicode symbols ♥ ♦ ♣ ♠
    -   **String symbol** = number/face card name e.g. A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K.
    -   **Int value** = 2-14 (Ace = high)
    -   **toString** method that describes the class

### Adding Deal and Shuffle Methods:

-   **Card dealCard()** - Will take a card from the "top of the deck" and return it.
-   **ArrayList<Card> sortDeckNumberOrder()** - sorts deck in number order (e.g. 2♥ 2♦ 2♣ 2♠ 3♥ 3♦ 3♣ 3♠ ...) and stores the new shuffled deck BACK INTO the **deckOfCards** attribute
-   **ArrayList<Card> sortDeckIntoSuits()** - sorts deck into suite (2-A♥, 2-A♦ ...) and stores the new shuffled deck BACK INTO the **deckOfCards** attribute
-   **ArrayList<Card> shuffleDeck()** - shuffles the deck into a random order and stores the new shuffled deck BACK INTO the **deckOfCards** attribute.

### Enabling User Play

-   Create class **Snap** that **extends** the **CardGame** class.

### Game Flow:

1. Array of cards is created and populated
2. Deck is shuffled
3. User presses enter and first index of array (i.e. the top card) is drawn and printed
4. User presses enter again
5. If new card matches old card by SYMBOL then game over and player wins (or player has to enter SNAP)
6. If new card does not match old card then play continues (player will have to press enter again)
    #### Potential Problems
    - Perhaps need to add in a reshuffle deck function incase deck runs out before snap has happened.
    - Need to remove the card that has been drawn from the array so that is can't be played again (i.e. goes into a discard pile)
