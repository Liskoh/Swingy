package me.hjordan.swingy.objects.hero.type;

import lombok.Builder;
import me.hjordan.swingy.objects.hero.AbstractHero;
import me.hjordan.swingy.objects.hero.HeroType;
import me.hjordan.swingy.objects.stats.Stats;

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
