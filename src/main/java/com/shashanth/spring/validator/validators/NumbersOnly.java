package com.shashanth.spring.validator.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NumbersOnlyValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NumbersOnly {

    @NotNull
    String message() default "Only numbers allowed";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
