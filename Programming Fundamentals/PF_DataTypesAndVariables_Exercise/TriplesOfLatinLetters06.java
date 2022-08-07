import java.util.Scanner;

public class TriplesOfLatinLetters06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rounds = Integer.parseInt(scanner.nextLine());

        for (int i = 97; i < rounds + 97; i++) {
            for (int j = 97; j < rounds + 97; j++) {

                for (int k = 97; k < rounds + 97; k++) {
                    System.out.printf("%c%c%c%n", (char)i, (char)j, (char)k);
                }
            }
        }
    }
}
