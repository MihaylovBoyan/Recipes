package com.example.recipes.repository;

import com.example.recipes.model.Role;
import com.example.recipes.model.UserRolesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(UserRolesEnum name);
}
