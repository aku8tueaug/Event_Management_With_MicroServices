package com.pluralsight.springboot.registration_service.registration;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document("registration")
public record Registration(
        @Id String id,
        @NotNull(message = "Product id is required") Integer productId, // It could not be null
        String ticketCode,
        @NotBlank(message = "Attendee name is required") String attendeeName,// Not null as well not empty string will be accepted
        String eventName,
        BigDecimal amount) {
}
