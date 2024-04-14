package com.airline.web_airline;

import com.airline.web_airline.model.User;
import com.airline.web_airline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {
    private final List<User> customers;
    @Autowired
    private UserService userService;

    @Autowired
    public NotificationService(UserService userService) {
        this.customers = userService.getAllUsers();
    }

    public void subscribe(User user){
        customers.add(user);
    }

    public void unsubscribe(User user){
        customers.remove(user);
    }

    public void notifyUserAboutTicketPrice(int biletId, String pretNou) {
        for(User user: customers)
            System.out.println("Sending notification to user " + user.getEmail() + " about price update of ticket with id " + biletId);
    }

    /*public void notifyUserAboutPaymentStatus(int comandaId, String status){
        Optional<User> targetUsers = userService.getUserById(comandaId);
    }*/
}
