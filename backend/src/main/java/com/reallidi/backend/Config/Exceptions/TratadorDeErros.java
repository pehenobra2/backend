package com.reallidi.backend.Config.Exceptions;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> tratarErro404(EntityNotFoundException ex){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
