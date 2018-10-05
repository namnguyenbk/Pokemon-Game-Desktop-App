package ui.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class PokemonView {
    public static List<ImageView> listIcon  = new ArrayList<ImageView>();
    public static ImageView createIcon() {
        File file = new File("/Users/apple/Documents/20181/OOP/Pokemon-Game/resource/image/icon1.png");
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
       return icon;
    }
}
