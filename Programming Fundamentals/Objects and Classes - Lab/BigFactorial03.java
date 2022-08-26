import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());

        BigInteger factorial = new BigInteger("1");


        for (int i = 2; i <= input; i++) {

           factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        System.out.println(factorial);
    }
}
