package com.shashanth.spring.validator.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateOnlyValidator implements ConstraintValidator<DateOnly, String> {

    // database format
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public void initialize(DateOnly constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {

        if (str == null) {
            return true; // null values are valid
        }

        try {
            // assuming that the input will be always in the database date format
            LocalDate.parse(str, DATE_FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
