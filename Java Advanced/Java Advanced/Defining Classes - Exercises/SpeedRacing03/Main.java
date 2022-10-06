package SpeedRacing03;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Car> cars = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] carData = scanner.nextLine().split("\\s+");
            Car car = new Car(carData[0], Double.parseDouble(carData[1]), Double.parseDouble(carData[2]), 0);
            cars.put(carData[0],car);
        }

        String command;
        while (!(command = scanner.nextLine()).equals("End")){
            String[] chooseCar = command.split("\\s+");
            String model = chooseCar[1];
            int amountOfKms = Integer.parseInt(chooseCar[2]);
            cars.get(model).drive(amountOfKms);
        }
       cars.values().stream().map(Car::toString).forEach(System.out::println);
    }
}
