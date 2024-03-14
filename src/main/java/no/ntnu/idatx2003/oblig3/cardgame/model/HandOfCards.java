package no.ntnu.idatx2003.oblig3.cardgame.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class representing a hand of cards.
 */
public class HandOfCards {

  /**
   * The cards in the hand.
   */
  Collection<PlayingCard> cards;

  /**
   * Parameterized for creating a new hand of cards based on a collection of cards.
   *
   * @param cards the cards to be added to the hand.
   */
  public HandOfCards(Collection<PlayingCard> cards) {
    this.cards = cards;
  }

  /**
   * Check whether a flush is present in the hand of cards.
   *
   * @return a boolean representing whether a flush is present.
   */
  public boolean checkFlush() {
    Map<Character, Long> suitCounts = cards.stream()
        .collect(java.util.stream.Collectors.
            groupingBy(PlayingCard::getSuit, java.util.stream.Collectors.counting()));
    return suitCounts.values().stream().anyMatch(count -> count >= 5);
  }

  /**
   * Get the sum of the faces on the cards in the hand.
   *
   * @return the sum of the faces.
   */
  public int getSumOfFaces() {
    return cards.stream().mapToInt(PlayingCard::getFace).sum();
  }

  /**
   * Get all the cards that are hearts.
   *
   * @return an ArrayList containing the cards that are hearts.
   */
  public ArrayList<String> getHearts() {
    return cards.stream().filter(card -> card.getSuit() == 'H').
        map(PlayingCard::getAsString).collect(Collectors.toCollection(ArrayList::new));
  }

  /**
   * Get the cards in the hand.
   *
   * @return the cards in the hand
   */
  public ArrayList<PlayingCard> getCards() {
    return new ArrayList<>(cards);
  }

  /**
   * Check if the hand contains a specific card.
   *
   * @return the truth value.
   */
  public boolean containsCard(char suit, int face) {
    return cards.stream().anyMatch(card -> card.getSuit() == suit && card.getFace() == face);
  }
}
