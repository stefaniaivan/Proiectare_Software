package com.airline.web_airline.service;

import com.airline.web_airline.model.Comanda;
import com.airline.web_airline.repository.ComandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComandaServiceImpl implements ComandaService{
    @Autowired
    private ComandaRepository comandaRepository;
    @Override
    public Comanda saveComanda(Comanda comanda) {
        return comandaRepository.save(comanda);
    }

    @Override
    public Optional<Comanda> getOrderById(int id) {
        return comandaRepository.findById(id);
    }

    @Override
    public void deleteOrderById(int id) {
        comandaRepository.deleteById(id);
    }
}
