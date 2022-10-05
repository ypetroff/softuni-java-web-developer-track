package CarInfo01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCars; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            Car car = new Car();
            car.setBrand(info[0]);
            car.setModel(info[1]);
            car.setHorsePower(Integer.parseInt(info[2]));
            System.out.println(car.carInfo());
        }
    }
}
