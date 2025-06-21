package com.pluralsight.springboot.registration_service.registration.events;

public record Venue(
        int id,
        String name,
        String street,
        String city,
        String country) {
}
