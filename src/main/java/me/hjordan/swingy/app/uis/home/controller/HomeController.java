package me.hjordan.swingy.app.uis.home.controller;

import lombok.Getter;
import lombok.Setter;
import me.hjordan.swingy.app.SwingyApp;
import me.hjordan.swingy.app.uis.IController;
import me.hjordan.swingy.app.uis.home.view.HomeView;
import me.hjordan.swingy.engine.hero.AbstractHero;
import me.hjordan.swingy.engine.hero.HeroType;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class HomeController implements IController {

    private SwingyApp app;
    private List<AbstractHero> heroes, newHeroes;
    private JFrame view;
    private AbstractHero selectedHero;

    public HomeController(SwingyApp app) {
        this.app = app;
        this.heroes = app.getDatabaseManager().findAll();
        this.newHeroes = this.getNewHeroes();
        this.selectedHero = null;

        if (!this.heroes.isEmpty())
            this.selectedHero = this.heroes.get(0);

        //create fqkes heroes:
        //this.createNewHero("berserk");
        //this.createNewHero("berserk");

    }

    public void refreshData() {
        this.heroes = app.getDatabaseManager().findAll();
    }

    public AbstractHero createNewHero(String heroType) {
        AbstractHero hero = this.app.createHero(heroType);

        if (hero == null)
            return null;

        this.app.getDatabaseManager().save(hero);
        this.refreshData();

        return hero;
    }

    public List<AbstractHero> getNewHeroes() {
        final List<AbstractHero> list = Arrays.asList(
                this.app.createHero(HeroType.HEALER.toString()),
                this.app.createHero(HeroType.BERSERK.toString()),
                this.app.createHero(HeroType.BERSERK.toString())
        );

        return list;
    }

    @Override
    public void openView() {
        this.view = new HomeView(this);
        this.view.setVisible(true);
    }

    @Override
    public void closeView() {
        this.view.setVisible(false);
        this.view.dispose();
    }
}
