package com.airline.web_airline.service;

import com.airline.web_airline.model.Bilet;
import com.airline.web_airline.repository.BiletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BiletServiceImpl implements BiletService {

    @Autowired
    private BiletRepository biletRepository;

    @Override
    public Bilet saveBilet(Bilet bilet) {
        return biletRepository.save(bilet);
    }

    @Override
    public List<Bilet> getAllBilete() {
        return biletRepository.findAll();
    }

    @Override
    public Optional<Bilet> getBiletById(int id) {
        return biletRepository.findById(id);
    }

    @Override
    public List<Bilet> findByOrasPlecare(String orasPlecare) {
        return biletRepository.findBiletsByOrasPlecare(orasPlecare);
    }

    public void deleteBiletById(int id){
        biletRepository.deleteById(id);
    }

    @Override
    public List<Bilet> findByQuery(String orasPlecare, Optional<String> orasDestinatie, Optional<LocalDate> dataPlecare) {
        return biletRepository.findBiletsByOrasPlecareAndOrasDestinatieAndDataPlecareIsAfter(orasPlecare,orasDestinatie,dataPlecare );
    }

}
