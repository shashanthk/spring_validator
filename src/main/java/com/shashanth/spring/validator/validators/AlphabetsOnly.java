package com.shashanth.spring.validator.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AlphabetsOnlyValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AlphabetsOnly {

    @NotNull
    String message() default "Only alphabets allowed";

    String regex() default ""; // optional regex pattern

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
