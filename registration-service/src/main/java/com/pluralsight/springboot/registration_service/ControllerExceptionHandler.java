package com.pluralsight.springboot.registration_service;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

// Advantage of this Advice class is, this class would be shared with all the controller classes.
@RestControllerAdvice
public class ControllerExceptionHandler {
    public ErrorResponse notFound(NoSuchElementException ex)
    {
        return ErrorResponse.create(ex, HttpStatus.NOT_FOUND,ex.getMessage());
    }
}
