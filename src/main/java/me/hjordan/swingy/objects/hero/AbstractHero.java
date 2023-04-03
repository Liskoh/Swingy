package me.hjordan.swingy.objects.hero;

import lombok.Builder;
import lombok.Data;
import me.hjordan.swingy.utils.Consts;

@Builder
@Data
public abstract class AbstractHero {

    private String name;
    private HeroType type;
    private int level;
    private double experience;
    private float attackPoints;
    private float defensePoints;
    private float hitPoints;
    private int[] artifactSlots;

    public AbstractHero(String name, HeroType type) {
        this.name = name;
        this.type = type;
        this.level = 0;
        this.experience = 0.0D;
        this.attackPoints = 0.0F;
        this.defensePoints = 0.0F;
        this.hitPoints = 0.0F;
        this.artifactSlots = new int[Consts.ARTIFACTS_SLOT_COUNT];
    }

    public double getNextLevelExperience() {
        return this.level * 1000 + Math.pow((this.level - 1), 2) * 450;
    }

    public void addExperience(double experience) {
        final double nextLevelExperience = this.getNextLevelExperience();

        this.experience += experience;

        if (this.experience >= nextLevelExperience) {
            this.level++;
            this.onLevelUp();
        }
    }

    public int getGameSize() {
        final int currentLevel = getLevel() - 1;

        if (currentLevel < 1)
            return 1;

        return (currentLevel) * 5 + 10 - ((currentLevel + 1) % 2);
    }

    public abstract void onLevelUp();


}
