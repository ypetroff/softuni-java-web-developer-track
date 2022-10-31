package restaurant.core;

import restaurant.common.ExceptionMessages;
import restaurant.common.OutputMessages;
import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.Fresh;
import restaurant.entities.drinks.Smoothie;
import restaurant.entities.healthyFoods.Salad;
import restaurant.entities.healthyFoods.VeganBiscuits;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.tables.interfaces.InGarden;
import restaurant.entities.tables.interfaces.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.*;

public class ControllerImpl implements Controller {

    private final HealthFoodRepository<HealthyFood> healthFoodRepository;
    private final BeverageRepository<Beverages> beverageRepository;
    private final TableRepository<Table> tableRepository;
    double totalBills;


    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {

        this.healthFoodRepository = healthFoodRepository;
        this.beverageRepository = beverageRepository;
        this.tableRepository = tableRepository;
        totalBills = 0;
    }


    @Override
    public String addHealthyFood(String type, double price, String name) {

        HealthyFood food = type.equals("Salad")
                ? new Salad(name, price)
                : new VeganBiscuits(name, price);


        if (healthFoodRepository.foodByName(name) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_EXIST, name));
        }
        healthFoodRepository.add(food);
        return String.format(OutputMessages.FOOD_ADDED, name);
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {
        Beverages beverage = type.equals("Fresh")
                ? new Fresh(name, counter, brand)
                : new Smoothie(name, counter, brand);


        if (beverageRepository.beverageByName(name, brand) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.BEVERAGE_EXIST, name));
        }
        beverageRepository.add(beverage);
        return String.format(OutputMessages.BEVERAGE_ADDED, type, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = type.equals("Indoors")
                ? new Indoors(tableNumber, capacity)
                : new InGarden(tableNumber, capacity);

        if(tableRepository.byNumber(tableNumber) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.TABLE_IS_ALREADY_ADDED, tableNumber));
        }
        tableRepository.add(table);
        return String.format(OutputMessages.TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserve(int numberOfPeople) {
        Table suitableTable = tableRepository.getAllEntities().stream()
                .filter(t -> !t.isReservedTable() && t.getSize() > numberOfPeople)
                .findFirst().orElse(null);

        if(suitableTable == null) { // or just return String ?
            throw new NullPointerException(String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople));
        }
        suitableTable.reserve(numberOfPeople);
        return String.format(OutputMessages.TABLE_RESERVED, suitableTable.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
       if(tableRepository.byNumber(tableNumber) == null) {
           throw new NullPointerException(String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber));
       }

       if(healthFoodRepository.foodByName(healthyFoodName) == null) {
           throw new NullPointerException(String.format(OutputMessages.NONE_EXISTENT_FOOD, healthyFoodName));
       }

        return String.format(OutputMessages.FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        if(tableRepository.byNumber(tableNumber) == null) {
            throw new NullPointerException(String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber));
        }

        if(beverageRepository.beverageByName(name, brand) == null) {
            throw new NullPointerException(String.format(OutputMessages.NON_EXISTENT_DRINK, name, brand));
        }
        return String.format(OutputMessages.BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
    }

    @Override
    public String closedBill(int tableNumber) {
        Table table = tableRepository.byNumber(tableNumber);
        double bill = table.bill();
        totalBills+=bill;
        table.clear();
        return String.format(OutputMessages.BILL, tableNumber, bill);
    }


    @Override
    public String totalMoney() {
        return String.format(OutputMessages.TOTAL_MONEY, totalBills);
    }
}
