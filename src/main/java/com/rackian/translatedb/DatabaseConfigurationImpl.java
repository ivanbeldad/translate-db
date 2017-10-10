package com.rackian.translatedb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DatabaseConfigurationImpl implements DatabaseConfiguration {

    @Value(value = "${database.url}")
    private String url;

    @Value(value = "${database.user}")
    private String user;

    @Value(value = "${database.password}")
    private String password;

    @Override
    public Map<String, String> config() {
        Map<String, String> config = new HashMap<>();
        config.put("javax.persistence.jdbc.url", url);
        config.put("javax.persistence.jdbc.user", user);
        config.put("javax.persistence.jdbc.password", password);
        return config;
    }

}
