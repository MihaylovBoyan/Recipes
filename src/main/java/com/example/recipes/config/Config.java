package com.example.recipes.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Config {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers( "/recipe/**", "/recipes/add", "/", "/css/**", "/js/**", "/images/**").permitAll() // Allow public access
                        .anyRequest().authenticated() // Secure other endpoints
                )
                .formLogin(login -> login.disable()) // Disable login form
                .httpBasic(basic -> basic.disable()) // Disable basic authentication
                .csrf(csrf -> csrf.disable()); // Disable CSRF for development

        return http.build();
    }

}
