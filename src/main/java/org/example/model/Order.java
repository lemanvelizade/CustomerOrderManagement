package org.example.model;

import java.util.List;

public class Order {
    private final int id;
    private List<Invoice> invoices;

    public Order(int id, List<Invoice> invoices) {
        this.id = id;
        this.invoices = invoices;
    }

    public int getId() {
        return id;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }
}