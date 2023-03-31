package com.runshop.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


import javax.sql.DataSource;


@Configuration //какте классы будут созданы
@PropertySource("classpath:database.properties")
@ComponentScan("com.runshop")
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringConfig {

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    } //подкл. к Hikari a hikari даст соедениение к БД

    @Bean
    public ViewResolver internalResourceViewResolver() {
        return new InternalResourceViewResolver("/WEB-INF/jsp/", ".jsp");
    }

    @Bean
    public NamedParameterJdbcTemplate
    namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }


    @Bean
    public DataSource hikariDatasource(DatabaseProperties properties) {
        HikariDataSource hikariDataSource = new HikariDataSource();

        hikariDataSource.setUsername(properties.getLogin());
        hikariDataSource.setPassword(properties.getPassword());
        hikariDataSource.setDriverClassName(properties.getDriverName());
        hikariDataSource.setMaximumPoolSize(properties.getPoolSize());
        hikariDataSource.setJdbcUrl(properties.getJdbcUrl());

        return hikariDataSource;
    }

}