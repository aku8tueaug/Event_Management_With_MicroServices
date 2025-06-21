package com.pluralsight.springboot.registration_service.registration;



import com.pluralsight.springboot.registration_service.registration.events.Event;
import com.pluralsight.springboot.registration_service.registration.events.EventsClient;
import com.pluralsight.springboot.registration_service.registration.events.Product;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.UUID;

// Jakarta EE bean we can use for data validation fro APIs.
import jakarta.validation.Valid;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping(path = "/registrations")
public class RegistrationController {
    private final RegistrationRepository registrationRepository;
//    private final WebClient webClient;   instead of this using HTTP client Interface
    private final EventsClient eventsClient;
    public RegistrationController(RegistrationRepository registrationRepository, EventsClient eventsClient)
    {
        this.registrationRepository = registrationRepository;
        this.eventsClient = eventsClient;
    }
    @PostMapping
    public Registration create(@RequestBody @Valid Registration registration)
    {
//        All this Boilerplate code is not required for HTTP Interface client, it was required for
//        webClient.
//        Product product = webClient.get()
//                .uri("/products/{id}",registration.productId())
//                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .retrieve()
//                .bodyToMono(Product.class)
//                .block();
//        Event event = webClient.get()
//                .uri("/events/{id}",product.event().id())
//                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .retrieve()
//                .bodyToMono(Event.class)
//                .block();



//*************Http Interface Client Code***************************

        Product product = eventsClient.getProductById(registration.productId());
        Event event = eventsClient.getEventById(product.event().id());
        String ticketCode = UUID.randomUUID().toString();
        return registrationRepository.save( new Registration
                (null, registration.productId(), ticketCode, registration.attendeeName(),event.name(),product.price()));

    }

    @GetMapping(path = "/{ticketCode}")
    public Registration get(@PathVariable("ticketCode") String ticketCode){
        return registrationRepository.findByTicketCode(ticketCode)
                .orElseThrow(()->new NoSuchElementException("Registration with ticket " + ticketCode + " not found." ));
    }
    @PutMapping
    public Registration update(@RequestBody Registration registration)
    {
        Product product = null;
        Event event =null;
        String ticketCode = registration.ticketCode();;
        var existing = registrationRepository.findByTicketCode(ticketCode)
                .orElseThrow(()->new NoSuchElementException("Registration with ticket " + ticketCode + " not found."));
        return registrationRepository.save(new Registration(existing.id(), existing.productId(), ticketCode, registration.attendeeName(),event.name(),product.price()));
    }
    @DeleteMapping(path="/{ticketCode}")
    public void delete(@PathVariable("ticketCode") String ticketCode)
    {
        registrationRepository.deleteByTicketCode(ticketCode);
    }
}
