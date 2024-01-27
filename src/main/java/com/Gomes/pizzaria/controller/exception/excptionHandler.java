package com.Gomes.pizzaria.controller.exception;


import com.Gomes.pizzaria.exception.DisabledAccountException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class excptionHandler {

    @ExceptionHandler(DisabledAccountException.class)
    public ResponseEntity<StandardError> DisabledAccountException(DisabledAccountException ex, HttpServletRequest request) {
        StandardError error =
                new StandardError(LocalDateTime.now(), HttpStatus.NO_CONTENT.value(), ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
