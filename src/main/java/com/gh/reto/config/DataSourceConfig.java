package com.gh.reto.config;


import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Slf4j
@Configuration
public class DataSourceConfig {

    @Value("${spring.username}")
    private String springUsername;

    @Value("${spring.password}")
    private String springPassword;

    @Bean
    public javax.sql.DataSource dataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/XE");
        hikariDataSource.setUsername(springUsername);
        hikariDataSource.setPassword(springPassword);
        hikariDataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        return hikariDataSource;
    }

}