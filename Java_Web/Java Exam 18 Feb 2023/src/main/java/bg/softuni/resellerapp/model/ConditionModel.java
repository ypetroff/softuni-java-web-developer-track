package bg.softuni.resellerapp.model;

import bg.softuni.resellerapp.model.enums.ConditionEnum;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConditionModel {

    private Long id;

    private ConditionEnum conditionName;

    private String description;
}
