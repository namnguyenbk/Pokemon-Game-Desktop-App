package ui.view.play;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ui.controller.PlayGameController;
import ui.utility.Utility;
import ui.view.game.Game;

import java.io.IOException;

import static ui.controller.PlayGameController.borderPanePlayGame;


public class PlayGameScene {
    public static GridPokemon gridPokemon;
    public static Scene playGameScene;
    private Scene initBorderPanePlayGame(Parent root, Scene playGameScene, GridPokemon gridPokemon){
        borderPanePlayGame = (BorderPane) root.lookup("#borderPanePlayGame");
        borderPanePlayGame.setMaxSize(1000, 750);
        borderPanePlayGame.setCenter(gridPokemon.getGrid());
        borderPanePlayGame.setAlignment(gridPokemon.getGrid(), Pos.CENTER);
        playGameScene = new Scene(borderPanePlayGame,1005, 755);
        return playGameScene;
    }
    private void gotoPlayGameScene(){
    }
    private void addToolbar( Parent root){
        Utility.setIconButton(root, "#scoreView", "src/resource/image/scores.png",30.0, 30.0);
        Utility.setIconButton(root, "#shuffleBtn", "src/resource/image/replay.png",30.0, 30.0);
        Utility.setIconButton(root, "#mediaBtn", "src/resource/image/sound.png",30.0, 30.0);
        Utility.setIconButton(root, "#saveGameBtn", "src/resource/image/save.png",30.0, 30.0);
        Utility.setIconButton(root, "#backToGamebtn", "src/resource/image/quit.png",30.0, 30.0);
    }

    public PlayGameScene(){
        Stage mainStage = Game.getMainStage();
        gridPokemon = new GridPokemon();
        try {
            Parent rootPanePlayGame =  FXMLLoader.load(getClass().getResource("PlayGameScene.fxml"));
            addToolbar(rootPanePlayGame);
            playGameScene = initBorderPanePlayGame(rootPanePlayGame,playGameScene, gridPokemon);
            mainStage.setScene(playGameScene);
            mainStage.centerOnScreen();
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
