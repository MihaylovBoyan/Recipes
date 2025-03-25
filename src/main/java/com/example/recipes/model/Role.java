package com.example.recipes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private UserRolesEnum name;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public Role setId(Long id) {
        this.id = id;
        return this;
    }

    public UserRolesEnum getName() {
        return name;
    }

    public Role setName(UserRolesEnum name) {
        this.name = name;
        return this;
    }
}
