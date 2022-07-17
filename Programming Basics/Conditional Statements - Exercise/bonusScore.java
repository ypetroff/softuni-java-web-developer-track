import java.util.Scanner;

public class BonusScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double points = Double.parseDouble(scanner.nextLine());;
        if (points <= 100) {
            double bonusPoints = 5;
            if (points % 2 == 0) {
                System.out.printf("%.1f", bonusPoints + 1);
                System.out.println();
                System.out.printf("%.1f", points + bonusPoints + 1);
            } else if (points % 10 == 5 ) {
                System.out.printf("%.1f", bonusPoints +2);
                System.out.println();
                System.out.printf("%.1f",points + bonusPoints + 2);
            }else {
                System.out.println(bonusPoints);
                System.out.println(points + bonusPoints);
            }
        } else if (points < 1000) {
            double bonusPoints = points - .8 * points;
            if (points % 2 == 0) {
                System.out.printf("%.1f", bonusPoints + 1);
                System.out.println();
                System.out.printf("%.1f", points + bonusPoints + 1);
            } else if (points % 10 == 5) {
                System.out.printf("%.1f",bonusPoints + 2);
                System.out.println();
                System.out.printf("%.1f",points + bonusPoints + 2);
            } else {
                System.out.println(bonusPoints);
                System.out.println(points + bonusPoints);
            }
        } else {
            double bonusPoints = .1 * points;
            if (points % 2 == 0) {
                System.out.printf("%.1f",bonusPoints + 1);
                System.out.println();
                System.out.printf("%.1f",points + bonusPoints + 1);
            } else if (points % 10 == 5) {
                System.out.printf("%.1f",bonusPoints + 2);
                System.out.println();
                System.out.printf("%.1f",points + bonusPoints + 2);
            }else {
                System.out.println(bonusPoints);
                System.out.println(points + bonusPoints);
            }
        }
    }
}
