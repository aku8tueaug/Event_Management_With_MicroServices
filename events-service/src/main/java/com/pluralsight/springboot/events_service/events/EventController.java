package com.pluralsight.springboot.events_service.events;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class EventController {
    private final EventRepository eventRepository;
    private final OrganiserRepository organiserRepository;
    private final ProductRepository productRepository;

    public EventController (EventRepository eventRepository,
                            OrganiserRepository organiserRepository,
                            ProductRepository productRepository)
    {
        this.eventRepository =eventRepository;
        this.organiserRepository = organiserRepository;
        this.productRepository = productRepository;
    }
    @GetMapping(path = "/organisers")
    public List<Organiser> getOrganisers()
    {
        return  organiserRepository.findAll();
    }
    @GetMapping(path = "/events")
    public List<Event> getEventsByOrganiser( @RequestParam("organiserId") int organiserId)
    {
        return eventRepository.findByOrganiserId(organiserId);
    }
    @GetMapping(path = "/events/{id}")
    public Event getEventById(@PathVariable("id") int id)
    {
        return eventRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("No Event with id" + id + "found."));
    }
    @GetMapping(path = "/products")
    public List<Product> getProductsByEvent(@RequestParam int eventId)
    {
        return productRepository.findByEventId(eventId);
    }
    @GetMapping(path = "/products/{id}")
    public Product getProductById(@PathVariable("id") int id)
    {
        return productRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("No Product found with id " + id + " ."));
    }
}
