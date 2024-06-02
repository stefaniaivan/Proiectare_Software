package com.airline.web_airline.service;

import com.airline.web_airline.BiletNotification;
import com.airline.web_airline.model.Bilet;
import com.airline.web_airline.model.User;
import com.airline.web_airline.repository.BiletRepository;
import com.airline.web_airline.repository.BiletRepositoryContractImpl;
import com.airline.web_airline.repository.BiletRepositoryContract;
import com.airline.web_airline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BiletServiceImpl implements BiletService {

    private final BiletRepositoryContract IBiletRepository;
    private BiletNotification biletNotification;

    public BiletServiceImpl(@Qualifier("biletRepositoryContractImpl") BiletRepositoryContract IBiletRepository){
        this.IBiletRepository = IBiletRepository;
    }

    /**
     * Aceasta metoda salveaza biletul in baza de date.
     * @param bilet
     * @return
     * Acestă metodă utilizează un query generat automat de către Spring Data JPA, similar cu acesta INSERT INTO bilet (data_plecare, locuri_disponibile, locuri_ocupate, oras_destinatie, oras_plecare, ora_plecare, pret) VALUES (value1, value2, value2, ...);
     */
    @Override
    public Bilet saveBilet(Bilet bilet) {
        return IBiletRepository.saveTicket(bilet);
    }

    /**
     * Aceasta metoda executa un query similar cu acesta "SELECT * FROM bilet" pentru a se returna toate coloanele din tabelul bilet.
     * @return O listă care conține toate biletele din baza de date.
     */
    @Override
    public List<Bilet> getAllBilete() {
        return IBiletRepository.getAllAvailableTickets();
    }

    /**
     *Aceasta metoda returneaza un bilet din baza de date cu id-ul specificat.
     * @param id
     * @return findById este o metodă furnizată care caută un bilet în baza de date după ID-ul specificat: SELECT * FROM bilet WHERE id = ?;
     */
    @Override
    public Optional<Bilet> getBiletById(int id) {
        return IBiletRepository.getTicketById(id);
    }

    @Override
    public List<Bilet> findByOrasPlecare(String orasPlecare) {
        return IBiletRepository.findBiletsByOrasPlecare(orasPlecare);
    }

    /**
     * Aceasta metoda sterge biletul din baza de date cu id-ul specificat. Se va genera un query SQL de tipul "DELETE FROM bilet WHERE id = ?".
     * @param id
     */
    public void deleteBiletById(int id){
        IBiletRepository.deleteTicketById(id);
    }

    @Override
    public List<Bilet> findByQuery(String orasPlecare, Optional<String> orasDestinatie, Optional<LocalDate> dataPlecare) {
        return IBiletRepository.findBiletsByOrasPlecareAndOrasDestinatieAndDataPlecareIsAfter(orasPlecare,orasDestinatie,dataPlecare );

    }
}
