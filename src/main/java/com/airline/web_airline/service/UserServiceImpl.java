package com.airline.web_airline.service;

import com.airline.web_airline.model.User;
import com.airline.web_airline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    /**
     * Aceasta metoda salveaza utilizatorul in baza de date.
     * @param user
     * @return
     * Acestă metodă utilizează un query generat automat de către Spring Data JPA, similar cu acesta INSERT INTO user (email, nume, prenume) VALUES (value1, value2, value2);
     */
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Aceasta metoda returneaza un utilizator din baza de date cu id-ul specificat.
     * @param id
     * @return
     * findById este o metodă furnizată de Spring Data JPA care caută un utilizator în baza de date după ID-ul specificat: SELECT * FROM user WHERE id = ?;
     */
    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    /**
     * Aceasta metoda sterge utilizatorul din baza de date cu id-ul specificat.
     * @param id
     * se va genera un query SQL de tipul "DELETE FROM user WHERE id = ?" pentru a șterge utilizatorul din baza de date în funcție de ID-ul specificat.
     */
    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean login(String email, String parola) {
        User user = userRepository.findByEmail(email);
        if(user != null & user.getParola().equals(parola)){
            return true;
        }else
            return false;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


}
