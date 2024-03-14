package no.ntnu.idatx2003.oblig3.cardgame.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import no.ntnu.idatx2003.oblig3.cardgame.controller.DisplayManager;

/**
 * Class representing the user interface for the card game.
 */
public class UserInterface extends Application {

  /**
   * Display Manager for this user interface.
   */
  private DisplayManager displayManager;

  /**
   * The VBox containing the entire UI.
   */
  private VBox UiDisplay;

  /**
   * The outer VBox containing the gridpane showing the cards.
   */
  private VBox cardDisplay;

  /**
   * The gridpane for displaying images of cards.
   */
  private GridPane cardPane;

  /**
   * The HBox containing the lower part of the UI.
   */
  private HBox lowerDisplay;

  /**
   * The HBox containing the componends in the lower left.
   */
  private HBox lowerLeftDisplay;

  /**
   * The VBox containing the components in the lower right.
   */
  private VBox lowerRightDisplay;

  /**
   * The Label for displaying the sum of the faces of the cards.
   */
  private Label facesSum;

  /**
   * The label for displaying the cards which are hearts.
   */
  private Label cardsOfHearts;

  /**
   * The Label for displaying if the hand is a flush or not.
   */
  private Label flush;

  /**
   * The Label for displaying if the hand contains the queen of spades or not.
   */
  private Label queenOfSpades;

  /**
   * The Button to deal a hand.
   */
  private Button dealHand;

  /**
   * The Button to check the hand.
   */
  private Button checkHand;


  /**
   * Start method for the application and UI.
   * @param primaryStage the stage
   */
  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Card Game");

    this.createUI();
    Scene scene = new Scene(UiDisplay, 800, 600);

    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * Main method for the application.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

  /**
   * Create and set the bounds and properties of the UI.
   */
  private void createUI() {
    facesSum = new Label("25");
    cardsOfHearts = new Label("H1");
    flush = new Label("No");
    queenOfSpades = new Label("No");
    dealHand = new Button("Deal Hand");
    checkHand = new Button("Check Hand");
    cardPane = new GridPane();
    cardDisplay = new VBox(cardPane);
    lowerLeftDisplay = new HBox(facesSum, cardsOfHearts, flush, queenOfSpades);
    lowerRightDisplay = new VBox(dealHand, checkHand);
    lowerDisplay =  new HBox(lowerLeftDisplay, lowerRightDisplay);
    UiDisplay = new VBox(cardDisplay, lowerDisplay);
  }


}