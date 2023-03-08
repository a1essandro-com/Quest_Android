package com.example.quest;

public class Player {
    public int progress;
    public boolean hasKey=false;
    public Player(int progress) {
        this.progress = progress;
    }
    public void reset(){
        progress=0;
        hasKey=false;
    }
}
