import java.util.Scanner;

public class SumofOddNumbers_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 1; i <= number; i++) {

            int n = i * 2 - 1;
            System.out.println(n);
            sum += n;
        }
        System.out.println("Sum: " + sum);
    }
}
