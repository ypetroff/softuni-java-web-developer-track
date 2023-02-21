package bg.softuni.resellerapp.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OfferRenderModel {

    private Long id;

    private String description;

    private BigDecimal price;

    private ConditionModel condition;

    private String username;

}
