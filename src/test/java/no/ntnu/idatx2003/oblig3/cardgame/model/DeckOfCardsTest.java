package no.ntnu.idatx2003.oblig3.cardgame.model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Test class for De
 *
 */
public class DeckOfCardsTest {

  /**
   * A deck of cards for testing.
   */
  private DeckOfCards deck;

  /**
   * Instantiate the testing deck before each test.
   */
  @BeforeEach
  void setUp() {
    this.deck = new DeckOfCards();
  }

  /**
   * Test constructor by creating deck equal to the deck obtained
   * and asserting the deck equal to it.
   */
  @Test
  void shouldCreateDeck() {
    ArrayList<PlayingCard> expectedDeck = new ArrayList<>();
    DeckOfCards deck = new DeckOfCards();
    char[] testSuits = new char[]{'S', 'H', 'D', 'C'};
    int[] testFaces = new int[13];
    for (int i = 1; i < 14; i++) {
      testFaces[i-1] = i;
    }
    for (char s : testSuits) {
      for (int i : testFaces) {
        expectedDeck.add(new PlayingCard(s, i));
      }
    }
    Assertions.assertIterableEquals(deck.getCards(), expectedDeck);
  }

  /**
   * Test whether dealHand deals a hand properly by asserting that the number of cards in the
   * hand is equal to the number of cards it was instantiated with, and then ensuring that
   * no two cards are identical.
   */
  @Test
  void shouldDealHand() {
    int n = 5;
    HandOfCards hand = this.deck.dealHand(n);
    ArrayList<PlayingCard> distinctCards = hand.getCards().stream().distinct().collect(
        Collectors.toCollection(ArrayList::new));

    Assertions.assertEquals(hand.getCards().size(), n);
    Assertions.assertEquals(distinctCards.size(), hand.getCards().size());
  }

  /**
   * Test whether getSuit() works properly by asserting that the returned array
   * contains the characters of the field array in the same order.
   */
  @Test
  void shouldReturnSuit() {
    ArrayList<Character> suits = IntStream.range(0, this.deck.getSuit().length)
        .mapToObj(i -> this.deck.getSuit()[i])
        .collect(Collectors.toCollection(ArrayList::new));

    Assertions.assertEquals(suits.get(0), 'S');
    Assertions.assertEquals(suits.get(1), 'H');
    Assertions.assertEquals(suits.get(2), 'D');
    Assertions.assertEquals(suits.get(3), 'C');
  }

  /**
   * Test whether the getFaces()-method returns correctly by
   * using streams to create two lists: one from the array returned by the
   * getFaces()-method, and another containing the numbers from 1 through 13, then
   * comparing these.
   */
  @Test
  void shouldReturnFace() {
    ArrayList<Integer> faces = IntStream.range(0, this.deck.getFaces().length)
        .mapToObj(i -> this.deck.getFaces()[i])
        .collect(Collectors.toCollection(ArrayList::new));

    ArrayList<Integer> numbers = IntStream.range(0, 13).mapToObj(i -> i + 1).
        collect(Collectors.toCollection(ArrayList::new));

    Assertions.assertIterableEquals(numbers, faces);
  }

  /**
   * Ensure that exception is thrown when negative hand is dealt.
   */
  @Test
  void shouldThrowExceptionWhenDealHandWithNegativeNumber() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      this.deck.dealHand(-1);
    });
  }

  /**
   * Assert that exception is thrown when hand larger than 52 is dealt.
   */
  @Test
  void shouldThrowExceptionWhenDealHandWithNumberGreaterThanDeckSize() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      this.deck.dealHand(53); // deck size is 52
    });
  }



}
