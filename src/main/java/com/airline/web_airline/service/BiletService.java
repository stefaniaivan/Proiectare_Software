package com.airline.web_airline.service;

import com.airline.web_airline.model.Bilet;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BiletService {
    public Bilet saveBilet(Bilet bilet);
    public List<Bilet> getAllBilete();
    public Optional<Bilet> getBiletById(int id);
    public void deleteBiletById(int id);
    List<Bilet> findByOrasPlecare(String orasPlecare);
    List<Bilet> findByQuery(String orasPlecare, Optional<String> orasDestinatie, Optional<LocalDate> dataPlecare);
}
