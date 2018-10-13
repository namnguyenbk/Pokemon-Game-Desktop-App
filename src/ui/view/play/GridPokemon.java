package ui.view.play;

import algorithms.Shuffle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import models.GameMap;
import models.Pokemon;
import ui.utility.Utility;

import java.util.ArrayList;

public class GridPokemon {
    private GridPane grid;
    public GridPane createGridButtonPokemon( ArrayList<Pokemon> map1){
        GridPane gridPokemon = new GridPane();
        gridPokemon.setAlignment(Pos.CENTER);
        gridPokemon.setPadding(new Insets(5));
        gridPokemon.setHgap(0);
        gridPokemon.setVgap(0);
        String preUrl = "src/resource/image/icon";
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 16; c++) {
                int index = r*16 + c ;
                Button button = new Button();
                button = Utility.setIconButton(button,preUrl + map1.get(index).getId() + ".png", 50.0, 50.0 );
                button.setPadding(new Insets(2,2,2,2));
                button.getStyleClass().add("btnPokemon");
                gridPokemon.add(button, c, r);
            }
        }
        System.gc();
        return gridPokemon;
    }
    public void setGrid ( GridPane grid){
        this.grid = grid;
    }
    public GridPane getGrid(){
        return  this.grid;
    }
    public GridPokemon(){
        GameMap gameMap = new GameMap();
        this.grid = createGridButtonPokemon( gameMap.getMap() );
    }
}
