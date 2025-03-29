package com.example.recipes.service.impl;

import com.example.recipes.model.Role;
import com.example.recipes.model.UserRolesEnum;
import com.example.recipes.repository.RoleRepository;
import com.example.recipes.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }



}
