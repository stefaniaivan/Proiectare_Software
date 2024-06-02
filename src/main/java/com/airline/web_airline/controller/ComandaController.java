package com.airline.web_airline.controller;

import com.airline.web_airline.model.Comanda;
import com.airline.web_airline.service.ComandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/comenzi")
@CrossOrigin
public class ComandaController {
    @Autowired
    private ComandaService comandaService;

    @PostMapping("/add")
    public String add(@RequestBody Comanda comanda){
        comandaService.saveComanda(comanda);
        return "New order is added";
    }

    @GetMapping("/getById/{id}")
    public Optional<Comanda> getOrderById(@PathVariable int id){
        return comandaService.getOrderById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        Optional<Comanda> existingOrderOptional = comandaService.getOrderById(id);
        if(existingOrderOptional.isPresent()){
            comandaService.deleteOrderById(id);
            return "Order with id " + id + " has been deleted!";
        }
        else
            return "Ticket with id " + id + " does not exist!";
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable int id, @RequestBody Comanda updatedOrder){
        Optional<Comanda> existingOrderOptional = comandaService.getOrderById(id);
        if(existingOrderOptional.isPresent()){
            Comanda existingOrder = existingOrderOptional.get();
            if(updatedOrder.getIdBilet() != 0){
                existingOrder.setIdBilet(updatedOrder.getIdBilet());
            }
            if(updatedOrder.getIdUser() != 0){
                existingOrder.setIdUser(updatedOrder.getIdUser());
            }

            if(updatedOrder.getOrderDate() != null){
                existingOrder.setOrderDate(updatedOrder.getOrderDate());
            }

            if(updatedOrder.getTotalAmount()!= null){
                existingOrder.setTotalAmount(updatedOrder.getTotalAmount());
            }

            if(updatedOrder.getPaymentStatus() != null){
                existingOrder.setPaymentStatus(updatedOrder.getPaymentStatus());
            }
            comandaService.saveComanda(existingOrder);
            return "Order with id " + id + " has been updated!";
        }
        else
            return "Ticket with id " + id + " does not exist!";

    }
}
