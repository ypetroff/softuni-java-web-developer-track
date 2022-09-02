import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        Map<String, String> register = new LinkedHashMap<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String[] command = scanner.nextLine().split("\\s+");

            if(command.length == 3) {
                registerUser(command[1], command[2], register);
            }else if (command.length == 2) {
                unregisterUser(command[1],register);
            }
        }

        register.entrySet().forEach( x -> System.out.printf("%s => %s%n", x.getKey(), x.getValue()));
    }

    private static void registerUser(String user, String licencePlate, Map<String, String> register) {

        if(!register.containsKey(user)) {
           register.put(user, licencePlate);
            System.out.printf("%s registered %s successfully%n", user, register.get(user));
        } else {
            System.out.printf("ERROR: already registered with plate number %s%n", register.get(user));
        }



    }

    private static void unregisterUser(String user, Map<String, String> register) {
        if(register.containsKey(user)) {
            System.out.printf("%s unregistered successfully%n", user);
            register.remove(user);
        }else {
            System.out.printf("ERROR: user %s not found%n", user);
        }

    }
}
