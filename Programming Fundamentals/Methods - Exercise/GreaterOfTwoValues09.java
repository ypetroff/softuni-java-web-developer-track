import java.util.Scanner;

public class GreaterOfTwoValues09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dataType = scanner.nextLine();

        switch (dataType) {
            case "int":
                int num1 = Integer.parseInt(scanner.nextLine());
                int num2 = Integer.parseInt(scanner.nextLine());

                getMax(num1, num2);
                break;
            case "char":
                char symbol1 = scanner.nextLine().charAt(0);
                char symbol2 = scanner.nextLine().charAt(0);

                getMax(symbol1, symbol2);
                break;
            case "string":
                String s1 = scanner.nextLine();
                String s2 = scanner.nextLine();

                getMax(s1, s2);
                break;
        }
    }

    private static void getMax(int a, int b) {
        System.out.println(Math.max(a, b));
    }

    private static void getMax(char a, char b) {
        if (a > b) {
            System.out.println(a);
        }else {
            System.out.println(b);
        }
    }

    private static void getMax(String a, String b) {
        if (a.compareTo(b) >= 0) {
            System.out.println(a);
        }else {
            System.out.println(b);
        }
    }
}
