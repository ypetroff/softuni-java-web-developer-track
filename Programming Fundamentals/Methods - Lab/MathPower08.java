import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        double number = Double.parseDouble(scanner.nextLine());
        int toThePower = Integer.parseInt(scanner.nextLine());

        double result = poweredNumber(number, toThePower);
        System.out.println(new DecimalFormat("0.####").format(result));
    }

    private static double poweredNumber(double number, int toThePower) {
        double result;
        result = Math.pow(number, toThePower);
        return result;
    }
}
