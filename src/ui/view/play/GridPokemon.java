package ui.view.play;

import algorithms.Shuffle;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import ui.utility.Utility;

public class GridPokemon {
    public static GridPane initGrid(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(5));
        grid.setHgap(0);
        grid.setVgap(0);
        int[][] map = Shuffle.init();
        String preUrl = "src/resource/image/icon";
        for (int r = 1; r <= 9; r++) {
            for (int c = 1; c <= 16; c++) {
                Button button = new Button();
                button = Utility.setIconButton(button,preUrl + map[r-1][c-1]+ ".png", 40.0, 40.0 );
//                button.styleProperty("-fx-background-color", "grey");
                //button.backgroundProperty("background-color","grey");
                button.getStyleClass().add("btn");
                grid.add(button, c, r);
            }
        }
        return grid;
    }
}
