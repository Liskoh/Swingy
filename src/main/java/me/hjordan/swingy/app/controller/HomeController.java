package me.hjordan.swingy.app.controller;

import me.hjordan.swingy.app.SwingyApp;
import me.hjordan.swingy.app.view.HomeView;
import me.hjordan.swingy.engine.hero.AbstractHero;

import javax.swing.*;
import java.util.List;

public class HomeController implements IController{

    private SwingyApp app;
    private List<AbstractHero> heroes;
    private JFrame view;
    private AbstractHero selectedHero;

    public HomeController(SwingyApp app) {
        this.app = app;
        this.heroes = app.getDatabaseManager().findAll();
        this.selectedHero = null;
    }

    public void refreshData() {
        this.heroes = app.getDatabaseManager().findAll();
    }

    @Override
    public void openView() {
        this.view = new HomeView(this);
        this.view.setVisible(true);
    }

    @Override
    public void closeView() {

    }
}
