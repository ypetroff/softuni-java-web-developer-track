package VehicleCatalogue07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Vehicle> catalogue = new ArrayList<>();
        while (!input.equalsIgnoreCase("end")) {
            String[] vehicleData = input.split(" ");
            String type = vehicleData[0];
            String model = vehicleData[1];
            String color = vehicleData[2];
            int horsePower = Integer.parseInt(vehicleData[3]);

            Vehicle vehicle = new Vehicle(type, model, color, horsePower);
            catalogue.add(vehicle);
            input = scanner.nextLine();
        }

        String searchInCatalogue = scanner.nextLine();

        while (!searchInCatalogue.equalsIgnoreCase("Close the Catalogue")) {
            String requestedModel = searchInCatalogue;

            catalogue.stream().filter(p -> p.getModel().equals(requestedModel))
                    .forEach(p -> System.out.println(p.printVehicle()));

//            List<Vehicle> tempList = catalogue.stream()
//                    .filter(p -> p.getModel().equalsIgnoreCase(requestedModel))
//                    .collect(Collectors.toList());
//            tempList.forEach(p -> System.out.println(p.printVehicle());
//            tempList.clear();

            searchInCatalogue = scanner.nextLine();
        }

        String truck = "truck";
        String car = "car";
        double averageHorsepowerTrucks = calculateAverage(catalogue, truck);
        double averageHorsepowerCars = calculateAverage(catalogue, car);

        printAverage(averageHorsepowerCars, car);
        printAverage(averageHorsepowerTrucks, truck);

    }

    private static double calculateAverage(List<Vehicle> catalogue, String vehicle) {
        int counter = 0;
        int sum = 0;
        for (Vehicle vehicle1 : catalogue) {
            if (vehicle1.getType().equals(vehicle)) {
                sum += vehicle1.getHorsePower();
                counter++;
            }
        }

        if(sum == 0 || counter == 0) {
            return 0;
        }else {
            return (double) sum / counter;
        }
    }

    private static void printAverage(double averageHorsepower, String vehicles) {
        String capitalisedFirstLetter = Vehicle.capitalise(vehicles) + "s";
        System.out.printf("%s have average horsepower of: %.2f.%n",capitalisedFirstLetter, averageHorsepower);
    }
}
