package ui.controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Line;
import ui.view.play.GridPokemon;
import ui.view.play.PlayGameScene;
import javafx.util.*;
import java.net.URL;
import java.util.ResourceBundle;

import static ui.view.play.PlayGameScene.gridPokemon;

public class PlayGameController implements Initializable {
    @FXML
    private static ProgressBar timeLife;
    @FXML
    private Button scoreView;
    @FXML
    private Button shuffleBtn;
    @FXML
    private Button mediaBtn;
    @FXML
    private Button backToGamebtn;
    @FXML
    public static  BorderPane borderPanePlayGame ;
    MediaPlayer soundPlayer;
    Media sound;
    private static PlayGameScene playScene;

    public static void newGame(){
        playScene = new PlayGameScene();
        countdown();

    }
    private  void updateScore( int score){
        if (scoreView.getText() == ""){
            scoreView.setText("0");
        }else {
            int oldScore =  Integer.parseInt(scoreView.getText());
            int newScore = score + oldScore;
            scoreView.setText(Integer.toString(score));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateScore(0);
        soundPlayer = ToolBarController.loadMedia( soundPlayer, sound, "src/resource/sound/music3.mp3");
      //  soundPlayer.stop();
    }
    private static void countdown(){
        CountDownTimer countDownTimer = new CountDownTimer();
        countDownTimer.start();
    }

    public static void connectPokemon(){
        Button button1 = (Button) gridPokemon.getGrid().getChildren().get(1);
        Button button2 = (Button) gridPokemon.getGrid().getChildren().get(2);
        double x1 =  button1.getLayoutX();
        double y1 =  button1.getLayoutY();
        double x2 =  button2.getLayoutX();
        double y2 =  button2.getLayoutY();
    }

}
class CountDownTimer extends Thread{
    @Override
    public void run() {
        ProgressBar timeLife = (ProgressBar)PlayGameController.borderPanePlayGame.lookup("#timeLife");
        Timeline task = new Timeline(
                new KeyFrame(
                        Duration.seconds(500),
                        new KeyValue(timeLife.progressProperty(), 0)
                ),
                new KeyFrame(
                        Duration.ZERO,
                        new KeyValue(timeLife.progressProperty(), 1)
                )
        );
        task.play();
    }
}
