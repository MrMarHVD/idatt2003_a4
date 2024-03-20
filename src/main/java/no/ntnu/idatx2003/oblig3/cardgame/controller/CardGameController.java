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

  /**
   * The UI.
   */
  private UserInterface ui;

  /**
   * The player's current hand.
   */
  private HandOfCards playerHand;

  /**
   * The deck.
   */
  private DeckOfCards deck;

  /**
   * Constructor.
   *
   * @param Ui the UI for this controller.
   * @param deck the deck for this controller
   */
  public CardGameController(UserInterface Ui, DeckOfCards deck) {
    this.ui = Ui;
    this.deck = deck;
    this.attachButtonHandlers();
  }

  /**
   * Attach the button handlers for the UI.
   */
  private void attachButtonHandlers() {
    ui.getDealHand().setOnAction(event -> {
        try {
          int handSize = Integer.parseInt(ui.getHandSize());
          if (handSize <= 4) {
            throw new IllegalArgumentException("Hand size must be greater than 5.");
          }
          else if (handSize > 52) {
            throw new IllegalArgumentException("Hand size cannot be greater than size of deck.");
          }
          playerHand = deck.dealHand(handSize);
        } catch (Exception e) {
          ui.getDisplayManager().displayError(e); // Display an error dialogue in the interface
    };
  });
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
