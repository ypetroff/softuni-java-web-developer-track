import java.util.Scanner;

public class Elevator03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        int elevatorCapacity = Integer.parseInt(scanner.nextLine());
        double courses = Math.ceil((double) numberOfPeople / elevatorCapacity);

        System.out.println((int)courses);
    }
}