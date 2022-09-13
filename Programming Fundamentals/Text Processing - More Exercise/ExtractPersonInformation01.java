import java.util.Scanner;

public class ExtractPersonInformation01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            int startIndexName = input.indexOf("@") + 1;
            int endIndexName = input.indexOf("|");
            int startIndexAge = input.indexOf("#") + 1;
            int endIndexAge = input.indexOf("*");

            System.out.printf("%s is %s years old.%n", input.substring(startIndexName, endIndexName),
                                                        input.substring(startIndexAge, endIndexAge));
        }


    }
}
