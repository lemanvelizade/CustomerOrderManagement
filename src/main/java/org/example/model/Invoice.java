package org.example.model;


import java.time.LocalDate;

public class Invoice {
    private final int id;
    private double amount;
    private LocalDate date;
    private String sector;

    public Invoice(int id, double amount, LocalDate date, String sector) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.sector = sector;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
}