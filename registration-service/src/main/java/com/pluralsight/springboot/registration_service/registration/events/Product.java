package com.pluralsight.springboot.registration_service.registration.events;

import java.math.BigDecimal;

public record Product(
        int id,
        Event event,
        String name,
        String description,
        BigDecimal price) {
}
