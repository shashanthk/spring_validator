package com.shashanth.spring.validator.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AlphaNumericOnlyValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AlphaNumericOnly {

    @NotNull
    String message() default "Only alphanumerics allowed";

    String regex() default ""; // optional regex pattern

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
