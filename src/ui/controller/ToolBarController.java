package ui.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import main.Main;
import ui.utility.Utility;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
public class ToolBarController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public static MediaPlayer loadMedia( MediaPlayer mediaPlayer, Media media,String url){
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

    public static void toggleMusic(MediaPlayer musicPlayer, Button controlMusic){
        if(Main.media.getMusic()){
            Main.media.setMusic(false);
            musicPlayer.stop();
            Utility.setIconButton(controlMusic, "src/resource/image/soundeffectmute.png", 40.0, 40.0 );
        }else{
            Main.media.setMusic(true);
            musicPlayer.play();
            Utility.setIconButton(controlMusic, "src/resource/image/soundeffect.png", 40.0, 40.0 );
        }
    }
    public static void toggleSound(){
        if (Main.media.getSound()){
            Main.media.setSound(false);
        }else {
            Main.media.setSound(true);
        }
    }
}
