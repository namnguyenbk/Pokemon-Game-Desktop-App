package ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class StartGameController implements Initializable {
    @FXML
    private Button controlMusic;
    private MediaPlayer musicPlayer;
    private Media music;
    private Button newGameBtn;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        musicPlayer = ToolsController.loadMedia( musicPlayer, music, "src/resource/sound/music1.mp3");
    }
    public void toggleMusic(ActionEvent event){
        ToolsController.toggleMusic(musicPlayer, controlMusic);
    }
    public void newGame( ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo của Pikachu");
        alert.setContentText("Đang nâng cấp, chơi cái lồn!");
        alert.show();
    }
    public void quitGame( ActionEvent event){
        Node  source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
