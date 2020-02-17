package com.example.webfluxdemo.config;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.connectionfactory.R2dbcTransactionManager;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
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
   /* @Bean("client")
    public DatabaseClient getDatabaseClient(){
        CustomSqlErrorCodeR2dbcExceptionTranslator exceptionTranslator =
                new CustomSqlErrorCodeR2dbcExceptionTranslator();
        DatabaseClient client = DatabaseClient.builder()
                .connectionFactory(connectionFactory())
                .exceptionTranslator(exceptionTranslator)
                .build();
        return client;
    }*/
   @Bean
   ReactiveTransactionManager transactionManager() {
       return new R2dbcTransactionManager(connectionFactory());
   }
    /*@Bean
    @Override
    public R2dbcCustomConversions r2dbcCustomConversions() {

        List<Converter<?, ?>> converterList = new ArrayList<Converter<?, ?>>();
        converterList.add(new PersonReadConverter());
        converterList.add(new PersonWriteConverter());
        return new R2dbcCustomConversions(getStoreConversions(), converterList);
    }*/
}