package org.example;

import org.example.DataGenerator.DataGenerator;
import org.example.Service.CustomerService;
import org.example.Service.OrderService;
import org.example.model.Customer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = DataGenerator.generateCustomers();
        CustomerService customerService = new CustomerService(customers);
        OrderService orderService = new OrderService(DataGenerator.generateOrders());

        System.out.println("All customers:");
        customerService.getAllCustomers().forEach(customer -> System.out.println(customer.getName()));

        System.out.println("\nCustomers containing 'C':");
        customerService.getCustomersContainingLetter('C').forEach(customer -> System.out.println(customer.getName()));

        System.out.println("\nTotal invoice amount for June:");
        System.out.println(customerService.getTotalInvoiceAmountForJune());

        System.out.println("\nAll invoices:");
        orderService.getAllInvoices().forEach(invoice -> System.out.println(invoice.getAmount()));

        System.out.println("\nInvoices above 1500:");
        orderService.getInvoicesAboveAmount(1500).forEach(invoice -> System.out.println(invoice.getAmount()));

        System.out.println("\nAverage amount of invoices above 1500:");
        System.out.println(orderService.getAverageInvoiceAmountAbove(1500));

        System.out.println("\nCustomer names with invoices below 500:");
        orderService.getCustomerNamesWithInvoicesBelow(500).forEach(System.out::println);

        System.out.println("\nSectors with average invoice below 750 for June:");
        orderService.getSectorsWithAverageInvoiceBelowForJune(750).forEach(System.out::println);
    }
}