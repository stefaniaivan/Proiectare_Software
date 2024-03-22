package com.airline.web_airline.controller;

import com.airline.web_airline.model.Bilet;
import com.airline.web_airline.service.BiletService;
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

    @PostMapping("/add")
    public String add(@RequestBody Bilet bilet){
        biletService.saveBilet(bilet);
        return "New ticket is added";
    }

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

    /*@PutMapping("/update/{id}")
    public String update(@PathVariable int id, @RequestBody Bilet updatedBilet) {
        Optional<Bilet> existingTicket = biletService.getBiletById(id);
    }*/

    @GetMapping("/getAll")
    public List<Bilet> list(){
        return biletService.getAllBilete();
    }

    @GetMapping("/getById/{id}")
    public Optional<Bilet> getBiletById(@PathVariable int id){
        return biletService.getBiletById(id);
    }

    @GetMapping("/getByOrasPlecare")
    public List<Bilet> getBileteByOrasPlecare(@RequestParam String orasPlecare) {
        return biletService.findByOrasPlecare(orasPlecare);
    }

    @GetMapping("/getByQuery")
    public List<Bilet> findByQuery(@RequestParam String orasPlecare, @RequestParam Optional<String> orasDestinatie, @RequestParam Optional<LocalDate> dataPlecare) {
        return biletService.findByQuery(orasPlecare, orasDestinatie, dataPlecare);
    }


}