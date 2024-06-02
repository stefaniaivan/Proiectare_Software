package com.airline.web_airline.repository;

import com.airline.web_airline.model.Bilet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Repository
public interface BiletRepositoryContract extends JpaRepository<Bilet, Integer> {

    Bilet saveTicket(Bilet bilet);

    List<Bilet> getAllAvailableTickets();

    Optional<Bilet> getTicketById(int id);

    void deleteTicketById(int id);

    List<Bilet> findBiletsByOrasPlecare(String orasPlecare);
    List<Bilet> findBiletsByOrasPlecareAndOrasDestinatieAndDataPlecareIsAfter(String orasPlecare, Optional<String> orasDestinatie, Optional<LocalDate> dataPlecare);


}
