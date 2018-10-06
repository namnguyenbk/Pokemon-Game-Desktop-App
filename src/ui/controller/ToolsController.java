package ui.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.event.ActionEvent;
import main.Main;
import ui.utility.Utility;

public class ToolsController implements Initializable {
    @FXML
    private Button controlMusic;
    private MediaPlayer musicPlayer;
    private Media music;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        musicPlayer = loadMedia( musicPlayer, music, "src/resource/sound/music1.mp3");
    }

    public MediaPlayer loadMedia( MediaPlayer mediaPlayer, Media media,String url){
        String path = new File(url).getAbsolutePath();
        media = new Media( new File(path).toURI().toString() );
        try {
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.setAutoPlay(true);
        }catch ( NullPointerException e){
            e.printStackTrace();
        }
        return mediaPlayer;
    }

    public void toggleMusic(ActionEvent event){
        if(Main.media.getMusic()){
            Main.media.setMusic(false);
            musicPlayer.pause();
            Utility.setIconButton(controlMusic, "src/resource/image/soundeffectmute.png", 40, 40 );
        }else{
            Main.media.setMusic(true);
            musicPlayer.play();
            Utility.setIconButton(controlMusic, "src/resource/image/soundeffect.png", 40, 40 );
        }
    }
}
