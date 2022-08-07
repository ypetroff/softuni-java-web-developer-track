import java.util.Scanner;

public class PokeMon10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int power = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());
        int touchedTargets = 0;
        int currentPower = power;

        while (distance <= currentPower) {
            currentPower -= distance;
            touchedTargets++;
            if (currentPower ==0) {
                break;
            }
            if (power % currentPower == 0 && power / currentPower == 2 && exhaustionFactor != 0) {
                if (currentPower / exhaustionFactor > 0) {
                    currentPower /= exhaustionFactor;
                }
            }

        }

        System.out.println(currentPower);
        System.out.println(touchedTargets);
    }
}
