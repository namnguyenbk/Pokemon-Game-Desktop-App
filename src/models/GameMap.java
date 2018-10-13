package models;

import algorithms.Shuffle;

import java.util.ArrayList;

public class GameMap {
    private ArrayList<Pokemon> mapPokemon;
    private int height;
    private int width;
    private int level;
    public ArrayList<Pokemon> getMap() {
        return this.mapPokemon;
    }

    public ArrayList<Pokemon> setMapPokemon(int[][] map) {
        mapPokemon = new ArrayList<Pokemon>();
        for(int i = 1; i< map.length -1; i++){
            for(int j = 1; j < map[i].length -1; j++){
                Pokemon pokemon = new Pokemon(map[i][j]);
                mapPokemon.add(pokemon);
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
        this.mapPokemon = setMapPokemon( Shuffle.init());
        this.height = 9;
        this.width = 16;
        this.level = 0;
    }

    public GameMap(ArrayList<Pokemon> mapPokemon, int height, int width, int level){
        this.mapPokemon = mapPokemon;
        this.height = height;
        this.width = width;
        this.level = level;
    }

}
