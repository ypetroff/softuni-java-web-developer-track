import java.util.Locale;
import java.util.Scanner;

public class PasswordValidator01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder password = new StringBuilder(scanner.nextLine());

        String commands;

        while (!"Complete".equals(commands = scanner.nextLine())) {
            String[] tokens = commands.split("\\s");

            switch (tokens[0]) {
                case "Make":
                    int index = Integer.parseInt(tokens[2]);
                    if (index < 0 || index >= password.length()) {
                        continue;
                    }
                    String start = password.substring(0, index);
                    String temp;
                    if (tokens[1].equals("Upper")) {
                        temp = password.substring(index, index + 1).toUpperCase(Locale.ROOT);
                    } else {
                        temp = password.substring(index, index + 1).toLowerCase(Locale.ROOT);
                    }
                    String end = password.substring(index + 1);
                    password.setLength(0);
                    password.append(start);
                    password.append(temp);
                    password.append(end);
                    System.out.println(password);
                    break;
                case "Insert":
                    index = Integer.parseInt(tokens[1]);
                    if (index < 0 || index >= password.length()) {
                        continue;
                    }

                    start = password.substring(0, index);
                    end = password.substring(index);
                    password.setLength(0);
                    password.append(start);
                    password.append(tokens[2]);
                    password.append(end);
                    System.out.println(password);
                    break;
                case "Replace":
                    if (!password.toString().contains(tokens[1])) {
                        continue;
                    }
                    int valueAsDigits = tokens[1].charAt(0);
                    int sum = valueAsDigits + Integer.parseInt(tokens[2]);
                    temp = password.toString().replace(tokens[1], String.valueOf((char) sum));
                    password.setLength(0);
                    password.append(temp);
                    System.out.println(password);
                    break;
                case "Validation":
                    if(password.length() < 8) {
                        System.out.println("Password must be at least 8 characters long!");
                    }

                    char[] symbols = password.toString().toCharArray();
                    for (char symbol : symbols) {
                        if(!Character.isLetterOrDigit(symbol) && symbol != '_') {
                            System.out.println("Password must consist only of letters, digits and _!");
                            break;
                        }
                    }

                    boolean isValid = false;
                    for (char symbol : symbols) {
                        if(Character.isUpperCase(symbol)) {
                            isValid = true;
                        }
                    }

                    if(!isValid) {
                        System.out.println("Password must consist at least one uppercase letter!");
                    }

                    isValid = false;
                    for (char symbol : symbols) {
                        if(Character.isLowerCase(symbol)) {
                            isValid = true;
                        }
                    }

                    if(!isValid) {
                        System.out.println("Password must consist at least one lowercase letter!");
                    }

                    isValid = false;
                    for (char symbol : symbols) {
                        if(Character.isDigit(symbol)) {
                            isValid = true;
                        }
                    }

                    if(!isValid) {
                        System.out.println("Password must consist at least one digit!");
                    }
                    break;
            }
        }
    }
}
