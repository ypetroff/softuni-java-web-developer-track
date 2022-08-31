package RawData02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cars = Integer.parseInt(scanner.nextLine());
        List<Car> listOfCars = new ArrayList<>();
      //  List<Car.Tire> tires = new ArrayList<>();


        for (int i = 0; i < cars; i++) {
            String[] carInfo = scanner.nextLine().split(" ");
            String model = carInfo[0];
            int engSpeed = Integer.parseInt(carInfo[1]);
            int engPower = Integer.parseInt(carInfo[2]);
            int cargoWeight = Integer.parseInt(carInfo[3]);
            String cargoType = carInfo[4];
            double t1Pressure = Double.parseDouble(carInfo[5]);
            int t1Age = Integer.parseInt(carInfo[6]);
            double t2Pressure = Double.parseDouble(carInfo[7]);
            int t2Age = Integer.parseInt(carInfo[8]);
            double t3Pressure = Double.parseDouble(carInfo[9]);
            int t3Age = Integer.parseInt(carInfo[10]);
            double t4Pressure = Double.parseDouble(carInfo[11]);
            int t4Age = Integer.parseInt(carInfo[12]);

            Car.Engine engine = new Car.Engine(engSpeed, engPower);
            Car.Cargo cargo = new Car.Cargo(cargoWeight, cargoType);


            Car.Tire tire1 = new Car.Tire(t1Age, t1Pressure);
            Car.Tire tire2 = new Car.Tire(t2Age, t2Pressure);
            Car.Tire tire3 = new Car.Tire(t3Age, t3Pressure);
            Car.Tire tire4 = new Car.Tire(t4Age, t4Pressure);


            Car car = new Car(model, engine, cargo, tire1, tire2, tire3, tire4);
            listOfCars.add(car);


        }

        String command = scanner.nextLine();
        List<Car> result = new ArrayList<>();
        switch (command) {
            case "flamable":
                result = listOfCars.stream()
                        .filter(car -> car.getCargo().getType().equals("flamable"))
                        .filter(car -> car.getEngine().getPower() > 250).collect(Collectors.toList());
                break;
            case "fragile":
                result = listOfCars.stream()
                        .filter(car -> car.getCargo().getType().equals("fragile"))
                        .filter(p -> p.getTire1().getPressure() < 1 ||
                                p.getTire2().getPressure() < 1 ||
                                p.getTire3().getPressure() < 1 ||
                                p.getTire4().getPressure() < 1)
                        .collect(Collectors.toList());
                break;
        }

        result.forEach(car -> System.out.println(car.getModel()));
    }
}
