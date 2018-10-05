package models;

public class LastPlay {
    private int score;
    private int level;
    private int suggestNum;
    private GameMap gameMap;
    private boolean isTurnOnSound;
    private boolean isTurnOnMusic;
    private int currentTime;

    public LastPlay(){
        this.gameMap = null;
        this.isTurnOnMusic = false;
        this.isTurnOnSound = false;
        this.level = 0;
        this.score = 0;
        this.suggestNum = 5;
        this.currentTime = 0;
    }

    public LastPlay(int score, int level,int suggestNum,int currentTime, GameMap gameMap, boolean isTurnOnSound, boolean isTurnOnMusic) {
        this.suggestNum = suggestNum;
        this.score = score;
        this.level = level;
        this.currentTime = currentTime;
        this.gameMap = gameMap;
        this.isTurnOnSound = isTurnOnSound;
        this.isTurnOnMusic = isTurnOnMusic;
    }
    // getter and setter
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public boolean isTurnOnSound() {
        return isTurnOnSound;
    }

    public void setTurnOnSound(boolean turnOnSound) {
        isTurnOnSound = turnOnSound;
    }

    public boolean isTurnOnMusic() {
        return isTurnOnMusic;
    }

    public void setTurnOnMusic(boolean turnOnMusic) {
        isTurnOnMusic = turnOnMusic;
    }

    public int getSuggestNum() {
        return suggestNum;
    }

    public void setSuggestNum(int suggestNum) {
        this.suggestNum = suggestNum;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }
}