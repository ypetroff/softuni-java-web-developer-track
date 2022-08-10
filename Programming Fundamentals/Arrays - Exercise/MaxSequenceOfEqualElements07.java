import java.util.Scanner;

public class MaxSequenceOfEqualElements07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      //  StringBuilder maxSequence = new StringBuilder();

        String[] input = scanner.nextLine().split(" ");
        //   int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        int counter = 0;
        int max = 0;
        String number = "";

        for (int i = input.length - 1; i > 0; i--) {

            if (input[i].equals(input[i - 1])) {
                counter++;
                if (counter >= max) {
                    max = counter;
                    number = input[i];
                }
            } else {
                counter = 0;
            }
        }
        for (int i = 0; i < max + 1; i++) {
            System.out.print(number + " ");
        }


    }
}
