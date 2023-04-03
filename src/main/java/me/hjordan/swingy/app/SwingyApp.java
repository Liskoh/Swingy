package me.hjordan.swingy.app;

import lombok.Getter;
import me.hjordan.swingy.manager.ConfigManager;
import me.hjordan.swingy.manager.DatabaseManager;

@Getter
public abstract class SwingyApp {

    private GameMode gameMode;
    private ConfigManager configMqnager;
    private DatabaseManager databaseManager;

    public SwingyApp(GameMode gameMode) {
        this.gameMode = gameMode;
        this.configMqnager = new ConfigManager();
        this.databaseManager = new DatabaseManager();
    }

    public void start() {
        System.out.println("Starting " + gameMode.name() + " app...");
        onStart();
    }

    public abstract void onStart();
}
