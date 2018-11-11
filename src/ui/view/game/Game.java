package ui.view.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ui.utility.Utility;
import ui.view.play.GridPokemon;
import ui.view.play.PlayGameScene;

import java.io.IOException;

public class Game extends Application {
    private static Scene startScene;
//    private static PlayGameScene playGameScene;
    private static Stage mainStage;
    @Override
    public void start(Stage primaryStage) throws IOException {
        mainStage = primaryStage;
        AnchorPane start = FXMLLoader.load(getClass().getResource("StartGame.fxml"));
        start.setMaxSize(800, 550);
        mainStage.setTitle("PIKACHU LEGEND");
        addIconBtnMenu(start);
        addImageView(start);
        startScene = new Scene(start, 805, 555);
        mainStage.setResizable(false);
        mainStage.initStyle(StageStyle.UNDECORATED);
        setStartScene();
    }

    private void addIconBtnMenu(Parent parent){
        Utility.setIconButton(parent, "#rank-btn", "src/resource/image/bxh.png", 60.0, 60.0);
        Utility.setIconButton(parent, "#continue-btn", "src/resource/image/continue.png", 40.0, 38.0);
        Utility.setIconButton(parent, "#new-game-btn", "src/resource/image/Play-Games-icon.png", 40.0, 38.0);
        Utility.setIconButton(parent, "#guide-btn", "src/resource/image/guide.png", 40.0, 38.0);
        Utility.setIconButton(parent, "#quit-btn", "src/resource/image/quit.png", 40.0, 38.0);
        Utility.setIconButton(parent, "#music-start-btn", "src/resource/image/soundeffect.png", 40.0, 38.0);
    }

    private void addImageView(Parent parent){
        Utility.createImageView("src/resource/image/common_google_signin_btn_icon_dark.png", "#img-3",parent, null, null );
        Utility.createImageView("src/resource/image/14434-256x256x32.png", "#img-4", parent, null, null);
        Utility.createImageView("src/resource/image/pokemon_banner.png", "#banner", parent, null, null);
        Utility.createImageView("src/resource/image/pikachuIcon.png","#img-2", parent, null, null);
        Utility.createImageView("src/resource/image/artGif.gif","#gif-1", parent, null, null);
        Utility.createImageView("src/resource/image/ball2.gif","#gif-2", parent, null, null);
    }
    public static Stage getMainStage(){
        return mainStage;
    }

    public static void setStartScene(){
        mainStage.setScene(startScene);
        mainStage.show();
    }

    public  Scene getStartScene(){
        return startScene;
    }
//    public  PlayGameScene getPlayStage(){
//        return playGameScene;
//    }
//    public  void setPlayScene( PlayGameScene playScene){
//        playGameScene = playScene;
//    }
    public static void init(String[] args) {
        launch(args);
    }

}
