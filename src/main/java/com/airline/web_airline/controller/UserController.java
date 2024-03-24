package com.airline.web_airline.controller;

import com.airline.web_airline.model.Bilet;
import com.airline.web_airline.model.User;
import com.airline.web_airline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String add(@RequestBody User user){
        userService.saveUser(user);
        return "New user is added";
    }

    @GetMapping("/getById/{id}")
    public Optional<User> getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        Optional<User> existingUser = userService.getUserById(id);
        if(existingUser.isPresent()){
            userService.deleteUserById(id);
            return "User with ID " + id + " has been deleted";
        }
        else
            return "User with ID " + id +" does not exist";
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable int id, @RequestBody User updatedUser) {
        Optional<User> existingUserOptional = userService.getUserById(id);
        if(existingUserOptional.isPresent()){
            User existingUser = existingUserOptional.get();
            if (updatedUser.getEmail() != null) {
                existingUser.setEmail(updatedUser.getEmail());
            }
            if (updatedUser.getNume() != null) {
                existingUser.setNume(updatedUser.getNume());
            }
            if (updatedUser.getPrenume() != null) {
                existingUser.setPrenume(updatedUser.getPrenume());
            }
            userService.saveUser(existingUser);
            return "User with ID " + id + " has been updated";
        }
        else
            return "User with ID " + id + " does not exist";
    }
}
