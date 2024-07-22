package org.example.DataGenerator;

import org.example.model.Customer;
import org.example.model.Invoice;
import org.example.model.Order;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataGenerator {
    public static List<Customer> generateCustomers() {
        return Arrays.asList(
                new Customer(1, "Alice", LocalDate.of(2023, 6, 15), Arrays.asList(
                        new Order(1, Arrays.asList(
                                new Invoice(1, 1200, LocalDate.of(2023, 6, 20), "Technology"),
                                new Invoice(2, 3000, LocalDate.of(2023, 7, 10), "Retail")
                        ))
                )),
                new Customer(2, "Bob", LocalDate.of(2023, 5, 10), Arrays.asList(
                        new Order(2, Arrays.asList(
                                new Invoice(3, 450, LocalDate.of(2023, 5, 15), "Food"),
                                new Invoice(4, 600, LocalDate.of(2023, 6, 18), "Technology")
                        ))
                )),
                new Customer(3, "Charlie", LocalDate.of(2023, 6, 25), Arrays.asList(
                        new Order(3, Arrays.asList(
                                new Invoice(5, 1800, LocalDate.of(2023, 6, 30), "Health"),
                                new Invoice(6, 2400, LocalDate.of(2023, 7, 12), "Retail")
                        ))
                ))
        );
    }

    public static List<Order> generateOrders() {
        return generateCustomers().stream()
                .flatMap(customer -> customer.getOrders().stream())
                .collect(Collectors.toList());
    }
}