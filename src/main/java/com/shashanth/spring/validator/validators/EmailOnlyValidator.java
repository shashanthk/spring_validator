package com.shashanth.spring.validator.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailOnlyValidator implements ConstraintValidator<EmailOnly, String> {

    @Autowired
    private ValidatorProperties properties;

    private String customRegex;

    @Override
    public void initialize(EmailOnly constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.customRegex = constraintAnnotation.regex();
    }

    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        // if input is NULL, consider it as valid input
        // we should handle this in the logical level instead of letting an annotation decide
        // if custom regex is defined while annotating a class member, consider it in the first priority
        // else fall back to the regex defined in the validator.properties file

        if (str == null || str.trim().isEmpty()) {
            return true;
        }

        // custom regex
        if (customRegex != null && !customRegex.isEmpty()) {
            return str.matches(customRegex);
        }

        // global regex
        if (properties.getEmailRegex() != null && !properties.getEmailRegex().isEmpty()) {
            return str.matches(properties.getEmailRegex());
        }

        return true;
    }
}
