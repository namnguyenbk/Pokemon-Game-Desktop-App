package ui.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Game extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent start = FXMLLoader.load(getClass().getResource("StartGame.fxml"));
        Parent play = FXMLLoader.load(getClass().getResource("PlayGame.fxml"));
        primaryStage.setTitle("PIKACHU LEGEND");
        Scene StartScene = new Scene(start, 300, 275);
        Scene PlayScene = new Scene(start, 300, 275);
        primaryStage.setScene(StartScene);
        primaryStage.show();
    }
}
