package com.pluralsight.springboot.events_service.events;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    public List<Product> findByEventId(int eventId);
//    private final List<Product> products = List.of(
//            new Product(801, 501, "Standard", "Standard Conference Ticket", new BigDecimal("499.00")),
//            new Product(802, 501, "Premium", "Premium Conference Ticket", new BigDecimal("649.00")),
//            new Product(803, 502, "Standard", "Developer Day Ticket", new BigDecimal("195.50")),
//            new Product(804, 503, "Regular", "Regular Entrance", new BigDecimal("35.00")),
//            new Product(805, 503, "VIP", "VIP Bonus Entrance", new BigDecimal("65.00")));
//
//    public List<Product> findByEventId(int eventId) {
//        return products.stream().filter(product -> product.eventId() == eventId).toList();
//    }
}
