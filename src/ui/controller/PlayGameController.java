package ui.controller;

import algorithms.Matching;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import main.Main;
import models.Pokemon;
import ui.view.play.PlayGameScene;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Stack;

import static ui.view.play.PlayGameScene.gridPokemon;

class TempPkm{
    Button button;
    int id, x, y;
    public  TempPkm( Button button, int id, int x, int y){
        this.button = button;
        this.id = id;
        this.x = x;
        this.y = y;
    }
}

public class PlayGameController implements Initializable {
    private static Stack stackPokemon = new Stack();
    @FXML
    private  ProgressBar timeLife;
    @FXML
    private  Button scoreView;
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

    public static final void newGame(){
        playScene = new PlayGameScene();
        countdown();
    }

    private void updateScore(int score){
        if (scoreView.getText() == ""){
            scoreView.setText("0");
        }else {
            int oldScore =  Integer.parseInt(scoreView.getText());
            int newScore = score + oldScore;
            scoreView.setText(Integer.toString(newScore));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateScore(0);
//        soundPlayer = ToolBarController.loadMedia( soundPlayer, sound, "src/resource/sound/music3.mp3");
      //  soundPlayer.stop();
    }
    private static void countdown(){
        CountDownTimer countDownTimer = new CountDownTimer();
        countDownTimer.start();
    }

    public static void connectPokemon(){

    }

    public static final Line drawLine( double x1, double y1, double x2, double y2){
        double X1 = getAbsoluteLayoutX(y1);
        double Y1 = getAbsoluteLayoutY(x1);
        double X2 = getAbsoluteLayoutX(y2);
        double Y2 = getAbsoluteLayoutY(x2);
        Line line =  new Line(X1, Y1, X2, Y2);
        line.setStrokeWidth(5);
        line.setStroke(Color.DARKRED);
        PauseTransition delay = new PauseTransition(Duration.seconds(0.5));
        delay.setOnFinished( event -> line.setVisible(false) );
        delay.play();
        return line;
    }
    public static final void addToCheck( Button buttonPokemon, int id, int x, int y ){
        if( stackPokemon.size() < 2){
            TempPkm temp = new TempPkm( buttonPokemon, id, x, y);
            stackPokemon.push( temp);
        }
        if ( stackPokemon.size() == 2){
            TempPkm tempPokemon1 = (TempPkm) stackPokemon.pop();
            TempPkm tempPokemon2 = (TempPkm) stackPokemon.pop();
            PlayGameScene.gridPokemon.getGrid().requestFocus();
            handleMatch( tempPokemon1, tempPokemon2);
        }
    }

    public static final void handleMatch( TempPkm tempPkm1, TempPkm tempPkm2 ){
        int[][] route = Matching.checkTwoPoint(Main.map, tempPkm1.x, tempPkm1.y, tempPkm2.x, tempPkm2.y);
        if ( route.length > 0){
            int x1 = tempPkm1.x;
            int y1 = tempPkm1.y;
            int x2 = tempPkm2.x;
            int y2 = tempPkm2.y;
//            PlayGameController.updateScore(100);
            Main.updateMap(x1, y1, x2, y2);
//            gridPokemon.getGameMap().getMap().get( 16*x1 + y1);
//            gridPokemon.getGameMap().getMap().remove( 16*x2 + y2);
            Line line1 = drawLine(x2,y2, route[1][0], route[1][1]);
            Line line2 = drawLine( route[1][0], route[1][1] , route[0][0], route[0][1]);
            Line line3 = drawLine( route[0][0], route[0][1] , x1, y1);
            borderPanePlayGame.getChildren().add(line1);
            borderPanePlayGame.getChildren().add(line2);
            borderPanePlayGame.getChildren().add(line3);
            tempPkm1.button.setVisible(false);
            tempPkm2.button.setVisible(false);

        }else {
            System.out.println("Khong the ket noi");
        }

    }

    private static double getAbsoluteLayoutX(double x){
        return (x*56 + 26.5);

    }

    private static double getAbsoluteLayoutY(double y){
        return (y*57 + 108.5);

    }

    private static final boolean isCompletedLevel(ArrayList<Pokemon> list){
        if (list.size() < 2){
            return  true;
        }
        return false;
    }

    private static final void gotoNextLevel(){

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
