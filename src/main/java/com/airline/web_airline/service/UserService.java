package com.airline.web_airline.service;

import com.airline.web_airline.model.Bilet;
import com.airline.web_airline.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Optional<User> getUserById(int id);

    public void deleteUserById(int id);

    public List<User> getAllUsers();

    //public List<User> getUsersByComada();
}
