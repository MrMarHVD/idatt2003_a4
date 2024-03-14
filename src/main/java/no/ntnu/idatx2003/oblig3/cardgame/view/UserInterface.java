package no.ntnu.idatx2003.oblig3.cardgame.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Class representing the user interface for the card game.
 */
public class UserInterface extends Application {

  VBox cardDisplay;

  GridPane cardPane;

  TextField facesSum;

  TextField cardsOfHearts;

  Label flush;

  Label queenOfSpades;

  Button dealHand;

  Button checkHand;


  /**
   * Start method for the application and UI.
   * @param primaryStage the stage
   */
  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Card Game");

    TextField textField = new TextField();
    Button button = new Button("Click me");
    Label label = new Label("Display");

    VBox vbox = new VBox(textField, button, label);

    int sceneWidth = 900;
    int sceneHeight = 600;
    Scene scene = new Scene(vbox, sceneWidth, sceneHeight);

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
    facesSum = new TextField();
    cardsOfHearts = new TextField();
    flush = new Label("-fx-padding: 10;" +
                        "-fx-border-style: solid inside;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-insets: 5;" +
                        "-fx-border-radius: 5;" +
                        "-fx-border-color: blue;");
    queenOfSpades = new Label("-fx-padding: 10;" +
                        "-fx-border-style: solid inside;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-insets: 5;" +
                        "-fx-border-radius: 5;" +
                        "-fx-border-color: blue;");
    dealHand = new Button("Deal Hand");
    checkHand = new Button("Check Hand");
  }


}