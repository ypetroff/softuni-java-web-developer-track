package borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> entities = new ArrayList<>();

        String command;
        while (!(command = scanner.nextLine()).equals("End")) {

            String[] info = command.split("\\s+");

            Identifiable identifiable = info.length == 2
                    ? new Robot(info[1], info[0])
                    : new Citizen(info[0], Integer.parseInt(info[1]), info[2]);

            entities.add(identifiable);
        }

        String fakeIds = scanner.nextLine();

        entities.stream()
                .map(Identifiable::getId)
                .filter(id -> id.endsWith(fakeIds))
                .forEach(System.out::println);
    }
}
