package bg.softuni.resellerapp.model.binding;

import bg.softuni.resellerapp.model.entity.Condition;
import bg.softuni.resellerapp.model.enums.ConditionEnum;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class OfferAddModel {

    @Size(min = 2, max = 50, message = "Description length must be between 2 and 50 characters!")
    @NotBlank
    private String description;

    @Positive(message = "The price must be a positive number!")
    private BigDecimal price;

    @NotNull
    private ConditionEnum condition;

    //TODO: add fields from Item; validate the input with annotations,
    // check if any field needs to be verified as unique -> possible custom annotation
}
