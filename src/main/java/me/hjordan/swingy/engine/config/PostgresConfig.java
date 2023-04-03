package me.hjordan.swingy.engine.config;

import lombok.Getter;

@Getter
public class PostgresConfig {

    private final String host;
    private final String port;
    private final String database;
    private final String username;
    private final String password;

    public PostgresConfig() {
        this.host = "localhost";
        this.port = "5432";
        this.database = "test";
        this.username = "swingy";
        this.password = "swingy";
    }
}
