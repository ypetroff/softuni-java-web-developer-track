import java.util.Scanner;

public class SortNumbers_V2_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int medium = Integer.MIN_VALUE;

        int[] array = {n1, n2, n3};

        for (int currentNumber : array) {
            if (currentNumber > max) {
                max = currentNumber;
            }
            if (currentNumber < min) {
                min = currentNumber;
            }

            if (currentNumber == array[0] || (currentNumber <= max && currentNumber >= min)) {
                medium = currentNumber;
            }
        }
        System.out.println(max);
        System.out.println(medium);
        System.out.println(min);
    }
}
