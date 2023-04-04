package me.hjordan.swingy.app.uis.home.view;

import me.hjordan.swingy.app.uis.home.controller.HomeController;
import me.hjordan.swingy.app.uis.home.view.renderer.HeroListRenderer;
import me.hjordan.swingy.engine.hero.AbstractHero;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HomeView extends JFrame {

    private HomeController controller;
    private JList<AbstractHero> heroes;
    private JComboBox<AbstractHero> heroesComboBox, newHeroesBox;

    private JComboBox<AbstractHero> createBox(List<AbstractHero> list) {
        final JComboBox<AbstractHero> box = new JComboBox<>(list.toArray(new AbstractHero[0]));
        box.setRenderer(new HeroListRenderer());
        box.addActionListener(e -> {
            AbstractHero selectedHero = (AbstractHero) box.getSelectedItem();
            this.controller.setSelectedHero(selectedHero);
        });

        return box;
    }

    public HomeView(HomeController controller) {
        super("Swingy");

        this.controller = controller;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
       // this.setResizable(false);

        final JPanel panel = new JPanel();
        final List<AbstractHero> controllerHeroes = this.controller.getHeroes();
        final JLabel label = new JLabel("Heroes List");

        this.heroesComboBox = this.createBox(this.controller.getHeroes());

        final JLabel newHeroesLabel = new JLabel("create new Hero");
        final JComboBox<AbstractHero> newHeroesBox = this.createBox(this.controller.getNewHeroes());


        final AbstractHero hero = this.controller.getSelectedHero();
        final JTextArea textArea = new JTextArea();

        if (hero == null)
            textArea.setText("No Hero selected");
        else {
            textArea.setText("Selected Hero: \n" +
                    "Name: " + hero.getName() + "\n" +
                    "Type: " + hero.getType() + "\n" +
                    "Level: " + hero.getLevel() + "\n" +
                    "Experience: " + hero.getExperience() + "\n" +
                    "Attack: " + hero.getAttackPoints() + "\n" +
                    "Defense: " + hero.getDefensePoints() + "\n" +
                    "Hit: " + hero.getHitPoints() + "\n");
        }
        textArea.setEditable(false);
        final JScrollPane scrollPane = new JScrollPane(textArea);


        panel.add(label);
        panel.add(this.heroesComboBox);
        panel.add(newHeroesLabel);
        panel.add(newHeroesBox);
        panel.add(textArea);

        add(panel, BorderLayout.CENTER);
    }
}
