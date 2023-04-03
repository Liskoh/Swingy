package me.hjordan.swingy.objects.hero.dao;

import me.hjordan.swingy.objects.hero.AbstractHero;
import me.hjordan.swingy.objects.hero.HeroType;
import me.hjordan.swingy.objects.hero.type.BerserkHero;
import me.hjordan.swingy.utils.Consts;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroesDAO {
    private static final String TABLE_NAME = "heroes";
    private static final String COL_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_TYPE = "type";
    private static final String COL_LEVEL = "level";
    private static final String COL_EXPERIENCE = "experience";
    private static final String COL_ATTACK = "attack";
    private static final String COL_DEFENSE = "defense";
    private static final String COL_HITPOINTS = "hitpoints";
    private static final String COL_WEAPON = "weapon";
    private static final String COL_ARMOR = "armor";
    private static final String COL_HELM = "helm";

    private static final String SQL_INSERT =
            "INSERT INTO " + TABLE_NAME + " (" +
                    COL_NAME + ", " +
                    COL_TYPE + ", " +
                    COL_LEVEL + ", " +
                    COL_EXPERIENCE + ", " +
                    COL_ATTACK + ", " +
                    COL_DEFENSE + ", " +
                    COL_HITPOINTS + ", " +
                    COL_WEAPON + ", " +
                    COL_ARMOR + ", " +
                    COL_HELM +
                    ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_SELECT_BY_NAME =
            "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_NAME + " = ?";

    private static final String SQL_SELECT_ALL =
            "SELECT * FROM " + TABLE_NAME;

    private Connection connection;

    public HeroesDAO(Connection connection) {
        this.connection = connection;
    }

    public void createTable() {
        final String sql = "CREATE TABLE IF NOT EXISTS heroes (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, type TEXT," +
                "level INTEGER, experience REAL, attack REAL, defense REAL, hitpoints REAL, weapon INTEGER, armor INTEGER, helm INTEGER)";

        try (Statement statement = this.connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveHero(AbstractHero hero) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)) {
            stmt.setString(1, hero.getName());
            stmt.setString(2, hero.getType().toString());
            stmt.setInt(3, hero.getLevel());
            stmt.setDouble(4, hero.getExperience());
            stmt.setDouble(5, hero.getAttackPoints());
            stmt.setDouble(6, hero.getDefensePoints());
            stmt.setDouble(7, hero.getHitPoints());
            stmt.setInt(8, hero.getArtifactSlots()[Consts.ARTIFACTS_WEAPON].getId());
            stmt.setInt(9, hero.getArtifactSlots()[Consts.ARTIFACTS_ARMOR].getId());
            stmt.setInt(10, hero.getArtifactSlots()[Consts.ARTIFACTS_HELMET].getId());

            stmt.executeUpdate();
        }
    }

    public AbstractHero findHeroByName(String name) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_BY_NAME)) {
            stmt.setString(1, name);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return createHeroFromResultSet(rs);
                } else {
                    return null;
                }
            }
        }
    }

    public List<AbstractHero> findAllHeroes() throws SQLException {
        List<AbstractHero> heroes = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ALL)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    heroes.add(createHeroFromResultSet(rs));
                }
            }
        }

        return heroes;
    }

    private AbstractHero createHeroFromResultSet(ResultSet rs) throws SQLException {
        final String name = rs.getString(COL_NAME);
        final String type = rs.getString(COL_TYPE);
        final int level = rs.getInt(COL_LEVEL);
        final double experience = rs.getDouble(COL_EXPERIENCE);
        final float attack = rs.getFloat(COL_ATTACK);
        final float defense = rs.getFloat(COL_DEFENSE);
        final float hitpoints = rs.getFloat(COL_HITPOINTS);

        final int weapon = rs.getInt(COL_WEAPON);
        final int armor = rs.getInt(COL_ARMOR);
        final int helm = rs.getInt(COL_HELM);

        final HeroType heroType = HeroType.valueOf(type);

        switch (heroType) {
            case BERSERK -> {
                final BerserkHero berserkHero = new BerserkHero(name, heroType);

                berserkHero.setStats(level, experience, attack, defense, hitpoints);
                berserkHero.setArtifacts(weapon, armor, helm);

                return berserkHero;
            }
            default -> throw new IllegalArgumentException("Unknown hero type: " + heroType);
        }
    }
}
