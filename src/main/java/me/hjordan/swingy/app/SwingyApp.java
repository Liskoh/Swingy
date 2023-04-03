package me.hjordan.swingy.app;

import lombok.Getter;

@Getter
public abstract class SwingyApp {

    private GameMode gameMode;

    public SwingyApp(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public void start() {
        onStart();
    }

    public abstract void onStart();
}
