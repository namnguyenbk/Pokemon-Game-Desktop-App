package models;

import java.util.Date;

public class Session {
    private LastPlay lastPlay;
    private int timeRemaining;
    public Session(){
        this.lastPlay = null;
        this.timeRemaining = 0;
    }
    public Session(LastPlay lastPlay){
        this.lastPlay = lastPlay;
        this.timeRemaining = 5*60 - this.lastPlay.getCurrentTime();
    }
// getter and setter
    public int getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(int timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    public LastPlay getLastPlay() {
        return lastPlay;
    }

    public void setLastPlay(LastPlay lastPlay) {
        this.lastPlay = lastPlay;
    }

    // decre time remaining
    public void decreTimeRemaining(){
        this.timeRemaining -= 1;
    }
    // restart session

    public Session restartSession(){
        this.timeRemaining = 5*60;
        this.lastPlay.setScore(0);
        this.lastPlay.setSuggestNum(5);
        this.lastPlay.setCurrentTime(0);
        // set gamemap dua theo thuat toan
        // here
        //
        return this;
    }
}
