package com.example.recipes.service.impl;

import com.example.recipes.model.Role;
import com.example.recipes.model.User;
import com.example.recipes.model.UserRolesEnum;
import com.example.recipes.model.dto.UserRegisterDTO;
import com.example.recipes.repository.UserRepository;
import com.example.recipes.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(UserRegisterDTO userRegisterDTO) {

        User mappedUser = mapToUser(userRegisterDTO);


    }

    private User mapToUser(UserRegisterDTO userRegisterDTO){

        Role role = new Role();
        role.setName(UserRolesEnum.USER);
        HashSet<Role> userRole = new HashSet<>();
        userRole.add(role);

        User mappedUser = modelMapper.map(userRegisterDTO, User.class);
        mappedUser.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        mappedUser.setRoles(userRole);

        return mappedUser;
    }
}
