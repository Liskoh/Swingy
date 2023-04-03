package me.hjordan.swingy.objects.config;

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
        this.database = "swingy";
        this.username = "postgres";
        this.password = "postgres";
    }
}
