import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cycles = Integer.parseInt(scanner.nextLine());

        int[] encryptedData = new int[cycles];

        for (int i = 0; i < cycles; i++) {

            String[] name = Arrays.stream(scanner.nextLine().split("(?!^)"))
                    .toArray(String[]:: new);
            int code = 0;
            for (String s : name) {

                if (s.equalsIgnoreCase("a") ||
                    s.equalsIgnoreCase("e") ||
                    s.equalsIgnoreCase("o") ||
                    s.equalsIgnoreCase("i") ||
                    s.equalsIgnoreCase("u")) {

                    code += s.charAt(0) * name.length;
                } else {
                    code += s.charAt(0) / name.length;
                }
            }

            encryptedData[i] = code;
        }
        Arrays.sort(encryptedData);

        for (int encryptedDatum : encryptedData) {
            System.out.println(encryptedDatum);
        }
    }
}
