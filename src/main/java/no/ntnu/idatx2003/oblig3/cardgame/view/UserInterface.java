package no.ntnu.idatx2003.oblig3.cardgame.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Class representing the user interface for the card game.
 */
public class UserInterface extends Application {

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Card Game");

    TextField textField = new TextField();
    Button button = new Button("Click me");
    Label label = new Label("Display");

    VBox vbox = new VBox(textField, button, label);
    Scene scene = new Scene(vbox, 200, 200);

    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}