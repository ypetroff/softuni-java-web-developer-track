package RandomArrayList04;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> myList = Arrays.asList(1, 2, 3, 3, 6, 9, 500);

        RandomArrayList<Integer> randomArrayList = new RandomArrayList<>() {
            {
                add(1);
                add(44);
                add(23);
                add(67);
                add(89);
                add(20);
            }
        };

        System.out.println(randomArrayList.getRandomElement());
    }
}
