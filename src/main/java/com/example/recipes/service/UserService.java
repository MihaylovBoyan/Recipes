package com.example.recipes.service;

import com.example.recipes.model.dto.UserDetailsDTO;
import com.example.recipes.model.dto.UserRegisterDTO;

public interface UserService {
    void registerUser(UserRegisterDTO userRegisterDTO);

    UserDetailsDTO showUserDetailsById(Long id);
}
