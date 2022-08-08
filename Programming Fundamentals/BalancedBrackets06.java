import java.util.Scanner;

public class BalancedBrackets06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        int openingBr = 0;
        int closingBr = 0;
        boolean hasAnOpening = false;
        boolean hasFailed = false;

        for (int i = 0; i < lines; i++) {
            String input = scanner.nextLine();

            if(input.equals("(")) {
                openingBr++;
                hasAnOpening = true;
            } else if (input.equals(")")) {
                if (!hasAnOpening) {
                    hasFailed = true;
                    break;
                }
                closingBr++;
                hasAnOpening = false;
            }
        }
        if (!hasFailed && openingBr == closingBr ) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
