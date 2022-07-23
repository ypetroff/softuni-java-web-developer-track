import java.util.Scanner;

public class SequenceTwoKPlusOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        int i = 1;

        while (i <= input) {
            System.out.println(i);
            i = i * 2 + 1;
        }
    }
}
