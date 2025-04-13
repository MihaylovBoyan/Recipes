package com.example.recipes.service;

import com.example.recipes.model.User;
import com.example.recipes.model.dto.UserDetailsDTO;
import com.example.recipes.model.dto.UserRegisterDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {
    void registerUser(UserRegisterDTO userRegisterDTO);

    UserDetailsDTO showUserDetailsById(Long id);

    boolean isEmailUnique(String email);

    User findByUsername(String createdBy);

    UserDetailsDTO showUserDetailsByUsername(String username);

    void saveProfilePicture(String username, MultipartFile image) throws IOException;
}
