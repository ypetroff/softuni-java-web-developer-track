import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fishermen = Integer.parseInt(scanner.nextLine());
        double rent = 0;
        switch (season) {
            case "Spring":
                rent = 3000;
                if (fishermen <= 6) {
                    rent = rent - rent * .1;
                }else if (fishermen <= 11) {
                    rent = rent -  rent * .15;
                } else {
                    rent = rent - rent * .25;
                }
                break;
            case "Summer":
            case "Autumn":
                rent = 4200;
                if (fishermen <= 6) {
                    rent = rent - rent * .1;
                }else if (fishermen <= 11) {
                    rent = rent -  rent * .15;
                } else {
                    rent = rent - rent * .25;
                }
                break;
            case "Winter":
                rent = 2600;
                if (fishermen <= 6) {
                    rent = rent - rent * .1;
                }else if (fishermen <= 11) {
                    rent = rent -  rent * .15;
                } else {
                    rent = rent - rent * .25;
                }
                break;
        }
        if (fishermen % 2 == 0 && !"Autumn".equals(season)) {
            rent = rent - rent * .05;
        }
        if (budget >= rent) {
            System.out.printf("Yes! You have %.2f leva left.", budget - rent);
        }else {
            System.out.printf("Not enough money! You need %.2f leva.", rent - budget);
        }
    }
}
