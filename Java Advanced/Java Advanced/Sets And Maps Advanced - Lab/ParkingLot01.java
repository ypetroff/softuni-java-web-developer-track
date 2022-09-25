import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> licencePlates = new LinkedHashSet<>();

        String command;
        while (!"END".equals(command = scanner.nextLine())) {
            String[] carInfo = command.split(",\\s");

            modifySet(licencePlates, carInfo[0], carInfo[1]);
        }
        if (!licencePlates.isEmpty()) {
            licencePlates.forEach(System.out::println);
        } else {
            System.out.println("Parking Lot is Empty");
        }

    }

    private static void modifySet(Set<String> set, String direction, String licencePlate) {

        switch (direction) {
            case "IN":
                set.add(licencePlate);
                break;
            case "OUT":
                set.remove(licencePlate);
                break;
        }
    }
}
