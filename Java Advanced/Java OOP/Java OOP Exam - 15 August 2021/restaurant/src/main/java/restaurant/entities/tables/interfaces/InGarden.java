package restaurant.entities.tables.interfaces;

public class InGarden extends BaseTable{

    private final static double CONSTANT_PRICE_PER_PERSON = 4.5;

    public InGarden(int number, int size) {
        super(number, size, CONSTANT_PRICE_PER_PERSON);
    }

    @Override
    public double bill() {
        return super.bill() + numberOfPeople() * CONSTANT_PRICE_PER_PERSON;
    }
}
