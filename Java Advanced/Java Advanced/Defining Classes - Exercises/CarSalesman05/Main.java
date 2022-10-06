package CarSalesman05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Engine> engineList = new ArrayList<>();

        int numberOfEngines = Integer.parseInt(scanner.nextLine());
        while (numberOfEngines-- > 0) {

            String[] engineDetails = scanner.nextLine().split("\\s+");
            String model = engineDetails[0];
            String power = engineDetails[1];
            String displacement = "n/a";
            String efficiency = "n/a";

            if (engineDetails.length == 3 && !Character.isAlphabetic(engineDetails[2].charAt(0))) {
                displacement = engineDetails[2];
            } else if(engineDetails.length == 3 && Character.isAlphabetic(engineDetails[2].charAt(0))){
                efficiency = engineDetails[2];
            }
            if (engineDetails.length == 4) {
                displacement = engineDetails[2];
                efficiency = engineDetails[3];
            }
            Engine engine = new Engine(model, power, displacement, efficiency);
            engineList.add(engine);
        }

        List<Car> cars = new ArrayList<>();

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        while (numberOfCars-- > 0) {

            String[] carDetails = scanner.nextLine().split("\\s+");
            String model = carDetails[0];
            String engine = carDetails[1];
            String weight = "n/a";
            String colour = "n/a";

            if (carDetails.length == 3 && Character.isDigit(carDetails[2].charAt(0))) {
                weight = carDetails[2];
            } else if(carDetails.length == 3 && Character.isAlphabetic(carDetails[2].charAt(0))){
                colour = carDetails[2];
            }

            if (carDetails.length == 4) {
                weight = carDetails[2];
                colour = carDetails[3];
            }
            Engine useEngine = engineList.stream().filter(e -> e.getModel().equals(engine)).findFirst().orElse(null);
            Car car = new Car(model, useEngine, weight, colour);
            cars.add(car);
        }
        cars.stream().map(Car::toString).forEach(System.out::print);
    }
}
