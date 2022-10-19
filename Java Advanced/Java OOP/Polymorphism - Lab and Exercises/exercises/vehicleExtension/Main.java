package exercises.vehicleExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Vehicle car = createVehicle(scanner);
        Vehicle truck = createVehicle(scanner);
        Vehicle bus = createVehicle(scanner);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");

            String action = command[0];
            String vehicleType = command[1];
           Vehicle vehicle = vehicles.get(vehicleType);

           try {
               switch (action) {
                   case "Drive":
                       if(vehicle instanceof Bus) {
                           ((Bus)vehicle).setEmpty(false);
                       }
                       System.out.println(vehicle.drive(Double.parseDouble(command[2])));
                       break;
                   case "Refuel":
                       vehicles.get(vehicleType).refuel(Double.parseDouble(command[2]));
                       break;
                   case "DriveEmpty":
                       if(vehicle instanceof Bus) {
                           ((Bus)vehicle).setEmpty(true);
                       }
                       System.out.println(vehicle.drive(Double.parseDouble(command[2])));
               }
           } catch (IllegalArgumentException e) {
               System.out.println(e.getMessage());
           }


        }

        vehicles.values().forEach(System.out::println);
    }

    private static Vehicle createVehicle(Scanner scanner) {
        String[] info = scanner.nextLine().split("\\s+");

        double quantity = Double.parseDouble(info[1]);
        double consumption = Double.parseDouble(info[2]);
        double capacity = Double.parseDouble(info[3]);

        Vehicle vehicle;

        switch (info[0]) {
            case "Car":
                vehicle = new Car(quantity, consumption, capacity);
                break;
            case "Truck":
                vehicle = new Truck(quantity, consumption, capacity);
                break;
            case "Bus":
                vehicle = new Bus(quantity, consumption, capacity);
                break;
            default:
                throw new IllegalArgumentException("No such vehicle");
        }

        return vehicle;
    }

}
