package me.hjordan.swingy.engine.stats;

import lombok.Getter;
import lombok.Setter;
import me.hjordan.swingy.engine.hero.AbstractHero;

@Getter
@Setter
public class Stats {

    private float attackPoints;
    private float defensePoints;
    private float hitPoints;

    public Stats() {
        this.attackPoints = 0;
        this.defensePoints = 0;
        this.hitPoints = 0;
    }

    public Stats(float attackPoints, float defensePoints, float hitPoints) {
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.hitPoints = hitPoints;
    }

    public static Stats getStatsFromHero(AbstractHero hero) {
        final Stats bonusStats = hero.getBonusStats();


        return new Stats(hero.getAttackPoints(), hero.getDefensePoints(), hero.getHitPoints());
    }
}
