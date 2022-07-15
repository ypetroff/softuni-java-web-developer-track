import java.util.Scanner;

public class YardGreening2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double squareMeters = Double.parseDouble(scanner.nextLine());
        double price = (squareMeters * 7.61) - (squareMeters * 7.61 * .18);
        double discount = squareMeters * 7.61 * .18;
        System.out.println("The final price is: " + price + " lv.");
        System.out.printf("The discount is: %s lv.", discount);



    }
}
