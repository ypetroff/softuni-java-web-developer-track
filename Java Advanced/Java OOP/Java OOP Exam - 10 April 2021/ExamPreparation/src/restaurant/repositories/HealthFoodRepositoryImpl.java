package restaurant.repositories;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.repositories.interfaces.HealthFoodRepository;
import restaurant.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HealthFoodRepositoryImpl implements Repository<HealthyFood>, HealthFoodRepository<HealthyFood> {
    List<HealthyFood> healthyFoodList;

    public HealthFoodRepositoryImpl() {
        this.healthyFoodList = new ArrayList<>();
    }

    @Override
    public HealthyFood foodByName(String name) {
        return this.healthyFoodList.stream()
                .filter(f -> f.getName().equals(name))
                .findFirst().orElse(null);
    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return Collections.unmodifiableCollection(this.healthyFoodList);
    }

    @Override
    public void add(HealthyFood food) {
this.healthyFoodList.add(food);
    }
}
