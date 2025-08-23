package com.jpueyodev.integrationtest;

import java.util.Map;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MapPropertySource;
import org.testcontainers.containers.MySQLContainer;

public class TestcontainersMySqlInitializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    public static final MySQLContainer<?> MYSQL = new MySQLContainer<>("mysql:8.4")
            .withDatabaseName("testdb").withUsername("testuser").withPassword("testpass");

    static { MYSQL.start(); }

    @Override
    public void initialize(ConfigurableApplicationContext ctx) {
        var p = Map.<String,Object>of(
            "db.driverClass","com.mysql.cj.jdbc.Driver",
            "db.jdbcUrl",    MYSQL.getJdbcUrl(),
            "db.user",       MYSQL.getUsername(),
            "db.password",   MYSQL.getPassword(),
            "db.minPoolSize",1,
            "db.maxPoolSize",5,
            "db.maxIdleTime",60
        );
        ctx.getEnvironment().getPropertySources()
           .addFirst(new MapPropertySource("tc-mysql", p));
    }
}

