package org.example.model;


import java.time.LocalDate;
import java.util.List;

public class Customer {
    private final int id;
    private String name;
    private LocalDate registrationDate;
    private List<Order> orders;

    public Customer(int id, String name, LocalDate registrationDate, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.registrationDate = registrationDate;
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}