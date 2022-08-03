import java.util.Scanner;

public class CharToString_V2_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            char symbol = scanner.nextLine().charAt(0);
            output.append(symbol);
        }
        System.out.println(output);
    }
}
