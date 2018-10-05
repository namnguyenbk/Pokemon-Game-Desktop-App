package models;

import java.util.ArrayList;

public class GameMap {
    private ArrayList<Pokemon> mapItem;
    private int height;
    private int width;
    private int level;
// constructor
    public GameMap(){
        this.mapItem = null;
        this.height = 0;
        this.width = 0;
        this.level = 0;
    }

    public GameMap(ArrayList<Pokemon> mapItem, int height, int width, int level){
        this.mapItem = mapItem;
        this.height = height;
        this.width = width;
        this.level = level;
    }
// getter and setter
    public ArrayList<Pokemon> getMapItem() {
        return mapItem;
    }

    public void setMapItem(ArrayList<Pokemon> mapItem) {
        this.mapItem = mapItem;
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

    public void updateStatusMap(ArrayList<Pokemon> mapItem, int height, int width, int level){
        this.mapItem = mapItem;
        this.level = level;
        this.height = height;
        this.width = width;
    }

}
