package com.airline.web_airline.controller;

import com.airline.web_airline.BiletNotification;
import com.airline.web_airline.model.Bilet;
import com.airline.web_airline.model.User;
import com.airline.web_airline.service.BiletService;
import com.airline.web_airline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bilete")
@CrossOrigin
public class BiletController {
    @Autowired
    private BiletService biletService;

    @Autowired
    private UserService userService;

    private BiletNotification biletNotification;

    @Autowired
    public BiletController(BiletService biletService, UserService userService) {
        this.biletNotification = new BiletNotification();
        this.biletService = biletService;
        this.userService = userService;

        List<User> users = userService.getAllUsers();
        for (User user : users) {
            biletNotification.addObserver(user);
        }
    }

    /**
     * Aceasta metoda permite adaugarea unui obiect de tipul Bilet in baza de date.
     * @param bilet reprezinta obicetul pe care ne dorim sa-l adaugam in baza de date
     * @return un mesaj de succes dupa ce obiectul a fost adaugat in baza de date
     */
    @PostMapping("/add")
    public String add(@RequestBody Bilet bilet){
        biletService.saveBilet(bilet);
        return "New ticket is added";
    }

    /**
     * Aceasta metoda permite stergerea unui obiect de tipul Bilet din baza de date in functie de id.
     * @param id id-ul biletului care se doreste a fi sters
     * @return un mesaj de succes in cazul in care obiectul a fost sters sau un mesaj care indica faptul ca obiectul nu exista in baza de date
     */
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        Optional<Bilet> existingTicket = biletService.getBiletById(id);
        if(existingTicket.isPresent()){
            biletService.deleteBiletById(id);
            return "Ticket with ID " + id + " has been deleted";
        }
        else
            return "Ticket with ID " + id +" does not exist";
    }

    /**
     * Aceasta metoda permite modificarea unui obiect Bilet deja existent in baza de date.
     * @param id id-ul obiectului pe care dorim sa-l modificam
     * @param updatedBilet un obiect de tipul Bilet care contine datele actualizate pe care dorim sa le introducem in baza de date
     * @return mesaj de succes in cazul in care biletul a fost modificat sau un mesaj care indica faptul ca biletul cu id-ul specificat nu exista
     */
    @PutMapping("/update/{id}")
    public String update(@PathVariable int id, @RequestBody Bilet updatedBilet) {
        Optional<Bilet> existingTicketOptional = biletService.getBiletById(id);
        if(existingTicketOptional.isPresent()){
            Bilet existingTicket = existingTicketOptional.get();
            boolean priceChanged = false;
            if (updatedBilet.getOrasPlecare() != null) {
                existingTicket.setOrasPlecare(updatedBilet.getOrasPlecare());
            }
            if (updatedBilet.getOrasDestinatie() != null) {
                existingTicket.setOrasDestinatie(updatedBilet.getOrasDestinatie());
            }
            if (updatedBilet.getOraPlecare() != null) {
                existingTicket.setOraPlecare(updatedBilet.getOraPlecare());
            }
            if (updatedBilet.getDataPlecare() != null) {
                existingTicket.setDataPlecare(updatedBilet.getDataPlecare());
            }
            if (updatedBilet.getPret() != null) {
                if (!updatedBilet.getPret().equals(existingTicket.getPret())) {
                    priceChanged = true;
                    existingTicket.setPret(updatedBilet.getPret());
                }
            }
            if (updatedBilet.getLocuriDisponibile() != 0) {
                existingTicket.setLocuriDisponibile(updatedBilet.getLocuriDisponibile());
            }
            if (updatedBilet.getLocuriOcupate() != 0) {
                existingTicket.setLocuriOcupate(updatedBilet.getLocuriOcupate());
            }
            biletService.saveBilet(existingTicket);
            if (priceChanged) {
                biletNotification.setPret(existingTicket.getPret());
            }

            return "Ticket with ID " + id + " has been updated";
        }
        else
            return "Ticket with ID " + id + " does not exist";
    }

    /**
     * Aceasta metoda permite vizualizarea tuturor obiectelor de tipul Bilet.
     * @return o lista care contine toate biletele din tabelul aferent din baza de date
     */
    @GetMapping("/getAll")
    public List<Bilet> list(){
        return biletService.getAllBilete();
    }

    /**
     * Aceasta metoda returneaza biletul din baza de date aferent id-ului trimis ca si parametru.
     * @param id in functie de id-ul specificat se returneaza biletul corespunzator
     * @return un obiect optional care contine biletul cu id-ul specificat sau un obiect gol in cazul in care biletul cu id-ul specificat nu exista
     */
    @GetMapping("/getById/{id}")
    public Optional<Bilet> getBiletById(@PathVariable int id){
        return biletService.getBiletById(id);
    }

    /**
     * Aceasta metoda returneaza lista biletelor care au orasul de plecare specificat ca si parametru
     * @param orasPlecare cautarea in baza de date se va face in functie de orasul de plecare
     * @return se returneaza o lista ce contine toate biletele cu un anumit oras de plecare
     */
    @GetMapping("/getByOrasPlecare")
    public List<Bilet> getBileteByOrasPlecare(@RequestParam String orasPlecare) {
        return biletService.findByOrasPlecare(orasPlecare);
    }

    /**
     * Aceasta metoda creeaza un query care permite o cautare mai complexa a biletelor in baza de date
     * @param orasPlecare reprezinta orasul de plecare al unui bilet
     * @param orasDestinatie reprezinta orasul desinatie al biletului
     * @param dataPlecare reprezinta data la care are loc plecarea din orasul de plecare
     * @return se returneaza lista biletelor ce indeplinesc criteriile mentionate de catre utilizator
     */
    @GetMapping("/getByQuery")
    public List<Bilet> findByQuery(@RequestParam String orasPlecare, @RequestParam Optional<String> orasDestinatie, @RequestParam Optional<LocalDate> dataPlecare) {
        return biletService.findByQuery(orasPlecare, orasDestinatie, dataPlecare);
    }


}