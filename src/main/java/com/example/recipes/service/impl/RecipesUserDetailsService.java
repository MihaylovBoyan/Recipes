package com.example.recipes.service.impl;

import com.example.recipes.model.RecipeUserDetails;
import com.example.recipes.model.Role;
import com.example.recipes.model.User;
import com.example.recipes.model.UserRolesEnum;
import com.example.recipes.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class RecipesUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public RecipesUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .map(RecipesUserDetailsService::map)
                .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found"));
    }

//    private static UserDetails map(User user) {
//
//        return org.springframework.security.core.userdetails.User
//                .withUsername(user.getUsername())
//                .password(user.getPassword())
//                .authorities(List.of())
//                .disabled(false)
//                .build();
//
//    }

    private static UserDetails map(User user) {
        return new RecipeUserDetails(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream().map(Role::getName).map(RecipesUserDetailsService::map).toList(),
                user.getFirstName(),
                user.getLastName()
        );
    }

    private static GrantedAuthority map(UserRolesEnum role) {

        return new SimpleGrantedAuthority(
                "ROLE_" + role
        );
    }


}
