package me.hjordan.swingy;

import me.hjordan.swingy.app.GameMode;
import me.hjordan.swingy.app.SwingyApp;
import me.hjordan.swingy.app.type.GuiApp;

public class Main {

    public static SwingyApp APP;

    private static void printUsageAndExit() {
        System.out.println("Usage: java -jar swingy.jar [console|gui]");
        System.exit(1);
    }

    private static SwingyApp createApp(GameMode gameMode) {
        switch (gameMode) {
            case CONSOLE:
                return new GuiApp();
            case GUI:
                return new GuiApp();
            default:
                return null;
        }
    }

    public static void main(String[] args) {

        if (args.length == 0)
            printUsageAndExit();

        GameMode gameMode = null;

        try {
            gameMode = GameMode.valueOf(args[0].toUpperCase());
        } catch (IllegalArgumentException e) {
            printUsageAndExit();
        }

        if (gameMode == null)
            printUsageAndExit();

        APP = createApp(gameMode);
        APP.start();
    }
}
