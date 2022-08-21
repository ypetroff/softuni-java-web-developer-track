import java.util.Scanner;

public class TribonacciSequence04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        int[] arr = new int[num];
        arr[0] = 1;
        if (num >= 2) {
            arr[1] = arr[0];
        }
        if(num >= 3) {
            arr[2] = 2;
        }

        printTribonacciNumbers(arr, num);
    }

    private static void printTribonacciNumbers(int[] arr, int num) {

        if (num != 1 && num != 2 && num != 3) {
            arr = findAndFillNumbers(arr, num);
        }
        printArr(arr);

    }

    private static int[] findAndFillNumbers(int[] arr, int num) {
        for (int i = 3; i < num; i++) {

            int currentNumber = arr[i - 1] + arr[i - 2] + arr[i - 3];
            arr[i] = currentNumber;
        }

        return arr;
    }

    private static void printArr(int[] arr) {

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
