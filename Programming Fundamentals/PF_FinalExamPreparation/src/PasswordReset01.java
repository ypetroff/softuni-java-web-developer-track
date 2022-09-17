import java.util.Scanner;

public class PasswordReset01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        String commands;
        while (!"Done".equalsIgnoreCase(commands = scanner.nextLine())) {
            String[] command = commands.split("\\s");

            switch (command[0]) {
                case "TakeOdd":
                    password = takeOdd(password);
                    System.out.println(password);
                    break;
                case "Cut":
                    password = cut(password, command[1], command[2]);
                    System.out.println(password);
                    break;
                case "Substitute":
                    password = substitute(password, command[1], command[2]);
                    break;
            }

        }
        System.out.printf("Your password is: %s", password);
    }


    private static String takeOdd(String password) {
        StringBuilder sb = new StringBuilder();
        char[] symbols = password.toCharArray();
        for (int i = 1; i < symbols.length; i += 2) {
            sb.append(symbols[i]);
        }
        return sb.toString();
    }

    private static String cut(String password, String i, String l) {
        int startIndex = Integer.parseInt(i);
        int endIndex = Integer.parseInt(l) + startIndex;
        return password.substring(0, startIndex) + password.substring(endIndex);
    }

    private static String substitute(String password, String substring, String substitute) {
        if (password.contains(substring)) {
            password = password.replace(substring, substitute);
            System.out.println(password);
        } else {
            System.out.println("Nothing to replace!");
        }
        return password;
    }
}
