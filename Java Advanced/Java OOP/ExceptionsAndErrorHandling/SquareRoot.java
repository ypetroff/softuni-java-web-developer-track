import java.text.DecimalFormat;
import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        try {

            double sqrt = Math.sqrt(Integer.parseInt(scanner.nextLine()));

            String output = Double.isNaN(sqrt)
                    ? exceptionMessage()
                    : decimalFormat.format(sqrt);

            System.out.println(output);

        }catch (NumberFormatException e) {

            System.out.println(exceptionMessage());

        } finally {
            System.out.println("Goodbye");
        }
    }

    private static String exceptionMessage() {
       return  "Invalid";
    }
}
