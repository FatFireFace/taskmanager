package com.fat_fire_face.taskmanager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;


@Configuration
public class DatabaseConfig{
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/database_name");
        dataSource.setUsername("your_username");
        dataSource.setPassword("your_password");
        return dataSource;
    }

}
