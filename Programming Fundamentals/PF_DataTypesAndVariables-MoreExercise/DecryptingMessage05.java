import java.util.Scanner;

public class DecryptingMessage05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int numberOfLines = Integer.parseInt(scanner.nextLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numberOfLines; i++) {
            char letter = scanner.nextLine().charAt(0);
            int decodedLetter = letter + key;
            sb.append((char)decodedLetter);
        }
        System.out.println(sb);
    }
}
