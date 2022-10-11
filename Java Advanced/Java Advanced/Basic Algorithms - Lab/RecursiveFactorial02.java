import java.util.Scanner;

public class RecursiveFactorial02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        int factorial = findFactorial(num);
        System.out.println(factorial);
    }

    private static int findFactorial(int num) {
        if(num == 1) {
            return num;
        }
        return num * findFactorial(--num);
    }
}
