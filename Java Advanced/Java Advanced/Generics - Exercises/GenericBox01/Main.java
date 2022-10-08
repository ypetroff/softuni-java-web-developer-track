package GenericBox01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfElements = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfElements; i++) {
            String str = scanner.nextLine();
            Box<String> box = new Box<>(str);
            System.out.println(box);

        }

//        for (int i = 0; i < numberOfElements; i++) {
//            int num = Integer.parseInt(scanner.nextLine());
//            Box<Integer> box = new Box<>(num);
//            System.out.println(box);
//        }
    }
}
