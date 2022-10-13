package HotelReservation04;

public enum DiscountType {
    VIP("VIP", .2),
    SECOND_VISIT("SecondVisit", .1),
    NONE("None", 0);

    private final String name;
    private final double discount;

    DiscountType(String name, double discount) {
        this.name = name;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public double getDiscount() {
        return discount;
    }
}
