package com.bridgelabz.college_management.annotation;

import com.bridgelabz.college_management.validator.GenderValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = GenderValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidGender {

    String message() default "Gender must be Male, Female or Other";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}