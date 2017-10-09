package com.rackian.translatedb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@Component
public class DataSource {

    @Value(value = "${database.url}")
    private String url;

    @Value(value = "${database.user}")
    private String user;

    @Value(value = "${database.password}")
    private String password;

    @Value(value = "${database.persistenceunit}")
    private String persistenceunit;

    private EntityManager em;

    public DataSource() {
    }

    public DataSource(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    @PostConstruct
    private void postConstruct() {
        em = Persistence.createEntityManagerFactory(persistenceunit).createEntityManager();
    }

    @PreDestroy
    private void preDestroy() {
        em.close();
    }

}
