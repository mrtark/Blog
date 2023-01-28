package com.mrtark.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {RegisterUniqueEmailValidation.class})

public @interface RegisterUniqueEmail {
    String message() default "{register.email.validation.constraints.unique.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
