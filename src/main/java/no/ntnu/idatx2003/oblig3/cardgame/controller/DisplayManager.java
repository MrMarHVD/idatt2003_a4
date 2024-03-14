package no.ntnu.idatx2003.oblig3.cardgame.controller;

import java.util.stream.IntStream;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import no.ntnu.idatx2003.oblig3.cardgame.model.HandOfCards;
import no.ntnu.idatx2003.oblig3.cardgame.model.PlayingCard;
import no.ntnu.idatx2003.oblig3.cardgame.view.UserInterface;

/**
 * Class for managing the logic behind displaying cards in the UI.
 */
public class DisplayManager {

  private UserInterface ui;

  public DisplayManager(UserInterface ui) {
    this.ui = ui;
  }

  /**
   * Display the cards in the deck in the grid pane, and check for any changes to the information
   * about the cards such as flush etc.
   *
   * @param hand the hand the cards are in.
   */
  public void displayHand(HandOfCards hand) {
    ui.getCardPane().getChildren().clear(); // Clear the GridPane

    IntStream.range(0, hand.getCards().size()).forEach(i -> {
      PlayingCard card = hand.getCards().get(i);
      String imagePath = "/images/" + card.getAsString() + ".png";
      Image image = new Image(imagePath);
      ImageView imageView = new ImageView(image);
      imageView.setFitWidth(100);
      imageView.setFitHeight(150);
      imageView.setPreserveRatio(true);
      ui.getCardPane().add(imageView, i % 5, i / 5); // Add the ImageView to the GridPane
    });
  }

}
