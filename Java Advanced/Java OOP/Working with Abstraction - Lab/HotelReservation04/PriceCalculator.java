package HotelReservation04;

import java.text.DecimalFormat;
import java.util.Arrays;

public class PriceCalculator {

    private final double pricePerDay;
    private final int days;
    private final String season;
    private final String discount;

    public PriceCalculator(double pricePerDay, int days, String season, String discount) {
        this.pricePerDay = pricePerDay;
        this.days = days;
        this.season = season;
        this.discount = discount;
    }

    public double finalPrice() {

        double multiplier = checkSeason(season);
        double fullPrice = (pricePerDay * multiplier) * days;
        double currentDiscount = fullPrice * Arrays.stream(DiscountType.values())
                .filter(discountType -> discountType.getName().equals(discount)).findFirst().get().getDiscount();

        return  fullPrice - currentDiscount;
    }

    private double checkSeason(String season) {

        for (Seasons s : Seasons.values()) {
            if(s.getName().equals(season)) {
                return s.getMultiplier();
            }
        }
        throw new IllegalArgumentException("Enter: Spring, Summer, Autumn or Winter");
    }
}
