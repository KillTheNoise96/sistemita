package com.example.pruebaSis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class Configuracion {

    @Value("${usrpro}")
    private String usuario;

    @Value("${clspro}")
    private String clave;
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource data = new DriverManagerDataSource();
        data.setUrl("jdbc:sqlserver://192.168.10.136;databaseName=PRUEBA;trustServerCertificate=true");
        data.setUsername(usuario);
        data.setPassword(clave);
        return data;
    }
}
