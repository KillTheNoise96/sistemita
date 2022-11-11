package com.example.pruebaSis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class Configuracion {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource data = new DriverManagerDataSource();
        data.setUrl("jdbc:sqlserver://192.168.10.136;databaseName=PRUEBA;trustServerCertificate=true");
        data.setUsername("sa");
        data.setPassword("sqlserver");
        return data;
    }
}
