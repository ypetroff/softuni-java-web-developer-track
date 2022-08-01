import java.util.Scanner;

public class PrintAndSum_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = start; i <= end; i++) {
            sum += i;
            if (i == end) {
                System.out.println(i);
            } else {
                System.out.print(i + " ");
            }

        }

        System.out.printf("Sum: %d", sum);
    }
}
