package ui.utility;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.MalformedURLException;

public class Utility {
    public static void setIconButton(Button button, String url, double width, double height){
        ImageView icon = createIcon(url, width, height);
        button.setGraphic(icon);
    }
    public static ImageView createIcon( String url, double width, double height){
        File file = new File(url);
        Image image = null;
        ImageView icon = null;
        try {
            String localUrl = file.toURI().toURL().toString();
            image = new Image(localUrl);
            icon = new ImageView(image);
            icon.setFitWidth(width);
            icon.setFitHeight(height);
            icon.setImage(image);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return icon;
    }
    public static ImageView createImageView( ImageView imageView, String url){
        File file = new File(url);
        Image image = null;
        try {
            String localUrl = file.toURI().toURL().toString();
            image = new Image(localUrl);
            imageView.setImage(image);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return imageView;
    }

    private ImageView createImageView( String sourceIcon, String selector, Parent parent){
        File file = new File(sourceIcon);
        Image image = null;
        ImageView imageView = (ImageView)parent.lookup(selector);
        try {
            String localUrl = file.toURI().toURL().toString();
            image = new Image(localUrl);
            imageView.setImage(image);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return imageView;
    }


}
