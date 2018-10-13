package ui.view.play;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.controller.PlayGameController;
import ui.view.game.Game;

import java.io.IOException;


public class PlayGameScene {
    private GridPokemon gridPokemon;
    public Scene playGameScene;
    public PlayGameScene(){
        Stage mainStage = Game.getMainStage();
        this.gridPokemon = new GridPokemon();
        try {
            Parent rootPanePlayGame =  FXMLLoader.load(getClass().getResource("PlayGameScene.fxml"));
            playGameScene = PlayGameController.initBorderPanePlayGame(rootPanePlayGame,playGameScene, gridPokemon);
        //    playGameScene.getStylesheets().addAll(this.getClass().getResource("../style.css").toExternalForm());
            mainStage.setScene(playGameScene);
            mainStage.centerOnScreen();
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void gotoPlayGameScene(){

    }

}
