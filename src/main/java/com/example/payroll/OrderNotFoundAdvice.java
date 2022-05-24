package com.example.payroll;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class OrderNotFoundAdvice {


    //Pegamento que nos permite transformar una excepción en un codigo NOT FOUND (codigo de retorno)
    @ResponseBody
    @ExceptionHandler(OrderNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String OrderNotFoundHandler(OrderNotFoundException ex) {
        return ex.getMessage();
    }
}

