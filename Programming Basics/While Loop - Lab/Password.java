import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String user = scanner.nextLine();
        String password = scanner.nextLine();
        String passwordTry = scanner.nextLine();
        while (!passwordTry.equals(password)) {
            passwordTry = scanner.nextLine();
        }
        System.out.printf("Welcome %s!", user);
    }
}
