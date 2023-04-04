package me.hjordan.swingy.engine.hero.type;

import me.hjordan.swingy.engine.hero.AbstractHero;
import me.hjordan.swingy.engine.hero.HeroType;
import me.hjordan.swingy.engine.stats.Stats;

public class WizardHero extends AbstractHero {

    public WizardHero(String name) {
        super(name, HeroType.WIZARD);
    }

    @Override
    public Stats getBonusStats() {
        return new Stats(0, 0, 0);
    }

    @Override
    public void onLevelUp() {

    }
}
