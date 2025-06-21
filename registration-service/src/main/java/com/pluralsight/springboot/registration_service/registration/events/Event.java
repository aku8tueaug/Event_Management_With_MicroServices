package com.pluralsight.springboot.registration_service.registration.events;

import java.time.LocalDate;

public record Event(
        int id,
        String name,
        Organiser organiser,
        Venue venue,
        LocalDate stratDate,
        LocalDate endDate) {
}