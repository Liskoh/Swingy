package me.hjordan.swingy.engine.hero;

import lombok.Data;
import lombok.Getter;
import me.hjordan.swingy.engine.artifact.Artifact;
import me.hjordan.swingy.engine.artifact.ArtifactType;
import me.hjordan.swingy.engine.stats.Stats;
import me.hjordan.swingy.utils.Consts;

@Data
@Getter
public abstract class AbstractHero {

    private String name;
    private HeroType type;
    private int level;
    private double experience;
    private float attackPoints;
    private float defensePoints;
    private float hitPoints;
    private Artifact[] artifactSlots;

    public AbstractHero(String name, HeroType type) {
        this.name = name;
        this.type = type;
        this.level = 0;
        this.experience = 0.0D;
        this.attackPoints = 0.0F;
        this.defensePoints = 0.0F;
        this.hitPoints = 0.0F;
        this.artifactSlots = new Artifact[Consts.ARTIFACTS_SLOT_COUNT];
    }

    public void setStats(int level, double experience, float attackPoints, float defensePoints, float hitPoints) {
        this.level = level;
        this.experience = experience;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.hitPoints = hitPoints;
    }

    public void setArtifacts(int weapon, int armor, int helm) {
       // this.artifactSlots[Consts.ARTIFACTS_WEAPON] = Artifact.builder().type(ArtifactType.WEAPON).value(weapon).build();
       // this.artifactSlots[Consts.ARTIFACTS_ARMOR] = Artifact.builder().type(ArtifactType.ARMOR).value(armor).build();
       // this.artifactSlots[Consts.ARTIFACTS_HELMET] = Artifact.builder().type(ArtifactType.HELMET).value(helm).build();
    }

    public abstract Stats getBonusStats();

    public Stats getStatsFromArtifacts() {
        float attackPoints = 0.0F;
        float defensePoints = 0.0F;
        float hitPoints = 0.0F;

        for (Artifact artifact : this.artifactSlots) {
            if (artifact == null)
                continue;

            if (artifact.getType() == ArtifactType.WEAPON)
                attackPoints += artifact.getValue();
            else if (artifact.getType() == ArtifactType.ARMOR)
                defensePoints += artifact.getValue();
            else if (artifact.getType() == ArtifactType.HELMET)
                hitPoints += artifact.getValue();
        }

        return new Stats(attackPoints, defensePoints, hitPoints);
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

    public void incrementStats() {
        final int bonus = Consts.STATS_UPDATE_PER_LEVEL * this.level;

        this.attackPoints += bonus;
        this.defensePoints += bonus;
        this.hitPoints += bonus;
    }

    public int getGameSize() {
        final int currentLevel = getLevel() - 1;

        if (currentLevel < 1)
            return 1;

        return (currentLevel) * 5 + 10 - ((currentLevel + 1) % 2);
    }

    public abstract void onLevelUp();


}
