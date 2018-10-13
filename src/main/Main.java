package main;

import models.Media;
import models.Session;
import ui.view.game.Game;
public class Main {
    public static  Media media = new Media();
    public static Session session = new Session();
    public static void main(String[] args) {
        Game.init(args);
    }
}
