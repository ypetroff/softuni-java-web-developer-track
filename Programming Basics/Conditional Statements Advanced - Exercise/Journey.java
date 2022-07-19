import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String destination;
        String vacationType = null;
        if (budget <= 100) {
            destination = "Bulgaria";
            switch (season) {
                case "summer":
                    budget = budget * .3;
                    vacationType = "Camp";
                    break;
                case "winter":
                    budget = budget * .7;
                    vacationType = "Hotel";
                    break;
            }
        } else if (budget <= 1000) {
            destination = "Balkans";
            switch (season) {
                case "summer":
                    budget = budget * .4;
                    vacationType = "Camp";
                    break;
                case "winter":
                    budget = budget * .8;
                    vacationType = "Hotel";
                    break;
            }
        } else {
            destination = "Europe";
            budget = budget * .9;
            vacationType = "Hotel";
        }
        System.out.printf("Somewhere in %s", destination);
        System.out.println();
        System.out.printf("%s - %.2f", vacationType, budget);
        }
        
    }
