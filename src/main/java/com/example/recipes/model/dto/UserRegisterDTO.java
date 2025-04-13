package com.example.recipes.model.dto;

import com.example.recipes.validation.annotation.UniqueEmail;
import com.example.recipes.validation.annotation.UniqueUsername;
import jakarta.validation.constraints.*;

public class UserRegisterDTO {

    @NotBlank
    @UniqueUsername(message = "This username is already taken!")
    @Size(min =  5, max = 20)
    private String username;

    @Email
    @UniqueEmail(message = "Email is already in use!")
    private String email;

    @NotBlank
    @Size(min =  6, max = 20)
    private String password;

    @NotBlank
    @Size(min =  6, max = 20)
    private String confirmPassword;

    @NotBlank
    @Size(min =  5, max = 20)
    private String firstName;

    @NotBlank
    @Size(min =  5, max = 20)
    private String lastName;

    @NotNull
    @Min(10)
    @Max(90)
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

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterDTO setLastName(String lastName) {
        this.lastName = lastName;
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
