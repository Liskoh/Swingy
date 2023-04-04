package me.hjordan.swingy.utils;

import me.hjordan.swingy.engine.hero.AbstractHero;
import me.hjordan.swingy.engine.hero.HeroType;
import me.hjordan.swingy.engine.hero.type.BerserkHero;

import java.util.UUID;

public class Utils {

    public static AbstractHero getHeroByType(HeroType type) {
        final String uniqueId = UUID.randomUUID().toString().substring(0, 8);

        switch (type) {
            case BERSERK:
                return new BerserkHero(uniqueId, type);
        }

        return null;
    }
}
