import java.util.Scanner;

public class PadawanEquipment09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceLightsaber = Double.parseDouble(scanner.nextLine());
        double priceRobe = Double.parseDouble(scanner.nextLine());
        double priceBelt = Double.parseDouble(scanner.nextLine());

        double moneyForLightsabers = Math.ceil(students + students * .1) * priceLightsaber;
        double moneyForRobes = students * priceRobe;

        if (students >= 6) {
            int freeBelts = students / 6;
            students -= freeBelts;
        }

        double moneyForBelts = students * priceBelt;

        double totalSpent = moneyForLightsabers + moneyForRobes + moneyForBelts;

        if (budget >= totalSpent) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalSpent);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", totalSpent - budget);
        }
    }
}
