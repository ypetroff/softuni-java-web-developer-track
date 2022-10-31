package restaurant.entities.tables.interfaces;

public class Indoors extends BaseTable{

    private final static double CONSTANT_PRICE_PER_PERSON = 3.5;

    public Indoors(int number, int size) {
        super(number, size, CONSTANT_PRICE_PER_PERSON);
    }

    @Override
    public double bill() {
        return super.bill() + numberOfPeople() * CONSTANT_PRICE_PER_PERSON;
    }
}
