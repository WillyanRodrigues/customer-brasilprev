package br.com.petz.customer.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.petz.customer.validator.GetCustomerRequestValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Constraint(validatedBy = GetCustomerRequestValidator.class)
public @interface CombinedNotNull {
    String message() default "customerId or documentNumber is required";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] fields() default {};
}