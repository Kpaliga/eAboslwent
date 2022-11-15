package com.example.graduate.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {DictionaryKeyValidator.class}
)
public @interface DictionaryKey {
    String value() default "";
    String dictionary() default "";
    String message() default "Invalid key for Dictionary ${utl}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
