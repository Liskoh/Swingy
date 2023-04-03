package me.hjordan.swingy.manager;

import lombok.Getter;
import me.hjordan.swingy.objects.hero.AbstractHero;

@Getter
public class DatabaseManager extends PersistantManager<AbstractHero> {

    private static DatabaseManager instance = null;

    public DatabaseManager() {
        instance = this;

    }

    @Override
    public void save(AbstractHero hero) {
        final String sql = "INSERT INTO heroes (name, type, level, experience, attack, defense, hitpoints) VALUES (?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    public void delete(AbstractHero hero) {

    }

    @Override
    public void update(AbstractHero hero) {

    }

    @Override
    public AbstractHero find(AbstractHero hero) {
        return null;
    }

    public void initTables() {
        final String sql = "CREATE TABLE IF NOT EXISTS heroes (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, type TEXT," +
                "level INTEGER, experience REAL, attack REAL, defense REAL, hitpoints REAL, weapon INTEGER, armor INTEGER, helm INTEGER)";
    }

}
