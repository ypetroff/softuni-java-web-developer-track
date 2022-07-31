import java.util.Scanner;

public class ForeignLanguages_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String state = scanner.nextLine();

        switch (state) {
            case "USA":
            case "England":
                System.out.println("English");
                break;
            case "Argentina":
            case "Mexico":
            case "Spain":
                System.out.println("Spanish");
                break;
            default:
                System.out.println("unknown");
        }
    }
}
