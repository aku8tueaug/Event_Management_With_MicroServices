package com.pluralsight.springboot.registration_service.registration;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationRepository extends MongoRepository<Registration,String> {
//    for create update or find all the method and its implementation would be provided by MongoDBRepository
//    Implemetation for below method would also be provided by repo.
    Optional<Registration> findByTicketCode(String ticketCode);
    void deleteByTicketCode(String ticketCode);

//***********Commenting all the below code **********************
//This create update and all other repository method would be provided by MongoRepository
//    converting this class to interface
//
//    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();
//    private final Map<String ,Registration> registrationByTicketCode = new ConcurrentHashMap<>();
//
//    public Registration create(Registration registration)
//    {
//        int id =  ID_GENERATOR.incrementAndGet();
//        String ticketCode = UUID.randomUUID().toString();
//        var saved = new Registration(id, registration.productId(), ticketCode, registration.attendeeName());
//        registrationByTicketCode.put(ticketCode,saved);
//        return saved;
//    }
//    public Optional<Registration> findByTicketCode(String ticketCode)
//    {
//        return Optional.ofNullable(registrationByTicketCode.get(ticketCode));
//    }
//    public Registration update(Registration registration)
//    {
//        String ticketCode = registration.ticketCode();
//
//        var opt = findByTicketCode(ticketCode);
//        if(opt.isPresent())
//        {
//            var existing = opt.get();
//            var saved = new Registration(existing.id(), existing.productId(), existing.ticketCode(), registration.attendeeName());
//            registrationByTicketCode.put(ticketCode,saved);
//            return saved;
//        }
//        else
//            throw new NoSuchElementException("Registration with ticket code "+ registration.ticketCode() + " not found");
//
//    }
//    public void deleteByTicketCode(String ticketCode) {
//        registrationByTicketCode.remove(ticketCode);
//    }
//************************Exception Handeler **************************************
//    // if there is an exception occurs at server side, we can handel it using the @ExeceptionHandeler Annotation.
//    @ExceptionHandler(NoSuchElementException.class)
//    public ErrorResponse notFound(NoSuchElementException ex)
//    {
//        return ErrorResponse.create(ex, HttpStatus.NOT_FOUND,ex.getMessage());
//    }
//    this type of exception handeling handel exception for only this class.
//    To avaoid of duplicate code exceptionHandeling, we can use a classs anotate with @RestControllerAdvice
}
