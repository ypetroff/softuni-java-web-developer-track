import java.util.Scanner;

public class AsciiSumator02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char char1 = scanner.nextLine().charAt(0);
        char char2 = scanner.nextLine().charAt(0);
        char[] randomText = scanner.nextLine().toCharArray();

        int max = Math.max(char1, char2);
        int min = Math.min(char1, char2);

        int sum = 0;

        for (char c : randomText) {
            if (c > min && c < max) {
                sum += c;
            }
        }

        System.out.println(sum);


    }
}
