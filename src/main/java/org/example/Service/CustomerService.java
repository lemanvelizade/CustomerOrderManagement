package org.example.Service;

import org.example.model.Customer;
import org.example.model.Invoice;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerService {
    private List<Customer> customers;

    public CustomerService(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getCustomersContainingLetter(char letter) {
        return customers.stream()
                .filter(customer -> customer.getName().indexOf(letter) != -1)
                .collect(Collectors.toList());
    }

    public double getTotalInvoiceAmountForJune() {
        return customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getInvoices().stream())
                .filter(invoice -> invoice.getDate().getMonthValue() == 6)
                .mapToDouble(Invoice::getAmount)
                .sum();
    }
}
