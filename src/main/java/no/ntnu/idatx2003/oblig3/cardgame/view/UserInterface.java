package no.ntnu.idatx2003.oblig3.cardgame.view;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import no.ntnu.idatx2003.oblig3.cardgame.controller.CardGameController;
import no.ntnu.idatx2003.oblig3.cardgame.controller.DisplayManager;
import javafx.scene.control.Separator;
import no.ntnu.idatx2003.oblig3.cardgame.model.DeckOfCards;

/**
 * Class representing the user interface for the card game.
 */
public class UserInterface extends Application {

  /**
   * The scene for the user interface.
   */
  private Scene scene;

  /**
   * Display Manager for this user interface.
   */
  private DisplayManager displayManager;

  /**
   * The card game controller for this user interface.
   */
  private CardGameController controller;

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
    this.controller = new CardGameController(this, new DeckOfCards());
    this.displayManager = new DisplayManager(this);

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

    /* Initialise the components */

    // Sum of faces
    facesSum = new Label("25");
    facesSum.setMinWidth(30);
    Label facesSumLabel = new Label("Sum of Faces: ");
    HBox facesSumBox = new HBox(facesSumLabel, facesSum);

    // Cards of hearts
    cardsOfHearts = new Label("H1");
    cardsOfHearts.setMinWidth(30);
    Label cardsOfHeartsLabel = new Label("Cards of Hearts: ");
    HBox cardsOfHeartsBox = new HBox(cardsOfHeartsLabel, cardsOfHearts);

    // Flush
    flush = new Label("No");
    flush.setMinWidth(30);
    Label flushLabel = new Label("Flush: ");
    HBox flushBox = new HBox(flushLabel, flush);

    // Queen of spades
    queenOfSpades = new Label("No");
    queenOfSpades.setMinWidth(30);
    Label queenOfSpadesLabel = new Label("Queen of Spades: ");
    HBox queenOfSpadesBox = new HBox(queenOfSpadesLabel, queenOfSpades);

    // Other components
    dealHand = new Button("Deal Hand");
    checkHand = new Button("Check Hand");
    cardPane = new GridPane();
    cardDisplay = new VBox(cardPane);
    lowerLeftDisplay = new HBox(facesSumBox, cardsOfHeartsBox, flushBox, queenOfSpadesBox);
    lowerRightDisplay = new VBox(dealHand, checkHand);
    Separator lowerSeparator = new Separator();
    lowerSeparator.setOrientation(Orientation.VERTICAL);
    lowerDisplay =  new HBox(lowerLeftDisplay, lowerSeparator, lowerRightDisplay);
    UiDisplay = new VBox(cardDisplay, lowerDisplay);

    // Initialise the scene
    scene = new Scene(UiDisplay, 900, 700);

    /* Set properties for the components */
    cardDisplay.prefHeightProperty().bind(scene.heightProperty().multiply(0.6));

    HBox.setHgrow(facesSumBox, Priority.ALWAYS);
    HBox.setHgrow(cardsOfHeartsBox, Priority.ALWAYS);
    HBox.setHgrow(flushBox, Priority.ALWAYS);
    HBox.setHgrow(queenOfSpadesBox, Priority.ALWAYS);
    String labelOutlineStyle = "-fx-border-color: black; -fx-border-width: 1;";

    // Add an outline to each label
    String outlineStyle = "-fx-border-color: black; -fx-border-width: 1;";
    String fontSize = "-fx-font-size: 16;";

    facesSum.setStyle(outlineStyle + fontSize);
    cardsOfHearts.setStyle(outlineStyle + fontSize);
    flush.setStyle(outlineStyle + fontSize);
    queenOfSpades.setStyle(outlineStyle + fontSize);
    facesSumLabel.setStyle(outlineStyle + fontSize);
    cardsOfHeartsLabel.setStyle(outlineStyle + fontSize);
    flushLabel.setStyle(outlineStyle + fontSize);
    queenOfSpadesLabel.setStyle(outlineStyle + fontSize);

    lowerLeftDisplay.setSpacing(scene.widthProperty().multiply(0.1).doubleValue());
    lowerRightDisplay.setSpacing(scene.heightProperty().multiply(0.1).doubleValue());
  }

  /**
   * Get the display manager.
   *
   * @return the display manager
   */
  public DisplayManager getDisplayManager() {
    return displayManager;
  }

  /**
   * Get the gridpane for displaying the cards.
   *
   * @return the gridpane for displaying the cards
   */
  public GridPane getCardPane() {
    return cardPane;
  }

  /**
   * Get the faces sum label.
   *
   * @return the faces sum label
   */
  public Label getFacesSumLabel() {
    return facesSum;
  }

  /**
   * Get the cards of hearts label.
   *
   * @return the cards of hearts label
   */
  public Label getCardsOfHearts() {
    return cardsOfHearts;
  }

  /**
   * Get the flush label.
   *
   * @return the flush label
   */
  public Label getFlush() {
    return flush;
  }

  /**
   * Get the queen of spades label.
   *
   * @return the queen of spades label
   */
  public Label getQueenOfSpades() {
    return queenOfSpades;
  }

  /**
   * Get the deal hand button.
   *
   * @return the deal hand button
   */
  public Button getDealHand() {
    return dealHand;
  }

  /**
   * Get the check hand button.
   *
   * @return the check hand button
   */
  public Button getCheckHand() {
    return checkHand;
  }


}