import java.util.Scanner;

public class SummerOutfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int degrees = Integer.parseInt(scanner.nextLine());
        String timeOfTheDay = scanner.nextLine();
        String clothes = null;
        String shoes = null;
        switch (timeOfTheDay) {
            case "Morning":
                if (degrees >= 10 && degrees <= 18) {
                    clothes = "Sweatshirt";
                    shoes = "Sneakers";
                }else if (degrees > 18 && degrees <= 24) {
                    clothes = "Shirt";
                    shoes = "Moccasins";
                }else /*if (degrees >= 25)*/ {
                    clothes = "T-Shirt";
                    shoes = "Sandals";
                }
                break;
            case "Afternoon":
                if (degrees >= 10 && degrees <= 18) {
                    clothes = "Shirt";
                    shoes = "Moccasins";
                }else if (degrees > 18 && degrees <= 24) {
                    clothes = "T-Shirt";
                    shoes = "Sandals";
                }else /*if (degrees >= 25) */ {
                    clothes = "Swim Suit";
                    shoes = "Barefoot";
                }
                break;
            case "Evening":
                if (degrees >=10) {
                    clothes = "Shirt";
                    shoes = "Moccasins";
                }
                break;
        }
        System.out.printf("It's %d degrees, get your %s and %s.", degrees, clothes, shoes);
   }
}
