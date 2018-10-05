package ui.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class Game extends Application {
    public static Scene StartScene;
    public static Scene PlayScene;
    @Override
    public void start(Stage primaryStage) throws IOException {
        AnchorPane start = FXMLLoader.load(getClass().getResource("StartGame.fxml"));
        primaryStage.setTitle("PIKACHU LEGEND");
        addIconBtn(start);
        StartScene = new Scene(start, 700, 500);
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
    private void createIconBtn(Parent root, String selector, String sourceIcon){
        File file = new File(sourceIcon);
        Image image = null;
        ImageView icon = null;
        try {
            String localUrl = file.toURI().toURL().toString();
            image = new Image(localUrl);
            icon = new ImageView(image);
            icon.setFitHeight(40);
            icon.setFitWidth(38);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Button rankBtn = (Button) root.lookup(selector);
        rankBtn.setGraphic(icon);

    }
    private void addIconBtn(Parent start){
        createIconBtn(start, "#rank-btn", "/Users/apple/Documents/20181/OOP/Pokemon-Game/resource/image/bxh.png");
        createIconBtn(start, "#continue-btn", "/Users/apple/Documents/20181/OOP/Pokemon-Game/resource/image/continue.png");
        createIconBtn(start, "#new-game-btn", "/Users/apple/Documents/20181/OOP/Pokemon-Game/resource/image/Play-Games-icon.png");
        createIconBtn(start, "#guide-btn", "/Users/apple/Documents/20181/OOP/Pokemon-Game/resource/image/guide.png");
        createIconBtn(start, "#quit-btn", "/Users/apple/Documents/20181/OOP/Pokemon-Game/resource/image/quit.png");

    }
    public static void init(String[] args) {

        launch(args);
    }
}
