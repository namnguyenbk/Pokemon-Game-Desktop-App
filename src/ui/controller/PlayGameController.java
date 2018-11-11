package ui.controller;

import algorithms.Matching;
import algorithms.Shuffle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;
import main.Main;
import models.GameMap;
import models.LastPlay;
import ui.view.game.Game;
import ui.view.play.PlayGameScene;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Stack;

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
    private Button shuffleBtn;
    @FXML
    private Button mediaBtn;
    @FXML
    private Button backToGamebtn;
    @FXML
    public static  BorderPane borderPanePlayGame ;
    protected static  Timeline task;
    MediaPlayer soundPlayer;
    Media sound;
    private static PlayGameScene playScene;

    public static LastPlay lastPlay ;

    public static final void newGame(){
        Main.map = Shuffle.init();
        LastPlay lastPlayTemp = new LastPlay(0, 1, 5, 0, null);
        GameMap gameMapTemp = new GameMap();
        lastPlayTemp.setGameMap(gameMapTemp);
        Main.session.setLastPlay(lastPlayTemp);
        lastPlay = Main.session.getLastPlay();
        playScene = new PlayGameScene();
        updateScore(0);
        setTextOnLevel("1");
        countdown();
    }

    private static void updateScore(int score){
        try{
            Button scoreView = (Button)PlayGameController.borderPanePlayGame.lookup("#scoreView");
            if (scoreView.getText() == ""){
                scoreView.setText("0");
            }else {
                int oldScore =  Integer.parseInt(scoreView.getText());
                int newScore = score + oldScore;
                lastPlay.setScore(newScore);
                scoreView.setText(Integer.toString(newScore));
            }
        }catch ( NullPointerException e){
            System.out.println("Cannot get Score Button!");
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        soundPlayer = ToolBarController.loadMedia( soundPlayer, sound, "src/resource/sound/music3.mp3");
//        soundPlayer.stop();
    }

    public void shuffleMap(ActionEvent event){
        int suggestNum = lastPlay.getSuggestNum();
        if( suggestNum > 0){
            Main.map = Shuffle.updateCurrentMap(Main.map);
            changeMap();
            lastPlay.setSuggestNum(suggestNum - 1);
        }

    }

    private static void countdown(){
        CountDownTimer countDownTimer = new CountDownTimer();
        countDownTimer.start();
    }

    public void toggleSound(){
        ToolBarController.toggleSound();
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
            playScene.gridPokemon.getGrid().requestFocus();
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
            updateScore(100);
            Main.updateMap(x1, y1, x2, y2);
            if ( isCompletedLevel()){
                gotoNextLevel();
            }else {

                int level = lastPlay.getLevel();
                if ( level > 1){

                    changeMap();
                }
            }
        }else {
        }

    }

    private static final boolean isCompletedLevel(){
        int lengthMap = lastPlay.getGameMap().getLength();
        if (lengthMap > 0){
            lastPlay.getGameMap().setLength(lengthMap - 2);
            System.out.println(lengthMap - 2);
            if (lastPlay.getGameMap().getLength() == 0){
                return true;
            }
            return  false;
        }
        return true;
    }

    private static final void gotoNextLevel(){
        if (lastPlay.getLevel() < 3){
            Main.map = Shuffle.init();
            changeMap();
            lastPlay.getGameMap().setLength(144);
            lastPlay.setLevel( lastPlay.getLevel() + 1);
            lastPlay.setSuggestNum( lastPlay.getSuggestNum() + 1);
            setTextOnLevel(Integer.toString(lastPlay.getLevel()));
            task.stop();
            task.play();
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Chiến thắng !");
            alert.setHeaderText("Số điểm của bạn là: " + lastPlay.getScore());
            Optional<ButtonType> option = alert.showAndWait();
            if(option.get() == ButtonType.OK){
            }else {
                Game.setStartScene();
            }
        }
    }

    private static final void changeMap(){
        lastPlay.getGameMap().setMapPokemon(Main.map);
        playScene.updateCenterPanePlayGame();

    }

    private static final double getAbsoluteLayoutX(double x){
        return (x*56 + 26.5);

    }

    private static final double getAbsoluteLayoutY(double y){
        return (y*57 + 108.5);

    }

    public void quitGame() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Trở về");
        alert.setHeaderText("Bạn có muốn lưu trạng thái của trò chơi!");
        Optional<ButtonType> option = alert.showAndWait();
        if(option.get() == ButtonType.OK){
        }else {
            if ( option.get() == ButtonType.CANCEL){
                Game.setStartScene();
            }
        }
    }

    private static void setTextOnLevel( String level){
        Text levelText = (Text)PlayGameController.borderPanePlayGame.lookup("#level");
        levelText.setFill(Color.WHITE);
        levelText.setText("LV " +level);

    }
}

class CountDownTimer extends Thread{
    @Override
    public void run() {
        ProgressBar timeLife = (ProgressBar)PlayGameController.borderPanePlayGame.lookup("#timeLife");
        PlayGameController.task = new Timeline(
                new KeyFrame(
                        Duration.seconds(300),
                        new KeyValue(timeLife.progressProperty(), 0)
                ),
                new KeyFrame(
                        Duration.ZERO,
                        new KeyValue(timeLife.progressProperty(), 1)
                )
        );
        PlayGameController.task.setOnFinished( event -> {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    PlayGameController.task.stop();
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Hết thời gian!");
                    alert.setHeaderText("Bạn có muốn chơi lại!");
                    Optional<ButtonType> option = alert.showAndWait();
                    if(option.get() == ButtonType.OK){
                        Game.setStartScene();
                    }else {
                    }
                }
            });

        } );
        PlayGameController.task.play();
    }

}
