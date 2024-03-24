package com.airline.web_airline.service;

import com.airline.web_airline.model.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Optional<User> getUserById(int id);

    public void deleteUserById(int id);
}
