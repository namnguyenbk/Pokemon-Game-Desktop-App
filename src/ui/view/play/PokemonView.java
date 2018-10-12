package ui.view.play;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ui.utility.Utility;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class PokemonView {
    public static List<ImageView> listIcon  = new ArrayList<ImageView>();
    public static ImageView createIconPokemon( String url) {
        return Utility.createIcon(url, 40.0, 40.0);
    }
}
