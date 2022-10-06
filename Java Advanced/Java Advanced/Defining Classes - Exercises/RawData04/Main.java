package RawData04;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            createCar(scanner, cars);
        }
        String command = scanner.nextLine();
        List<Car> selectCars = cars.stream()
                .filter(car -> car.getCargo().getType().equals(command))
                .collect(Collectors.toList());
        if(command.equals("fragile")) {
            selectCars.stream().filter(car -> car.checkTires(car.getTires())).forEach(c -> System.out.printf("%s%n",c.getModel()));
        } else if(command.equals("flamable")) {
            selectCars.stream().filter(car -> car.checkEngine(car.getEngine())).forEach(c -> System.out.printf("%s%n",c.getModel()));
        }



    }

    private static void createCar(Scanner scanner, List<Car> cars) {
        String[] carInfo = scanner.nextLine().split("\\s+");
        String model = carInfo[0];
        int engineSpeed = Integer.parseInt(carInfo[1]);
        int enginePower = Integer.parseInt(carInfo[2]);
        int cargoWeight = Integer.parseInt(carInfo[3]);
        String cargoType = carInfo[4];
        double tire1Pressure = Double.parseDouble(carInfo[5]);
        int tire1Age = Integer.parseInt(carInfo[6]);
        double tire2Pressure = Double.parseDouble(carInfo[7]);
        int tire2Age = Integer.parseInt(carInfo[8]);
        double tire3Pressure = Double.parseDouble(carInfo[9]);
        int tire3Age = Integer.parseInt(carInfo[10]);
        double tire4Pressure = Double.parseDouble(carInfo[11]);
        int tire4Age = Integer.parseInt(carInfo[12]);

        Engine engine = new Engine(engineSpeed, enginePower);
        Cargo cargo = new Cargo(cargoWeight, cargoType);
        Tire tire1 = new Tire(tire1Pressure, tire1Age);
        Tire tire2 = new Tire(tire2Pressure, tire2Age);
        Tire tire3 = new Tire(tire3Pressure, tire3Age);
        Tire tire4 = new Tire(tire4Pressure, tire4Age);
        List<Tire> tires = List.of(tire1, tire2, tire3, tire4);
        Car car = new Car(model, engine, cargo, tires);
        cars.add(car);
    }
}
