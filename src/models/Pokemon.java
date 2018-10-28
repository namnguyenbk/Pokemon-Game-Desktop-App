package models;

public class Pokemon {
    private int id;
    private String name;
    private boolean isHidden;
    public Pokemon(){
        this.id = -1;
        this.name = "No name";
        this.isHidden = false;
    }
    public Pokemon(int id, String name){
        this.id = id;
        this.name = name;
        this.isHidden = false;
    }
    public Pokemon(int id){
        this.id = id;
        this.isHidden = false;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCompatibleWith(Pokemon otherPokemon){
        return this.getName() == otherPokemon.getName();
    }

    public String toString(){
        return "Pokemon[ id: "+this.id+", name: "+this.name+"]";
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }
}
