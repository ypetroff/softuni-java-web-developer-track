import java.util.*;

public class NeedForSpeedIII03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> carCatalogue = new HashMap<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] carDetails = scanner.nextLine().split("\\|");

            carCatalogue.put(carDetails[0], Arrays.asList(Integer.parseInt(carDetails[1]), Integer.parseInt(carDetails[2])));

        }
String command;
        while (!"Stop".equals(command = scanner.nextLine())) {
            String[] tokens = command.split(" : ");
            String car = tokens[1];
            switch (tokens[0]) {
                case "Drive":
                    int distance = Integer.parseInt(tokens[2]);
                    int fuel = Integer.parseInt(tokens[3]);

                    if(carCatalogue.get(car).get(1) >= fuel) {
                        carCatalogue.get(car).set(0, carCatalogue.get(car).get(0) + distance);
                        carCatalogue.get(car).set(1, carCatalogue.get(car).get(1) - fuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);

                        if(carCatalogue.get(car).get(0) >= 100000) {
                            System.out.printf("Time to sell the %s!%n", car);
                            carCatalogue.remove(car);
                        }

                    }else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    break;
                case "Refuel":
                    int currentAmount = carCatalogue.get(car).get(1);
                    int refill = Integer.parseInt(tokens[2]);
                    if(currentAmount + refill <= 75) {
                        carCatalogue.get(car).set(1, carCatalogue.get(car).get(1) + refill);
                    }else {
                        carCatalogue.get(car).set(1, 75);
                        refill = 75 - currentAmount;
                    }
                    System.out.printf("%s refueled with %d liters%n", car, refill);

                    break;
                case "Revert":
                    int passedMiles = carCatalogue.get(car).get(0);
                    int decrease = Integer.parseInt(tokens[2]);

                    carCatalogue.get(car).set(0, Math.max(passedMiles - decrease, 10000));

                    if(carCatalogue.get(car).get(0) != 10000) {
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, decrease);
                    }
                    break;
            }
        }
        carCatalogue.entrySet().stream().sorted((c1, c2) -> {
                    int result = c2.getValue().get(0).compareTo(c1.getValue().get(0));

                    if (result == 0) {
                        result = c1.getKey().compareTo(c2.getKey());
                    }
                    return result;
                })
                .forEach(c -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", c.getKey(), c.getValue().get(0), c.getValue().get(1)));
    }
}
