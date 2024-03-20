package no.ntnu.idatx2003.oblig3.cardgame.model;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for HandOfCards.
 */
public class HandOfCardsTest {

  private DeckOfCards deck;
  private HandOfCards hand;

  /**
   * Set up: instantiate deck and hand.
   */
  @BeforeEach
  void setUp() {
    this.deck = new DeckOfCards();
    this.hand = deck.dealHand(5);
  }

  /**
   * Test whether a hand consisting of all cards in the deck
   * indeed contains a flush.
   */
  @Test
  void shouldAffirmFlush() {
    HandOfCards testHand = this.deck.dealHand(52);
    Assertions.assertTrue(testHand.checkFlush());
  }

  /**
   * Check whether a hand containing less than five cards contains
   * a flush.
   */
  @Test
  void shouldDenyFlush() {
    HandOfCards testHand = this.deck.dealHand(4);
    Assertions.assertFalse(testHand.checkFlush());
  }

  /**
   * Test whether the faces of a full deck
   * of cards is summed correctly.
   */
  @Test
  void sumShouldBeCorrect() {
    HandOfCards testHand = deck.dealHand(52);
    Assertions.assertEquals(364, testHand.getSumOfFaces());
  }

}
