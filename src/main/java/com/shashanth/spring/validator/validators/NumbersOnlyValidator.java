package com.shashanth.spring.validator.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class NumbersOnlyValidator implements ConstraintValidator<NumbersOnly, String> {

    @Autowired
    private ValidatorProperties properties;

    @Override
    public void initialize(NumbersOnly constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        // if input is NULL, consider it as valid input
        // we should handle this in the logical level instead of letting annotation decide
        // if custom regex is defined while annotating a class member, consider it in the first priority
        // else fall back to the regex defined in the validator.properties file

        if (str == null || str.trim().isEmpty()) {
            return true;
        }

        // global regex
        if (properties.getNumericRegex() != null && !properties.getNumericRegex().isEmpty()) {
            return str.matches(properties.getNumericRegex());
        }

        return true;
    }
}
