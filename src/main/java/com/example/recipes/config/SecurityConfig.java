package com.example.recipes.config;

import com.example.recipes.repository.UserRepository;
import com.example.recipes.service.impl.RecipesUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .authorizeHttpRequests(
                        authorizeRequests ->
                                authorizeRequests
                                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                                        .requestMatchers("/", "/users/login", "/users/register", "/about").permitAll()
                                        .anyRequest().authenticated()

                )
                .formLogin(
                        formLogin ->
                                formLogin.loginPage("/users/login")
                                        .usernameParameter("username")
                                        .passwordParameter("password")
                                        .defaultSuccessUrl("/", true)
                                        .failureUrl("/users/login-error")
                )
                .logout(
                        logout ->
                                logout
                                        .logoutUrl("/users/logout")
                                        .logoutSuccessUrl("/")
                                        .invalidateHttpSession(true)
                )
                .build();

    }


    @Bean
    public RecipesUserDetailsService userDetailsService(UserRepository userRepository) {
        return new RecipesUserDetailsService(userRepository);
    }


}
