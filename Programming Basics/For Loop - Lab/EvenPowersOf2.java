import java.util.Scanner;

public class EvenPowersOf2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        /*if (input % 2 != 0) {
            input --;
        } */
       // System.out.println("1");
        for (int i = 1; i <= input; i++) {
            if ( i == 1) {
                System.out.println(i);
            }
            if (i % 2 == 0) {
                System.out.printf("%.0f", Math.pow(2, i));
                System.out.println();
            }
        }
    }
}
