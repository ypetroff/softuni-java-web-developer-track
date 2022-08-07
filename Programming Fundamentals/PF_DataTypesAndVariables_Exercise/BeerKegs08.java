import java.util.Scanner;

public class BeerKegs08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfKegs = Integer.parseInt(scanner.nextLine());
        double maxVolume = 0;
        String nameWinner = "";

        for (int i = 0; i < numberOfKegs; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double kegVolume = Math.PI * Math.pow(radius, 2) * height;

            if (kegVolume > maxVolume) {
                maxVolume = kegVolume;
                nameWinner = model;
            }
        }
        System.out.println(nameWinner);
    }
}
