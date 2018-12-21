package models;

import algorithms.Shuffle;
import main.Main;

import java.util.ArrayList;

public class GameMap {
    private ArrayList<Pokemon> mapPokemon;
    private ArrayList<Pokemon> lastMapPokemon;
    private int height;
    private int width;
    private int level;
    private int length;

    public ArrayList<Pokemon> getMap() {
        return this.mapPokemon;
    }

    public ArrayList<Pokemon> getLastMap() {
        return this.lastMapPokemon;
    }

    public void setLastMapPokemon(){
        this.lastMapPokemon = this.mapPokemon;
    }
    public ArrayList<Pokemon> setMapPokemon(int[][] map) {
        mapPokemon = new ArrayList<Pokemon>();
        for(int i = 1; i< map.length -1; i++){
            for(int j = 1; j < map[i].length -1; j++){
                if (map[i][j] != 0){
                    Pokemon pokemon = new Pokemon(map[i][j]);
                    mapPokemon.add(pokemon);
                }else {
                    Pokemon pokemon = new Pokemon(0);
                    mapPokemon.add(pokemon);
                }

            }
        }
        return this.mapPokemon;
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

    public int getLength() {
        return length;
    }

    public void  setLength( int length){
        this.length = length;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void shuffle(){
        //todo
    }

    public void updateStatusMap(int[][] map, int height, int width, int level){
        this.mapPokemon = setMapPokemon( map);
        this.level = level;
        this.height = height;
        this.width = width;
    }
    // Map default
    public GameMap(){
        this.mapPokemon = setMapPokemon(Main.map);
        this.lastMapPokemon = null;
        this.length = 144;
//        this.length = 8;
        this.height = 9;
        this.width = 16;
        this.level = 0;
    }

    public GameMap(ArrayList<Pokemon> mapPokemon, int height, int width, int level){
        this.mapPokemon = mapPokemon;
        this.lastMapPokemon = null;
        this.height = height;
        this.width = width;
        this.level = level;
    }

}
