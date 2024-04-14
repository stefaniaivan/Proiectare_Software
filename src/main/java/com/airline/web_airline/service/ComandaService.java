package com.airline.web_airline.service;

import com.airline.web_airline.model.Comanda;

import java.util.Optional;

public interface ComandaService {
    public Comanda saveComanda(Comanda comanda);

    public Optional<Comanda> getOrderById(int id);

    public void deleteOrderById(int id);
}
