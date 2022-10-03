import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetics04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<int[], int[]> add = x -> Arrays.stream(x).map(i -> i + 1).toArray();
        Function<int[], int[]> multiply = x -> Arrays.stream(x).map(i -> i * 2).toArray();
        Function<int[], int[]> subtract = x -> Arrays.stream(x).map(i -> i - 1).toArray();
        Consumer<int[]> printArr = x -> Arrays.stream(x).forEach(n -> System.out.printf("%d ", n));
        int[] numArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String command;
        while (!(command = scanner.nextLine()).equals("end")) {
            switch (command) {
                case "add":
                    numArr = add.apply(numArr);
                    break;
                case "multiply":
                    numArr = multiply.apply(numArr);
                    break;
                case "subtract":
                    numArr = subtract.apply(numArr);
                    break;
                case "print":
                    printArr.accept(numArr);
                    System.out.println();
                    break;
            }
        }
        //   printArr.accept(numArr);
    }
}
