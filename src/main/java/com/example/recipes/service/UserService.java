package com.example.recipes.service;

import com.example.recipes.model.User;
import com.example.recipes.model.dto.UserDetailsDTO;
import com.example.recipes.model.dto.UserRegisterDTO;

public interface UserService {
    void registerUser(UserRegisterDTO userRegisterDTO);

    UserDetailsDTO showUserDetailsById(Long id);

    boolean isEmailUnique(String email);

    User findByUsername(String createdBy);

    UserDetailsDTO showUserDetailsByUsername(String username);
}
