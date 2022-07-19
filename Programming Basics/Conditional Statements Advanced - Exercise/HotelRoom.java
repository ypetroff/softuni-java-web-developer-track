import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String month = scanner.nextLine();
        int nights = Integer.parseInt(scanner.nextLine());
        double apartment = 0;
        double studio = 0;
        switch (month) {
            case "May":
            case "October":
                apartment = 65 * nights;
                studio = 50 * nights;
                if (nights > 7 && nights <= 14) {
                    //apartment = apartment - apartment * .05;
                    studio = studio - studio * .05;
                } else if (nights > 14) {
                    // apartment = apartment - apartment * .3;
                    studio = studio - studio * .3;
                }
                break;
            case "June":
            case "September":
                apartment = 68.7 * nights;
                studio = 75.2 * nights;
                if (nights > 14) {
                    studio = studio - studio * .2;
                }
                break;
            case "July":
            case "August":
                apartment = 77 * nights;
                studio = 76 * nights;
                break;
        }
        if (nights > 14) {
            apartment = apartment - apartment * .1;
        }
        System.out.printf("Apartment: %.2f lv.", apartment);
        System.out.println();
        System.out.printf("Studio: %.2f lv.", studio);
    }
}
