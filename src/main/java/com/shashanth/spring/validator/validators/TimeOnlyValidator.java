package com.shashanth.spring.validator.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class TimeOnlyValidator implements ConstraintValidator<TimeOnly, String> {

    // database format
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public void initialize(TimeOnly constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {

        if (str == null) {
            return true; // null values are valid
        }

        try {
            // assuming that the input will be always in the database time format
            LocalTime.parse(str, TIME_FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
