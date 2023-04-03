package me.hjordan.swingy.manager;

import lombok.Getter;
import me.hjordan.swingy.engine.config.PostgresConfig;
import me.hjordan.swingy.engine.hero.AbstractHero;
import me.hjordan.swingy.engine.hero.dao.HeroesDAO;

import java.sql.*;
import java.util.List;

@Getter
public class DatabaseManager implements PersistantManager<AbstractHero> {

    private static DatabaseManager instance = null;
    private Connection connection;
    private final HeroesDAO dao;

    public DatabaseManager() {
        instance = this;

        this.connection = this.getConnection();
        this.dao = new HeroesDAO(this.connection);

        this.dao.createTable();
    }

    @Override
    public void save(AbstractHero hero) {
        try {
            this.dao.saveHero(hero);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AbstractHero find(String name) {
        try {
            return this.dao.findHeroByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<AbstractHero> findAll() {
        try {
            return this.dao.findAllHeroes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Connection getConnection() {
        if (this.connection == null) {
            try {
                this.connection = initConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return this.connection;
    }

    public Connection initConnection() throws SQLException {
        final PostgresConfig config = ConfigManager.getInstance().get();

        final String url = "jdbc:postgresql://" + config.getHost() + ":" + config.getPort() + "/" + config.getDatabase();
        final String username = config.getUsername();
        final String password = config.getPassword();

        return DriverManager.getConnection(url, username, password);
    }


}
