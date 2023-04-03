package me.hjordan.swingy.manager;

import lombok.Getter;
import me.hjordan.swingy.objects.config.PostgresConfig;

@Getter
public class ConfigManager {

    private PostgresConfig config;
    @Getter
    private static ConfigManager instance;

    public ConfigManager() {
        super();
        instance = this;
    }

    public PostgresConfig load() {
        return null;
    }

    public void save(PostgresConfig config) {

    }


    public PostgresConfig get() {
        if (this.config != null)
            return this.config;

        final PostgresConfig loadedConfig = load();

        if (loadedConfig == null) {
            this.config = new PostgresConfig();
            this.save(this.config);
        }

        return this.config;
    }
}
