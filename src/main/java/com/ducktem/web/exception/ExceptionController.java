package com.ducktem.web.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

//    @ExceptionHandler(Exception.class)
    public String error(Exception e) {
        return "error";
    }
}
