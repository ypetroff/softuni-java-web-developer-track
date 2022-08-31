package CarSalesman03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfEngines = Integer.parseInt(scanner.nextLine());

        List<Engine> engineList = new ArrayList<>();

        for (int i = 0; i < numberOfEngines; i++) {
            String[] command = scanner.nextLine().split(" ");
            String model = command[0];
            String power = command[1];
            String displacement = "n/a";
            String efficiency = "n/a";

            if(command.length == 3) {
                try {
                    Integer.parseInt(command[2]);
                    displacement = command[2];
                } catch (Exception exception) {
                    efficiency = command[2];
                }
            } else if(command.length == 4) {
                displacement = command[2];
                efficiency = command[3];
            }

            Engine engine = new Engine(model, power, displacement, efficiency);
            engineList.add(engine);
        }

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        List<Car> carsList = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            String[] command = scanner.nextLine().split(" ");
            String model = command[0];
            String engine = command[1];
            String weight = "n/a";
            String colour = "n/a";

            if(command.length == 3) {
                try {
                    Integer.parseInt(command[2]);
                    weight = command[2];
                } catch (Exception exception) {
                    colour = command[2];
                }
            } else if(command.length == 4) {
                weight = command[2];
                colour = command[3];
            }

            Engine engineSpecification = engineList.stream().filter(p -> p.getModel().equals(engine)).findFirst().orElseThrow();
            Car car = new Car(model, engineSpecification, weight, colour);
            carsList.add(car);
        }

        carsList.forEach(System.out::println);

    }
}
