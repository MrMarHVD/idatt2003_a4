package no.ntnu.idatx2003.oblig3.cardgame.controller;

import no.ntnu.idatx2003.oblig3.cardgame.model.HandOfCards;
import no.ntnu.idatx2003.oblig3.cardgame.view.UserInterface;

/**
 * Class for managing the logic behind displaying cards in the UI.
 */
public class DisplayManager {

  private UserInterface ui;

  public DisplayManager(UserInterface ui) {
    this.ui = ui;
  }

  public void displayHand(HandOfCards hand) {
    ui.getCardPane().getChildren().clear();


  }

}
