package HotelReservation04;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] vacation = scanner.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(vacation[0]);
        int numberOfDays = Integer.parseInt(vacation[1]);
        String season = vacation[2];
        String discountType = vacation[3];

        PriceCalculator amountToPay = new PriceCalculator(pricePerDay, numberOfDays, season, discountType);

        System.out.printf("%.2f", amountToPay.finalPrice());
    }
}
