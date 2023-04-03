package me.hjordan.swingy.app.type;

import me.hjordan.swingy.app.GameMode;
import me.hjordan.swingy.app.SwingyApp;
import me.hjordan.swingy.app.controller.HomeController;

public class GuiApp extends SwingyApp {

    private HomeController homeController;

    public GuiApp() {
        super(GameMode.GUI);
    }

    @Override
    public void onStart() {
        this.homeController = new HomeController(this);

        this.homeController.openView();
    }
}
