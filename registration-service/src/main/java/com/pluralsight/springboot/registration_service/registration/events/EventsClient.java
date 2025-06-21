package com.pluralsight.springboot.registration_service.registration.events;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface EventsClient {

    @GetExchange("/products/{id}")
    Product getProductById(@PathVariable("id") int productId);

    @GetExchange("/events/{id}")
    Event getEventById(@PathVariable("id") int eventId);
}
