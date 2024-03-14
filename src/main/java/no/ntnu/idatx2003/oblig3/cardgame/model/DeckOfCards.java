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
  private final ArrayList<PlayingCard> cards;

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
   * @param n number of cards in the hand.
   * @return the resulting collection of cards.
   */
  public HandOfCards dealHand(int n) {
    Collection<PlayingCard> hand = new ArrayList<PlayingCard>();
    Random rand = new Random();

    // Deal n cards
    for (int i = 0; i < n; i++) {
      int randomNumber = rand.nextInt(52);
      hand.add(cards.get(randomNumber));
      cards.remove(randomNumber);
    }

    return new HandOfCards(hand);
  }

}
