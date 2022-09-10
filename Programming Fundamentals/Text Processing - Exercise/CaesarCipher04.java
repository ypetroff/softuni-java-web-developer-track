import java.util.Scanner;

public class CaesarCipher04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] text = scanner.nextLine().toCharArray();
        StringBuilder encryptedText = new StringBuilder();

        for (char c : text) {
            encryptedText.append((char)(c + 3));
        }

        System.out.println(encryptedText);
    }
}
