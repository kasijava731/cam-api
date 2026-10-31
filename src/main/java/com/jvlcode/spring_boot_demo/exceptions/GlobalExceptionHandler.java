package com.jvlcode.spring_boot_demo.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice // 👈 This listens to all controllers in your app
public class GlobalExceptionHandler {

    // 👈 This tells Spring to run this method whenever ResourceNotFoundException is thrown
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex) {

        // Create a structured, easy-to-read error response body
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", "Not Found");
        body.put("message", ex.getMessage()); // Will display "User not found"

        // Return the JSON body along with a proper 404 HTTP status code
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }


//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<Object> nowhereSuchElementException(NoSuchElementException ex) {
//
//        // Create a structured, easy-to-read error response body
//        Map<String, Object> body = new HashMap<>();
//        body.put("timestamp", LocalDateTime.now());
//        body.put("status", HttpStatus.NOT_FOUND.value());
//        body.put("error", "Not Found");
//        body.put("message", ex.getMessage()); // Will display "User not found"
//
//        // Return the JSON body along with a proper 404 HTTP status code
//        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
//    }
}
