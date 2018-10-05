package models;

public class Pokemon {
    private int id;
    private String name;
    public Pokemon(){
        this.id = -1;
        this.name = "No name";
    }
    public Pokemon(int id, String name){
        this.id = id;
        this.name = name;
    }
// getter and setter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


// so sanh 2 pokemon thong qua name
    public boolean isCompatibleWith(Pokemon otherPokemon){
        return this.getName() == otherPokemon.getName();
    }

    public String toString(){
        return "Pokemon[ id: "+this.id+", name: "+this.name+"]";
    }
}
