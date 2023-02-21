package bg.softuni.resellerapp.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

//@ValidateExistenceOfOffer //todo: complete validation
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OfferModel {

    private Long id;

    private String description;

    private BigDecimal price;

    private ConditionModel condition;

    private UserModel buyer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OfferModel that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getPrice(), that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription(), getPrice());
    }
}
