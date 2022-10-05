package CarConstructors02;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        Set<Car> cars = new LinkedHashSet<>();


        for (int i = 0; i < numberOfCars; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            Car car;
            if(info.length == 1) {
                car = new Car(info[0]);
            }else {
                car = new Car(info[0], info[1], Integer.parseInt(info[2]));
            }
            cars.add(car);
        }

       // cars.stream().map(Car::carInfo).forEach(System.out::println);
        System.out.println(cars.stream().map(Car::carInfo).collect(Collectors.joining(System.lineSeparator())));

    }
}
