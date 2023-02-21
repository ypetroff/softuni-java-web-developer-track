package bg.softuni.resellerapp.validation.checkOfferExistence;

import bg.softuni.resellerapp.model.ConditionModel;
import bg.softuni.resellerapp.model.entity.Condition;
import bg.softuni.resellerapp.service.OfferService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class OfferExistenceValidator implements ConstraintValidator<ValidateExistenceOfOffer, Object> {

    private final OfferService offerService;

    public OfferExistenceValidator(OfferService offerService) {
        this.offerService = offerService;
    }

    @Override
    public void initialize(ValidateExistenceOfOffer constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {


        Map<String, Object> input = (Map<String, Object>) value;

        String description = (String) input.get("description");

        BigDecimal price = (BigDecimal) input.get("price");

        ConditionModel condition = (ConditionModel) input.get("condition");

        //TODO: complete validation logic
        return true;
    }
}
