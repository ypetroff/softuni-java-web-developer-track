package exercises.vehicle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));

        String[] truckInfo = scanner.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] command = scanner.nextLine().split("\\s+");


            switch (command[1]) {

                case "exercises.vehicleExtension.Car":

                    if(command[0].equals("Drive")) {
                        System.out.println(car.drive(Double.parseDouble(command[2])));
                    } else if (command[0].equals("Refuel")) {
                        car.refuel(Double.parseDouble(command[2]));
                    }

                    break;

                case "exercises.vehicleExtension.Truck":

                    if(command[0].equals("Drive")) {
                        System.out.println(truck.drive(Double.parseDouble(command[2])));
                    } else if (command[0].equals("Refuel")) {
                        truck.refuel(Double.parseDouble(command[2]));
                    }
            }

        }

        System.out.println(car.fuelTank());
        System.out.println(truck.fuelTank());
    }

}
