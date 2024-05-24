package org.example.part_four.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> globalHandler(Exception ex){
        return new ResponseEntity<>(STR."An error occurred: \{ex.getMessage()}", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
