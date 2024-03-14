package no.ntnu.idatx2003.oblig3.cardgame.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import no.ntnu.idatx2003.oblig3.cardgame.model.DeckOfCards;
import no.ntnu.idatx2003.oblig3.cardgame.model.HandOfCards;
import no.ntnu.idatx2003.oblig3.cardgame.view.UserInterface;

/**
 * Controller for managing the card game.
 */
public class CardGameController {

  private UserInterface ui;

  private HandOfCards playerHand;

  private DeckOfCards deck;

  public CardGameController(UserInterface Ui, DeckOfCards deck) {
    this.ui = Ui;
    this.deck = deck;
    this.attachButtonHandlers();
  }

  /**
   * Attach the button handlers for the UI.
   */
  private void attachButtonHandlers() {
    ui.getDealHand().setOnAction(event -> playerHand = deck.dealHand(5));
    ui.getCheckHand().setOnAction(event -> ui.getDisplayManager().displayHand(playerHand));
  }

  /**
   * Set the current player hand.
   *
   * @param hand the hand to set.
   */
  public void setHand(HandOfCards hand) {
    this.playerHand = hand;
  }

}
