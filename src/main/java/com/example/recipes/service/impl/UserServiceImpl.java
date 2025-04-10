package com.example.recipes.service.impl;

import com.example.recipes.model.Role;
import com.example.recipes.model.User;
import com.example.recipes.model.UserRolesEnum;
import com.example.recipes.model.dto.UserDetailsDTO;
import com.example.recipes.model.dto.UserRegisterDTO;
import com.example.recipes.repository.RoleRepository;
import com.example.recipes.repository.UserRepository;
import com.example.recipes.service.RoleService;
import com.example.recipes.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, RoleService roleService, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
        this.roleRepository = roleRepository;
    }

    @Override
    public void registerUser(UserRegisterDTO userRegisterDTO) {
        User mappedUser = mapToUser(userRegisterDTO);
        userRepository.save(mappedUser);
    }

    @Transactional
    @Override
    public UserDetailsDTO showUserDetailsById(Long id) {
        User userById = userRepository.findById(id).orElseThrow();
        return modelMapper.map(userById, UserDetailsDTO.class);
    }

    @Override
    public boolean isEmailUnique(String email) {
        return !userRepository.existsByEmail(email);
    }

    @Override
    public User findByUsername(String createdBy) {
        return userRepository.findByUsername(createdBy).orElseThrow();
    }

    @Override
    //todo finish it!
    public UserDetailsDTO showUserDetailsByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow();
       return new UserDetailsDTO()
               .setAge(user.getAge())
               .setEmail(user.getEmail())
               .setUsername(user.getUsername())
               .setId(user.getId());
    }


    private User mapToUser(UserRegisterDTO userRegisterDTO) {

        Role role = roleRepository.findByName(UserRolesEnum.USER)
                .orElseThrow(() -> new RuntimeException("Role USER not found"));
        User mappedUser = modelMapper.map(userRegisterDTO, User.class);
        mappedUser.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        mappedUser.setRoles(List.of(role));

        return mappedUser;
    }
}
