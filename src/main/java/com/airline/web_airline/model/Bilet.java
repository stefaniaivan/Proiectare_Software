package com.airline.web_airline.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Bilet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String orasPlecare;
    private String orasDestinatie;
    private LocalDate dataPlecare;

    private int locuriOcupate;
    private int locuriDisponibile;
    private String oraPlecare;
    private String pret;
    private boolean isAdmin;
    public String getPret() {
        return pret;
    }

    public void setPret(String pret) {
        this.pret = pret;
    }

    public String getOraPlecare() {
        return oraPlecare;
    }

    public void setOraPlecare(String oraPlecare) {
        this.oraPlecare = oraPlecare;
    }

    public Bilet() {
    }

    public Bilet(int id, String orasPlecare, String orasDestinatie, LocalDate dataPlecare, int locuriOcupate, int locuriDisponibile, String oraPlecare, String pret){
        this.id = id;
        this.orasPlecare = orasPlecare;
        this.orasDestinatie = orasDestinatie;
        this.dataPlecare = dataPlecare;
        this.locuriOcupate = locuriOcupate;
        this.locuriDisponibile = locuriDisponibile;
        this.oraPlecare = oraPlecare;
        this.pret = pret;
    }

    public Bilet(String orasPlecare, String orasDestinatie, LocalDate dataPlecare, int locuriOcupate, int locuriDisponibile, String oraPlecare, String pret){
        this.orasPlecare = orasPlecare;
        this.orasDestinatie = orasDestinatie;
        this.dataPlecare = dataPlecare;
        this.locuriOcupate = locuriOcupate;
        this.locuriDisponibile = locuriDisponibile;
        this.oraPlecare = oraPlecare;
        this.pret = pret;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrasPlecare() {
        return orasPlecare;
    }

    public void setOrasPlecare(String orasPlecare) {
        this.orasPlecare = orasPlecare;
    }

    public String getOrasDestinatie() {
        return orasDestinatie;
    }

    public void setOrasDestinatie(String orasDestinatie) {
        this.orasDestinatie = orasDestinatie;
    }

    public LocalDate getDataPlecare() {
        return dataPlecare;
    }

    public void setDataPlecare(LocalDate dataPlecare) {
        this.dataPlecare = dataPlecare;
    }

    public int getLocuriOcupate() {
        return locuriOcupate;
    }

    public void setLocuriOcupate(int locuriOcupate) {
        this.locuriOcupate = locuriOcupate;
    }

    public int getLocuriDisponibile() {
        return locuriDisponibile;
    }

    public void setLocuriDisponibile(int locuriDisponibile) {
        this.locuriDisponibile = locuriDisponibile;
    }

}
