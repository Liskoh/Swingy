package me.hjordan.swingy.registry.impl;

import lombok.Getter;
import me.hjordan.swingy.objects.hero.AbstractHero;
import me.hjordan.swingy.objects.hero.HeroType;
import me.hjordan.swingy.objects.hero.type.BerserkHero;
import me.hjordan.swingy.registry.AbstractRegistry;

public class HeroRegistry extends AbstractRegistry<AbstractHero> {

    @Getter
    private static HeroRegistry instance;

    @Override
    public void init() {
        instance = this;

        this.add(new BerserkHero("Berserk", HeroType.BERSERK));
    }
}
