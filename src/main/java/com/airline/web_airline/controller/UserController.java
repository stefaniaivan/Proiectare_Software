package com.airline.web_airline.controller;

import com.airline.web_airline.model.Bilet;
import com.airline.web_airline.model.User;
import com.airline.web_airline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * Aceasta metoda permite adaugarea unui obiect de tipul User in baza de date.
     * @param user reprezinta obicetul pe care ne dorim sa-l adaugam in baza de date
     * @return un mesaj de succes dupa ce obiectul a fost adaugat in baza de date
     */
    @PostMapping("/add")
    public String add(@RequestBody User user){
        userService.saveUser(user);
        return "New user is added";
    }

    /**
     * Aceasta metoda returneaza utilizatorul din baza de date aferent id-ului trimis ca si parametru.
     * @param id fiecare obiect din baza de date are un id unic.
     *           In functie de id-ul specificat se returneaza utilizatorul corespunzator
     * @return un obiect optional care contine utilizatorul cu id-ul specificat sau un obiect gol in cazul in care id-ul nu exista
     */
    @GetMapping("/getById/{id}")
    public Optional<User> getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    /**
     * Aceasta metoda permite stergerea unui obiect de tipul User din baza de date in functie de id.
     * @param id id-ul utilizatorului care se doreste a fi sters
     * @return un mesaj de succes in cazul in care obiectul a fost sters sau un mesaj care indica faptul ca obiectul nu exista in baza de date
     */
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        Optional<User> existingUser = userService.getUserById(id);
        if(existingUser.isPresent()){
            userService.deleteUserById(id);
            return "User with ID " + id + " has been deleted";
        }
        else
            return "User with ID " + id +" does not exist";
    }

    /**
     * Aceasta metoda permite modificarea unui obiect User deja existent in baza de date.
     * @param id id-ul obiectului pe care dorim sa-l modificam
     * @param updatedUser un obiect de tipul User care contine datele actualizate pe care dorim sa le introducem in baza de date
     * @return mesaj de succes in cazul in care utilizatorul a fost modificat sau un mesaj care indica faptul ca utilizatorul cu id-ul specificat nu exista
     */
    @PutMapping("/update/{id}")
    public String update(@PathVariable int id, @RequestBody User updatedUser) {
        Optional<User> existingUserOptional = userService.getUserById(id);
        if(existingUserOptional.isPresent()){
            User existingUser = existingUserOptional.get();
            if (updatedUser.getEmail() != null) {
                existingUser.setEmail(updatedUser.getEmail());
            }
            if (updatedUser.getNume() != null) {
                existingUser.setNume(updatedUser.getNume());
            }
            if (updatedUser.getPrenume() != null) {
                existingUser.setPrenume(updatedUser.getPrenume());
            }
            userService.saveUser(existingUser);
            return "User with ID " + id + " has been updated";
        }
        else
            return "User with ID " + id + " does not exist";
    }
}
