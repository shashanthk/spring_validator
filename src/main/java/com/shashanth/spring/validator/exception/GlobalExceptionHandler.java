package com.shashanth.spring.validator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.StringJoiner;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> exceptionHandler(Throwable ex) {

        // catch format validation error messages and format it according to the requirement
        if (ex instanceof MethodArgumentNotValidException) {

            StringJoiner sj = new StringJoiner(", ");

            ((MethodArgumentNotValidException) ex).getBindingResult().getAllErrors().forEach(errorField -> {
                sj.add(((FieldError) errorField).getField() + " : " + errorField.getDefaultMessage());
            });

            return new ResponseEntity<>(sj.toString(), HttpStatus.BAD_REQUEST);
        }

        // log error message
        // handle it according to the requirements
        System.err.println(ex.getMessage());

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
