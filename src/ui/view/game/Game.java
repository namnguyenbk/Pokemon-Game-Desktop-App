package ui.view.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class Game extends Application {
    public static Scene StartScene;
    public static Scene PlayScene;
    @Override
    public void start(Stage primaryStage) throws IOException {
        AnchorPane start = FXMLLoader.load(getClass().getResource("StartGame.fxml"));
        start.setMaxSize(800, 550);
        primaryStage.setTitle("PIKACHU LEGEND");
        addIconBtn(start);
        addImageView(start);
        StartScene = new Scene(start, 805, 555);
        primaryStage.setResizable(false);
       // primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(StartScene);
//        ScrollPane scrollPane = new ScrollPane(GridPokemon.initGrid());
//        primaryStage.setScene(new Scene(scrollPane));
        primaryStage.show();
    }

    private Scene getPlayScene(){
        Parent play = null;
        try {
            play = FXMLLoader.load(getClass().getResource("PlayGame.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        PlayScene = new Scene(play);
        return PlayScene;
    }

    private void nextScene( Scene nextScene){

    }

    private void createIconBtn(Parent root, String selector, String sourceIcon, double width, double height){
        ImageView icon = createImageView(sourceIcon, width, height);
        Button rankBtn = (Button) root.lookup(selector);
        rankBtn.setGraphic(icon);
    }

    private void addIconBtn(Parent parent){
        createIconBtn(parent, "#rank-btn", "src/resource/image/bxh.png", 60, 60);
        createIconBtn(parent, "#continue-btn", "src/resource/image/continue.png", 40, 38);
        createIconBtn(parent, "#new-game-btn", "src/resource/image/Play-Games-icon.png", 40, 38);
        createIconBtn(parent, "#guide-btn", "src/resource/image/guide.png", 40, 38);
        createIconBtn(parent, "#quit-btn", "src/resource/image/quit.png", 40, 38);
        createIconBtn(parent, "#music-start-btn", "src/resource/image/soundeffect.png", 40, 38);
    }

    private ImageView createImageView( String sourceIcon, double width, double height){
        File file = new File(sourceIcon);
        Image image = null;
        ImageView icon = null;
        try {
            String localUrl = file.toURI().toURL().toString();
            image = new Image(localUrl);
            icon = new ImageView(image);
            icon.setFitHeight(height);
            icon.setFitWidth(width);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return icon;
    }

    private void addImageView(Parent parent){
        createImageView("src/resource/image/common_google_signin_btn_icon_dark.png", "#img-3",parent );
        createImageView("src/resource/image/14434-256x256x32.png", "#img-4", parent);
        createImageView("src/resource/image/pokemon_banner.png", "#banner", parent);
        createImageView("src/resource/image/pikachuIcon.png","#img-2", parent);
        createImageView("src/resource/image/artGif.gif","#gif-1", parent);
    }

    private ImageView createImageView( String sourceIcon, String selector, Parent parent){
        File file = new File(sourceIcon);
        Image image = null;
        ImageView icon = (ImageView)parent.lookup(selector);
        try {
            String localUrl = file.toURI().toURL().toString();
            image = new Image(localUrl);
            icon.setImage(image);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return icon;
    }

    public static void init(String[] args) {
        launch(args);
    }
}
