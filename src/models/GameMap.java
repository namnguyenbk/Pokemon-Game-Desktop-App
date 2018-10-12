package models;

import java.util.ArrayList;

public class GameMap {
    private ArrayList<Pokemon> mapPokemon;
    private int height;
    private int width;
    private int level;
// constructor
    public GameMap(){
        this.mapPokemon = null;
        this.height = 0;
        this.width = 0;
        this.level = 0;
    }

    public GameMap(ArrayList<Pokemon> mapPokemon, int height, int width, int level){
        this.mapPokemon = mapPokemon;
        this.height = height;
        this.width = width;
        this.level = level;
    }
// getter and setter
    public ArrayList<Pokemon> getMapItem() {
        return mapPokemon;
    }

    public void setMapItem(ArrayList<Pokemon> mapPokemon) {
        this.mapPokemon = mapPokemon;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    // merge
    public void merge(){
        //todo
    }

    public void updateStatusMap(ArrayList<Pokemon> mapPokemon, int height, int width, int level){
        this.mapPokemon = mapPokemon;
        this.level = level;
        this.height = height;
        this.width = width;
    }

}
