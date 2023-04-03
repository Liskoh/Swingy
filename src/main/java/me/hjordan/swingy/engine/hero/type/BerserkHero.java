package me.hjordan.swingy.engine.hero.type;

import me.hjordan.swingy.engine.hero.AbstractHero;
import me.hjordan.swingy.engine.hero.HeroType;
import me.hjordan.swingy.engine.stats.Stats;

public class BerserkHero extends AbstractHero {

    public BerserkHero(String name, HeroType type) {
        super(name, type);
    }

    @Override
    public Stats getBonusStats() {
        return new Stats(0.0F, 0.0F, 0.0F);
    }

    @Override
    public void onLevelUp() {

    }

}
