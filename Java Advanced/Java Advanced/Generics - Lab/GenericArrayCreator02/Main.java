package GenericArrayCreator02;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String[] arr = ArrayCreator.create(10, "n/a");
        Integer[] ints = ArrayCreator.create(Integer.class, 14, 0);

        for (int i = 0; i < arr.length; i++) {
          StringBuilder sb = new StringBuilder("test");
            arr[i] = sb.append(i).toString();
        }

        for (int i = 0; i < ints.length; i++) {
            ints[i] = i + i * 303;
        }

        System.out.println(String.join(", ", arr));
        System.out.println();
        System.out.println(Arrays.stream(ints).map(String::valueOf).collect(Collectors.joining(", ")));

    }
}
