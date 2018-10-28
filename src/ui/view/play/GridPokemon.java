package ui.view.play;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import models.GameMap;
import models.Pokemon;
import ui.controller.PlayGameController;
import ui.utility.Utility;

import java.util.ArrayList;

public class GridPokemon {
    private GridPane grid;
    private GameMap gameMap;

    public GridPane createGridButtonPokemon( ArrayList<Pokemon> map1){
        GridPane gridPokemon = new GridPane();
        gridPokemon.setAlignment(Pos.CENTER);
        gridPokemon.setHgap(0);
        gridPokemon.setVgap(0);
        String preUrl = "src/resource/image/icon";
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 16; c++) {
                int index = r*16 + c ;
                int layoutX = r + 1;
                int layoutY = c +1 ;
                Button button = new Button();
                button = Utility.setIconButton(button,preUrl + map1.get(index).getId() + ".png", 50.0, 50.0 );
                button.setPadding(new Insets(2,2,2,2));
                button.getStyleClass().add("btnPokemon");
                button.setOnAction(new EventHandler<ActionEvent>() {
                    int id = map1.get(index).getId();
                    int x = layoutX;
                    int y = layoutY;
                    @Override
                    public void handle(ActionEvent event) {
                        PlayGameController.addToCheck((Button) event.getSource(), id, x, y);
                    }
                });
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

    public GameMap getGameMap(){
        return this.gameMap;
    }

    public GridPokemon(){
         this.gameMap = new GameMap();
        this.grid = createGridButtonPokemon( gameMap.getMap() );
    }
}
