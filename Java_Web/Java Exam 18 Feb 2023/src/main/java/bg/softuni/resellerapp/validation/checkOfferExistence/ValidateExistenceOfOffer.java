package bg.softuni.resellerapp.validation.checkOfferExistence;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
@Constraint(validatedBy = OfferExistenceValidator.class)
public @interface ValidateExistenceOfOffer {

    String message() default "Ship already exists";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
