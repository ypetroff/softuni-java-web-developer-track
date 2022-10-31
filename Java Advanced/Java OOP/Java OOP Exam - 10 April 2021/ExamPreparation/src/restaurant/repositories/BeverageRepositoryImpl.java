package restaurant.repositories;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.repositories.interfaces.BeverageRepository;
import restaurant.repositories.interfaces.Repository;

import java.util.*;

public class BeverageRepositoryImpl implements Repository<Beverages>, BeverageRepository<Beverages> {
    List<Beverages> beveragesList;

    public BeverageRepositoryImpl() {
        beveragesList = new ArrayList<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        return beveragesList.stream()
                .filter(b -> b.getName().equals(drinkName) && b.getBrand().equals(drinkBrand))
                .findFirst().orElse(null);
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return Collections.unmodifiableCollection(beveragesList);
    }

    @Override
    public void add(Beverages beverage) {
        beveragesList.add(beverage);
    }
}
