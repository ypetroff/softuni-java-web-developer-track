import java.util.Scanner;

public class Login05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password;
        password = new StringBuilder(username).reverse().toString();
        int counter = 0;

        String passwordInput = scanner.nextLine();

        while (!passwordInput.equals(password)) {

            counter++;
            if (counter == 4) {
                System.out.printf("User %s blocked!", username);
                break;
            }
            System.out.println("Incorrect password. Try again.");
            passwordInput = scanner.nextLine();

        }
        if (passwordInput.equals(password)) {
            System.out.printf("User %s logged in.", username);
        }
    }
}
