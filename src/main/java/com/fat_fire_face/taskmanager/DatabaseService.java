package com.fat_fire_face.taskmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate =jdbcTemplate;
    }

    //описание запросов для бд




}
