import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double p1 = 0;
        double p2 = 0;
        double p3 = 0;
        double p4 = 0;
        double p5 = 0;
        for (int i = 1; i <= n; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            if (currentNumber >= 800 && currentNumber <= 1000) {
                p5++;
            }else if ( currentNumber <= 799 && currentNumber >= 600) {
                p4++;
            } else if ( currentNumber >= 400 && currentNumber <= 599) {
                p3++;
            } else if (currentNumber >= 200 && currentNumber <= 399) {
                p2++;
            } else if (currentNumber < 200 && currentNumber >= 1) {
                p1++;
            } else {
                System.out.println("Error, enter a valid number.");
                break;
            }
        }
        double p1Percentage = p1 / n * 100;
        double p2Percentage = p2 / n * 100;
        double p3Percentage = p3 / n * 100;
        double p4Percentage = p4 / n * 100;
        double p5Percentage = p5 / n * 100;
       /* System.out.printf("%.2f%%", p1Percentage); //System.out.printf("%.2f%%%n", p1Percentage);
        System.out.println(); /// %n - нов ред
        System.out.printf("%.2f%%", p2Percentage);
        System.out.println();
        System.out.printf("%.2f%%", p3Percentage);
        System.out.println();
        System.out.printf("%.2f%%", p4Percentage);
        System.out.println();
        System.out.printf("%.2f%%", p5Percentage);
        System.out.println(); */
        System.out.printf("%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%%n", p1Percentage, p2Percentage, p3Percentage, p4Percentage, p5Percentage);
    }
}
