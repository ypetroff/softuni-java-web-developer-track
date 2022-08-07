import java.util.Scanner;

public class SpiceMustFlow09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int currentYield = Integer.parseInt(scanner.nextLine());

        int days = 0, totalYield = 0;

        while (currentYield >= 100) {
            days++;
            totalYield += currentYield - 26;
            currentYield -= 10;
        }

        totalYield-= Math.min(26, totalYield);

        System.out.println(days);
        System.out.println(totalYield);
    }
}
