import java.util.Scanner;

public class RefactorSumofOddNumbers_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 1; i <= number ; i++) {
            System.out.println(2 * i - 1);
            sum+= 2 * i - 1;
        }
        System.out.printf("Sum: %d%n", sum);
    }
}
