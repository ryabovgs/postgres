package com.example.postgre.config;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;

@Configuration
public class R2dbcConfiguration extends AbstractR2dbcConfiguration {

    //TODO move values to @ConfigurationProperties

    @Value("${database.name}")
    private String database;

    @Value("${database.host}")
    private String host;

    @Value("${database.port:5432}")
    private int port;

    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;


    @Override
    @Bean
    public ConnectionFactory connectionFactory() {
        return new PostgresqlConnectionFactory(PostgresqlConnectionConfiguration.builder()
                .host(host)
                .port(port)
                .username(username)
                .password(password)
                .database(database)
                .build());
    }
}
