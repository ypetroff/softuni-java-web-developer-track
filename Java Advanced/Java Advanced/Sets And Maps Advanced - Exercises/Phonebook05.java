import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();

        String command;
        while (!"search".equalsIgnoreCase(command = scanner.nextLine())) {
            String[] input = command.split("-");
            String name = input[0];
            String number = input[1];

            phonebook.put(name, number);
        }

        while (!"stop".equalsIgnoreCase(command = scanner.nextLine())) {
            String temp = command;
            if(phonebook.containsKey(command)) {
                phonebook.entrySet().stream()
                        .filter(name -> name.getKey().equals(temp))
                        .forEach(e -> System.out.printf("%s -> %s%n", e.getKey(), e.getValue()));
            }else {
                System.out.printf("Contact %s does not exist.%n", temp);
            }
        }
    }
}
