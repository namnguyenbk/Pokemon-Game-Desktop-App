package main;

import javafx.application.Application;
import javafx.stage.Stage;
import ui.view.Game;

public class Main extends Application {
    public static void main(String[] args) {
        Game game =  new Game();
        game.start( Stage primaryStage);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
    }
}
