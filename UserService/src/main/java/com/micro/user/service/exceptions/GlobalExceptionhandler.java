package com.micro.user.service.exceptions;

import com.micro.user.service.payload.ApiResponse;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static ch.qos.logback.core.util.AggregationType.NOT_FOUND;

/**
 * Global exception handler for the application.
 * This class can be used to handle exceptions globally across all controllers.
 */
@RestControllerAdvice
public class GlobalExceptionhandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handlerResourceNotFoundException(ResourceNotFoundException ex){
            String message = ex.getMessage();
         return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
    }
}
