package me.hjordan.swingy.objects.config;

import lombok.Getter;

@Getter
public class PostgresConfig {

    private String host;
    private String port;
    private String database;
    private String username;
    private String password;

    public PostgresConfig() {
        this.host = "localhost";
        this.port = "5432";
        this.database = "swingy";
        this.username = "postgres";
        this.password = "postgres";
    }
}
