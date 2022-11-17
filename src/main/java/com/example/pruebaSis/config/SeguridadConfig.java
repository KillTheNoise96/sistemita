package com.example.pruebaSis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SeguridadConfig {

    @Value("${usrauth}")
    private String usuario;

    @Value("${clsauth}")
    private String clave;

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails userDetails = User.withDefaultPasswordEncoder().
                username(usuario).
                password(clave).
                roles("ADMIN").
                build();
        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http.csrf().
                disable().
                authorizeRequests().
                antMatchers("/clientes/lista").
                permitAll().
                anyRequest().
                authenticated().
                and().
                httpBasic(Customizer.withDefaults()).
                build();
    }
}
