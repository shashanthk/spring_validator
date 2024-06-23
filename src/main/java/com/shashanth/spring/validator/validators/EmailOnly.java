package com.shashanth.spring.validator.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailOnlyValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailOnly {

    @NotNull
    String message() default "Invalid email";

    String regex() default ""; // optional regex pattern

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
