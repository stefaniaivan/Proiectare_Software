package com.airline.web_airline;

import java.util.ArrayList;
import java.util.List;

public class BiletNotification {
    private String pret;
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    public void setPret(String pret) {
        this.pret = pret;
        for (Observer observer : this.observers) {
            observer.update("New ticket price: " + this.pret);
        }
    }
}
