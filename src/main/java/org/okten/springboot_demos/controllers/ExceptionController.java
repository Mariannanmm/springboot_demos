package org.okten.springboot_demos.controllers;

import org.okten.springboot_demos.dto.CustomerSizeExceptionDTO;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CustomerSizeExceptionDTO sizeException(MethodArgumentNotValidException ex) {

        return new CustomerSizeExceptionDTO(400, ex.getFieldError().getField(), ex.getFieldError().getDefaultMessage());

    }
}
