package com.Back_Finan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/hello").permitAll()
                .requestMatchers("/api/usuarios").permitAll()
                .requestMatchers("/api/perfiles").permitAll() // Permitir solo el acceso al endpoint 
                .anyRequest().authenticated() // Requiere autenticación para otros endpoints
            )
            .csrf(csrf -> csrf.disable()); // Desactivar CSRF

        return http.build();
    }
}
