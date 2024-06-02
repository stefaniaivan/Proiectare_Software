package com.airline.web_airline.model;

import com.airline.web_airline.Observer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User implements Observer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nume;
    private String prenume;
    private String email;
    private String parola;


    public User(int id, String nume, String prenume, String email, String parola){
        this.id = id;
        this.nume =nume;
        this.prenume = prenume;
        this.email = email;
        this.parola = parola;
    }

    public User( String nume, String prenume, String email){
        this.nume =nume;
        this.prenume = prenume;
        this.email = email;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int idUser) {
        this.id = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getParola() {
        return parola;
    }

    public void setPassword(String parola) {
        this.parola = parola;
    }

    @Override
    public void update(String message) {
        System.out.println(nume + " " + prenume + "-"+ email + " received update: " + message);
    }
}
