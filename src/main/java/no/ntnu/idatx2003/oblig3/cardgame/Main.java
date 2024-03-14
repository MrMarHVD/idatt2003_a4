package no.ntnu.idatx2003.oblig3.cardgame;

import no.ntnu.idatx2003.oblig3.cardgame.controller.CardGameController;
import no.ntnu.idatx2003.oblig3.cardgame.model.DeckOfCards;
import no.ntnu.idatx2003.oblig3.cardgame.model.HandOfCards;
import no.ntnu.idatx2003.oblig3.cardgame.view.UserInterface;

/**
 * Main class for this application.
 */
public class Main {

  public static void main(String[] args) {
    DeckOfCards deck = new DeckOfCards();
    UserInterface ui = new UserInterface();
    HandOfCards hand = deck.dealHand(40);
    for (int i = 0; i < hand.getCards().size(); i++) {
      System.out.println(hand.getCards().get(i).getAsString());
    }
    UserInterface.main(args);
  }
}