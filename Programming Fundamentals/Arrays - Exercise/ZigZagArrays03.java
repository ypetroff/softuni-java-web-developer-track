import java.util.Scanner;

public class ZigZagArrays03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());

        String[] arr1 = new String[length];
        String[] arr2 = new String[length];

        for (int i = 1; i <= length; i++) {
            String[] input = scanner.nextLine().split(" ");

            if (i % 2 != 0) {
                arr1[i - 1] = input[0];
                arr2[i - 1] = input[1];
            }else {
                arr1[i - 1] = input[1];
                arr2[i - 1] = input[0];
            }
        }
        for (String s : arr1) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s : arr2) {
            System.out.print(s + " ");
        }
    }
}
