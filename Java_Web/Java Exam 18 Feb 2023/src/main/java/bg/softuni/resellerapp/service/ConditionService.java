package bg.softuni.resellerapp.service;

import bg.softuni.resellerapp.model.ConditionModel;
import bg.softuni.resellerapp.model.entity.Condition;
import bg.softuni.resellerapp.model.enums.ConditionEnum;
import bg.softuni.resellerapp.repository.ConditionRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ConditionService {

    private final ConditionRepository conditionRepository;
    private final ModelMapper modelMapper;

    public ConditionService(ConditionRepository conditionRepository, ModelMapper modelMapper) {
        this.conditionRepository = conditionRepository;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void initDB() {

        if(this.conditionRepository.count() == 0) {

            this.conditionRepository.saveAllAndFlush(
                    Arrays.stream(ConditionEnum.values())
                            .map(value -> ConditionModel.builder()
                                    .conditionName(value)
                                    .description(value.getDisplayName())
                                    .build())
                            .map(enumModel -> this.modelMapper.map(enumModel, Condition.class))
                            .toList());

        }
    }

    public ConditionModel findByName(ConditionEnum condition) {
        return this.modelMapper.map(
                this.conditionRepository.findByConditionName(condition)
                        .orElse(new Condition()),
                ConditionModel.class
        );
    }
}
