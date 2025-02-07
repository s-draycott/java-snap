# SNAP!

##The Concept
A java based game of snap where a deck of cards is shuffled and revealed one by one until the player gets a SNAP! 
SIMPLE: Player wins when card drawn matches the previous card by number or suit automatically 
HARDER: Player wins when card drawn matches the previous card but ONLY if they type SNAP in the command line.
EVEN HARDER: As in HARDER but a timer is in place for how long player has to call snap.
POTENITAL EXTENSION: Enable two player functionality.

## The Breakdown
### Create Deck of Cards:
- [] Create **CardGame** class
  - [] Create **ArrayList<Card>** of cards containg 52 cards which is created and populated when the game is contructed
  - [] Has a **name** which is defined in the constructor??
  - [] Create a **getDeck** method to list all of the cards in the deck
- [] Create **Card** class
  - [] Create deckOfCards attribute with the following fields
      - [] **String suit** = unicode symbols ♥ ♦ ♣ ♠
      - [] **String symbol** = number/face card name e.g. A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K.
      - [] **Int value** = 2-14 (Ace = high)
      - [] **toString** method that describes the class
### Adding Deal and Shuffle Methods:
- [] **Card dealCard()** - Will take a card from the "top of the deck" and return it.
- [] **ArrayList<Card> sortDeckNumberOrder()** - sorts deck in number order (e.g. 2♥ 2♦ 2♣ 2♠ 3♥ 3♦ 3♣ 3♠ ...) and stores the new shuffled deck BACK INTO the **deckOfCards** attribute
- [] **ArrayList<Card> sortDeckIntoSuits()** - sorts deck into suite (2-A♥, 2-A♦ ...) and stores the new shuffled deck BACK INTO the **deckOfCards** attribute
- [] **ArrayList<Card> shuffleDeck()** - shuffles the deck into a random order and stores the new shuffled deck BACK INTO the **deckOfCards** attribute.
### Enabling User Play
- [] Create class **Snap** that **extends** the **CardGame** class.

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



