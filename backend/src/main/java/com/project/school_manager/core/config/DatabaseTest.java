package com.project.school_manager.core.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void testConnection() {
        try {
            String result = jdbcTemplate.queryForObject(
                "SELECT 'Conexão bem sucedida!' AS message",
                String.class
            );
            System.out.println("🎉 BANCO DE DADOS: " + result);
        } catch (Exception e) {
            System.err.println("❌ ERRO NO BANCO: " + e.getMessage());
            e.printStackTrace();
        }
    }
}