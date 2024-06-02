package com.airline.web_airline.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Comanda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComanda;
    private int idBilet;
    private int idUser;
    private LocalDate orderDate;
    private String totalAmount;
    private String paymentStatus;

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Comanda(){
    }

    public Comanda(int idComanda, int idBilet, int idUser, LocalDate orderDate, String totalAmount, String paymentStatus){
        this.idComanda = idComanda;
        this.idBilet = idBilet;
        this.idUser = idUser;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
    }

    public Comanda(int idBilet, int idUser, LocalDate orderDate, String totalAmount, String paymentStatus){
        this.idBilet = idBilet;
        this.idUser = idUser;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdBilet() {
        return idBilet;
    }

    public void setIdBilet(int idBilet) {
        this.idBilet = idBilet;
    }

    public int getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(int idComanda) {
        this.idComanda = idComanda;
    }
}
