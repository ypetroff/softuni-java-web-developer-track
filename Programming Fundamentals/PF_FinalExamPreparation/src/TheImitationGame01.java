import java.util.Scanner;

public class TheImitationGame01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());

        String command;
        while(!"Decode".equalsIgnoreCase(command = scanner.nextLine())) {
            String[] tokens = command.split("\\|");

            switch (tokens[0]) {
                case "Move":
                    moveToTheBack(message,tokens[1]);
                    break;
                case "Insert":
                    insertLetter(message,tokens);
                    break;
                case "ChangeAll":
                    changeAll(message, tokens);
                    break;
            }
        }
        System.out.printf("The decrypted message is: %s", message);
    }

    private static void moveToTheBack(StringBuilder message, String token) {
        int numberOfLetters = Integer.parseInt(token);
        String substring = message.substring(0, numberOfLetters);
        message.delete(0, numberOfLetters);
        message.append(substring);
    }

    private static void insertLetter(StringBuilder message, String[] tokens) {
        int index = Integer.parseInt(tokens[1]);
        String value = tokens[2];

        message.insert(index, value);
    }

    private static void changeAll(StringBuilder message, String[] tokens) {
        String substring = tokens[1];
        String replacement = tokens[2];

        String result = message.toString().replace(substring, replacement);
        message.setLength(0);
        message.append(result);
    }
}
