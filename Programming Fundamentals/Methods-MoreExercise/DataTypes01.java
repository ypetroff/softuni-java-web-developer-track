import java.util.Scanner;

public class DataTypes01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dataType = scanner.nextLine();
        String data = scanner.nextLine();

        printOutput(dataType, data);
    }

    private static void printOutput(String dataType, String data) {
        if(dataType.equalsIgnoreCase("int")) {
            int integer = Integer.parseInt(data);
            multiplyInt(integer);
        }else if(dataType.equalsIgnoreCase("real")) {
            double number = Double.parseDouble(data);
            multiplyNumber(number);
        } else if (dataType.equalsIgnoreCase("string")) {
            modifyString(data);
        }
    }

    private static void multiplyInt(int integer) {
        int product;
        product = integer * 2;
        System.out.println(product);
    }

    private static void multiplyNumber(double number) {
        double product;
        product = 1.5 * number;
        System.out.printf("%.2f", product);
    }


    private static void modifyString(String data) {
        data = "$" + data + "$";
        System.out.println(data);
    }
}
