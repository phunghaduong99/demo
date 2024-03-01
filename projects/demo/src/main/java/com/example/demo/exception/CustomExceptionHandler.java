package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {

    // handle not found exception
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerNotFoundException(NotFoundException ex, WebRequest req) {
        return new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    // validate
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBindException(BindException e, WebRequest req) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST,
                e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    // handle all undeclared exceptions
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handlerException(Exception ex, WebRequest req) {
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }
}
