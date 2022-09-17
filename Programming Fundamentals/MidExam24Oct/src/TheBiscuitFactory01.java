import java.util.Scanner;

public class TheBiscuitFactory01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int biscuitsPerWorker = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());
        int competition = Integer.parseInt(scanner.nextLine());


        double producedBiscuits = 0;

        for (int i = 1; i <= 30; i++) {
            double biscuitsPerDay = biscuitsPerWorker * workers;
            if(i % 3 == 0) {
                biscuitsPerDay *= .75;
               biscuitsPerDay =  Math.floor(biscuitsPerDay);
            }

            producedBiscuits += biscuitsPerDay;

        }

        System.out.printf("You have produced %.0f biscuits for the past month.\n", producedBiscuits);

        if (producedBiscuits > competition) {
            double percentage = ((producedBiscuits - competition) / competition) * 100;
            System.out.printf("You produce %.2f percent more biscuits.", percentage);
        }else {
            double percentage = ((competition - producedBiscuits) / competition) * 100;
            System.out.printf("You produce %.2f percent less biscuits.", percentage);
        }
    }
}
