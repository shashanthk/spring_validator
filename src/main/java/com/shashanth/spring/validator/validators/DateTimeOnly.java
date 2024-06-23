package com.shashanth.spring.validator.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateTimeOnlyValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateTimeOnly {

    @NotNull
    String message() default "Invalid date time";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
