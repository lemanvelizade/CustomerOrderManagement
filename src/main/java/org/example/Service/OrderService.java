package org.example.Service;

import org.example.model.Invoice;
import org.example.model.Order;

import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
    private List<Order> orders;

    public OrderService(List<Order> orders) {
        this.orders = orders;
    }

    public List<Invoice> getAllInvoices() {
        return orders.stream()
                .flatMap(order -> order.getInvoices().stream())
                .collect(Collectors.toList());
    }

    public List<Invoice> getInvoicesAboveAmount(double amount) {
        return orders.stream()
                .flatMap(order -> order.getInvoices().stream())
                .filter(invoice -> invoice.getAmount() > amount)
                .collect(Collectors.toList());
    }

    public double getAverageInvoiceAmountAbove(double amount) {
        return orders.stream()
                .flatMap(order -> order.getInvoices().stream())
                .filter(invoice -> invoice.getAmount() > amount)
                .mapToDouble(Invoice::getAmount)
                .average()
                .orElse(0);
    }

    public List<String> getCustomerNamesWithInvoicesBelow(double amount) {
        return orders.stream()
                .flatMap(order -> order.getInvoices().stream())
                .filter(invoice -> invoice.getAmount() < amount)
                .map(invoice -> invoice.getDate().toString())
                .collect(Collectors.toList());
    }

    public List<String> getSectorsWithAverageInvoiceBelowForJune(double amount) {
        return orders.stream()
                .flatMap(order -> order.getInvoices().stream())
                .filter(invoice -> invoice.getDate().getMonthValue() == 6)
                .collect(Collectors.groupingBy(Invoice::getSector, Collectors.averagingDouble(Invoice::getAmount)))
                .entrySet().stream()
                .filter(entry -> entry.getValue() < amount)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }
}