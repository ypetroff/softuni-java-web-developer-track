import java.util.Scanner;

public class SecretChat01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());

        String command;

        while (!"Reveal".equalsIgnoreCase(command = scanner.nextLine())) {
            String[] tokens = command.split(":\\|:");

            switch (tokens[0]) {
                case "InsertSpace":
                    message.insert(Integer.parseInt(tokens[1]), " ");
                    System.out.println(message);
                    break;
                case "Reverse":
                    if(message.toString().contains(tokens[1])) {
                        int startIndex = message.toString().indexOf(tokens[1]);
                        int endIndex = startIndex + tokens[1].length();
                        StringBuilder substring = new StringBuilder(message.substring(startIndex, endIndex)).reverse();
                        message.delete(startIndex, endIndex);
                        message.append(substring);
                        System.out.println(message);
                    }else {
                        System.out.println("error");
                    }

                    break;
                case "ChangeAll":
                    if(message.toString().contains(tokens[1])) {
                       String temp =  message.toString().replace(tokens[1], tokens[2]);
                       message.setLength(0);
                       message.append(temp);
                        System.out.println(message);
                    }
                    break;
            }
        }
        System.out.printf("You have a new text message: %s%n", message);
    }
}
