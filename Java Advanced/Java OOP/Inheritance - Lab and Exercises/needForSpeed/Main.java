package needForSpeed;

public class Main {
    public static void main(String[] args) {


        Vehicle vehicle = new Vehicle(100, 10);
        vehicle.drive(30);
        System.out.println(vehicle.getFuel());
    }
}
