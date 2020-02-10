package com.example.webfluxdemo.config;

import com.example.webfluxdemo.exception.CustomSqlErrorCodeR2dbcExceptionTranslator;
import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@EnableR2dbcRepositories("com.example.webfluxdemo.repository")
public class PostgresConfig extends AbstractR2dbcConfiguration {

    @Override
    public ConnectionFactory connectionFactory() {
        return new PostgresqlConnectionFactory(
                PostgresqlConnectionConfiguration.builder()
                        .host("localhost")
                        .port(5432)
                        .username("postgres")
                        .password("postgres")
                        .database("MSecvice")
                        .build());
    }
    @Bean("client")
    public DatabaseClient getDatabaseClient(){
        CustomSqlErrorCodeR2dbcExceptionTranslator exceptionTranslator =
                new CustomSqlErrorCodeR2dbcExceptionTranslator();
        DatabaseClient client = DatabaseClient.builder()
                .connectionFactory(connectionFactory())
                .exceptionTranslator(exceptionTranslator)
                .build();
        return client;
    }

}