package com.airline.web_airline.repository;

import com.airline.web_airline.model.Bilet;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class BiletRepositoryContractImpl implements BiletRepositoryContract {
    private final BiletRepository biletRepository;

   public BiletRepositoryContractImpl(BiletRepository biletRepository) {
       this.biletRepository = biletRepository;
   }

    @Override
    public Bilet saveTicket(Bilet bilet) {
        return biletRepository.save(bilet);
    }

    @Override
    public List<Bilet> getAllAvailableTickets() {
        return biletRepository.findAll();
    }

    @Override
    public Optional<Bilet> getTicketById(int id) {
        return biletRepository.findById(id);
    }

    @Override
    public void deleteTicketById(int id) {
        biletRepository.deleteById(id);
    }

    @Override
    public List<Bilet> findBiletsByOrasPlecare(String orasPlecare) {
        return biletRepository.findBiletsByOrasPlecare(orasPlecare);
    }

    @Override
    public List<Bilet> findBiletsByOrasPlecareAndOrasDestinatieAndDataPlecareIsAfter(String orasPlecare, Optional<String> orasDestinatie, Optional<LocalDate> dataPlecare) {
        return biletRepository.findBiletsByOrasPlecareAndOrasDestinatieAndDataPlecareIsAfter(orasPlecare,orasDestinatie, dataPlecare);
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Bilet> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Bilet> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Bilet> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Bilet getOne(Integer integer) {
        return null;
    }

    @Override
    public Bilet getById(Integer integer) {
        return null;
    }

    @Override
    public Bilet getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Bilet> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Bilet> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Bilet> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Bilet> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Bilet> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Bilet> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Bilet, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Bilet> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Bilet> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Bilet> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Bilet> findAll() {
        return null;
    }

    @Override
    public List<Bilet> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Bilet entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Bilet> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Bilet> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Bilet> findAll(Pageable pageable) {
        return null;
    }
}
