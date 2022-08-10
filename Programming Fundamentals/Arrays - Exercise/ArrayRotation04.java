import java.util.Scanner;

public class ArrayRotation04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(" ");
        int rotations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < rotations; i++) {
            String temp = arr[0];
            System.arraycopy(arr, 1, arr, 0, arr.length - 1);
            /*  String temp = arr[0];
            for (int j = 1; j < arr.length; j++) { This for loop equals System.arraycopy
                arr[j - 1] = arr[j];
            } */
            arr[arr.length - 1] = temp;
        }

        for (String s : arr) {
            System.out.print(s + " ");
        }

    }
}
