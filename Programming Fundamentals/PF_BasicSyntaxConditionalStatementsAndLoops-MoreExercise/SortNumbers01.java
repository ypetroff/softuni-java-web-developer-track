import java.util.Scanner;

public class SortNumbers01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());

        int max = Math.max(n1, Math.max(n2, n3));
        int min = Math.min(n1, Math.min(n2, n3));
        int middle = n1 + n2 + n3 - max - min;

        System.out.println(max);
        System.out.println(middle);
        System.out.println(min);
    }
}
