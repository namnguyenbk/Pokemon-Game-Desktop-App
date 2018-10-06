package main;

import models.Media;
import ui.view.game.Game;
public class Main {
    public static  Media media = new Media();
    public static void main(String[] args) {
        Game.init(args);
    }
}
