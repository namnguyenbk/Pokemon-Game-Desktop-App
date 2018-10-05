package ui.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class GridPokemon {
    public static GridPane initGrid(){
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(5));
        grid.setHgap(0);
        grid.setVgap(0);
        for (int r = 1; r <= 9; r++) {
            for (int c = 1; c <= 16; c++) {
                int number = 9 * r + c;
                Button button = new Button();
                ImageView pokemonView = PokemonView.createIcon();
                button.setGraphic(pokemonView);
                button.setPrefHeight(40.0);
                button.setPrefWidth(40.0);
                button.setMaxHeight(40.0);
                button.setMaxWidth(40.0);
                grid.add(button, c, r);
            }
        }
        return grid;
    }
}
