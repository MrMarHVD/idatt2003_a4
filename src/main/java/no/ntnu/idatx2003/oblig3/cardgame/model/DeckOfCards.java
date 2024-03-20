package no.ntnu.idatx2003.oblig3.cardgame.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * Class representing a deck of cards.
 */
public class DeckOfCards {

  /**
   * The possible card suits.
   */
  private final char[] suit = {'S', 'H', 'D', 'C'};

  /**
   * The possible card numbers.
   */
  private final int[] face = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

  /**
   * The cards in the deck.
   */
  private ArrayList<PlayingCard> cards;

  /**
   * Default constructor. Creates a full deck of playing cards.
   */
  public DeckOfCards() {
    cards = new ArrayList<>();
    for (char s : suit) {
      for (int f : face) {
        cards.add(new PlayingCard(s, f));
      }
    }
  }

  /**
   * Deals a random hand of n cards.
   *
   * @param n number of cards in the hand.
   * @return the resulting collection of cards.
   */
  public HandOfCards dealHand(int n) throws IllegalArgumentException {
    Collection<PlayingCard> hand = new ArrayList<PlayingCard>();

    if (n > 52 || n < 0) {
      throw new IllegalArgumentException("Cannot deal a hand with more cards than the deck,"
          + "or less than 0.");
    } else {
        ArrayList<PlayingCard> temp = new ArrayList<>(cards); // Temporary copy of the deck
        Random rand = new Random();
        int bound = 52;
        // Deal n cards
        for (int i = 0; i < n; i++) {
          int randomNumber = rand.nextInt(bound - i);
          hand.add(cards.get(randomNumber));
          cards.remove(randomNumber);
        }
        cards = temp; // Return the deck to its original state
      }
    return new HandOfCards(hand);
  }

  /**
   * Get all the cards in the deck.
   *
   * @return the cards
   */
  public ArrayList<PlayingCard> getCards() { return this.cards; }

  /**
   * Get the table of suits.
   *
   * @return the table of suits.
   */
  public char[] getSuit() {
    return this.suit;
  }

  /**
   * Get the table of faces.
   *
   * @return the table of faces.
   */
  public int[] getFaces() {
    return this.face;
  }

}
