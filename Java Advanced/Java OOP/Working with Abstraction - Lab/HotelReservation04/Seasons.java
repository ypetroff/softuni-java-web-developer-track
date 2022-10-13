package HotelReservation04;

public enum Seasons {
    AUTUMN("Autumn",1),
    SPRING("Spring", 2),
    WINTER("Winter", 3),
    SUMMER("Summer", 4);

    private final int multiplier;
    private final String name;

    Seasons(String name, int multiplier) {
        this.name = name;
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public String getName() {
        return name;
    }
}
