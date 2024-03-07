package no.ntnu.idatx2003.oblig3.cardgame.model;

import java.util.Collection;

/**
 * Class representing a hand of cards.
 */
public class HandOfCards {

  /**
   * The cards in the hand.
   */
  Collection<PlayingCard> cards;

  /**
   * Constructore for creating a new hand of cards based on a collection of cards.
   * @param cards the cards to be added to the hand.
   */
  public HandOfCards(Collection<PlayingCard> cards) {
    this.cards = cards;
  }

}
