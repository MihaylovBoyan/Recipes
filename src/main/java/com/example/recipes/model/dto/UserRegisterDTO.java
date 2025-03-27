package com.example.recipes.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegisterDTO {

    //todo validate!

    @NotBlank
    private String username;
    @Email
    private String email;
    @NotBlank
    private String password;
    private String confirmPassword;
    @NotBlank
    private String fullName;
    @Size(min = 10, max = 100)
    private Integer age;

    public UserRegisterDTO() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterDTO setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserRegisterDTO setAge(Integer age) {
        this.age = age;
        return this;
    }
}
