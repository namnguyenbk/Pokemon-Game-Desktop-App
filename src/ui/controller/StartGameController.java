package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import ui.view.play.GridPokemon;
import ui.view.play.PlayGameScene;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

public class StartGameController implements Initializable {
    @FXML
    private Button continueGameBtn;
    private Button controlMusic;
    private MediaPlayer musicPlayer;
    private Media music;
    private Button newGameBtn;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      //  musicPlayer = ToolBarController.loadMedia( musicPlayer, music, "src/resource/sound/music2.mp3");
        setVisbleContinueGame();
    }
    public void toggleMusic(ActionEvent event){
        ToolBarController.toggleMusic(musicPlayer, controlMusic);
    }
    public void newGame( ActionEvent event){

    }
    public void quitGame( ActionEvent event){
        Node  source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
    public void setVisbleContinueGame(){
        MenuController.toogleContinueBtn(continueGameBtn);
    }
    public void setNewGame(){
        String timeStamp1 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp1);
        PlayGameScene playNewGame = new PlayGameScene();
        String timeStamp2 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp2);
    }
}
