package models;

public class Media {
    private boolean music;
    private  boolean sound;

    public Media(){
        this.music = true;
        this.sound = true;
    }

    public void setMusic(boolean music) {
        this.music = music;
    }

    public void setSound(boolean sound) {
        this.sound = sound;
    }

    public boolean getMusic(){
        return this.music;
    }

    public boolean getSound(){
        return this.sound;
    }
}
