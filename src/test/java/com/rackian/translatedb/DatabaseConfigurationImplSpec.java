package com.rackian.translatedb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(properties = {
        "database.url=jdbc:mysql://localhost:3306/db",
        "database.user=me",
        "database.password=pass"
})
@ContextConfiguration(locations = "classpath:/application-context.xml")
public class DatabaseConfigurationImplSpec {

    @Autowired
    private DatabaseConfigurationImpl databaseConfiguration;

    @Test
    public void whenInitializeThenUrlIsCorrect() {
        String property = "javax.persistence.jdbc.url";
        String url = "jdbc:mysql://localhost:3306/db";
        assertThat(databaseConfiguration.config().get(property), is(url));
    }

    @Test
    public void whenInitializeThenUserIsCorrect() {
        String property = "javax.persistence.jdbc.user";
        String user = "me";
        assertThat(databaseConfiguration.config().get(property), is(user));
    }

    @Test
    public void whenInitializeThenPasswordIsCorrect() {
        String property = "javax.persistence.jdbc.password";
        String password = "pass";
        assertThat(databaseConfiguration.config().get(property), is(password));
    }

}
