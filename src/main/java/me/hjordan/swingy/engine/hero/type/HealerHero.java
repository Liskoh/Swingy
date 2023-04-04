package me.hjordan.swingy.engine.hero.type;

import me.hjordan.swingy.engine.hero.AbstractHero;
import me.hjordan.swingy.engine.hero.HeroType;
import me.hjordan.swingy.engine.stats.Stats;

public class HealerHero extends AbstractHero {

    public HealerHero(String name) {
        super(name, HeroType.HEALER);
    }

    @Override
    public Stats getBonusStats() {
        return new Stats();
    }

    @Override
    public void onLevelUp() {

    }
}
