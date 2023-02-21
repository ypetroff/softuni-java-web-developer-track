package bg.softuni.resellerapp.model.entity;

import bg.softuni.resellerapp.model.enums.ConditionEnum;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "conditions")
public class Condition extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private ConditionEnum conditionName;

    @Column(nullable = false)
    private String description;

    //TODO: Add other fields from the problem description
}
