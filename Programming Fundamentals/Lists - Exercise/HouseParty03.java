import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        List<String> peopleAtTheParty = new ArrayList<>();

        String command = scanner.nextLine();
        for (int i = 0; i < numberOfCommands; i++) {

            String[]currentCommand = command.split(" ");

            if(currentCommand[2].equalsIgnoreCase("going!")) {
                addPersonToTheList(peopleAtTheParty, currentCommand[0]);
            } else {
                removePersonFromTheList(peopleAtTheParty,currentCommand[0]);
            }
            if (i < numberOfCommands - 1) {
                command = scanner.nextLine();
            }
        }

        for (String name : peopleAtTheParty) {
            System.out.println(name);
        }
    }

    private static void addPersonToTheList(List<String> peopleAtTheParty, String name) {
        boolean isPresent = getPartyPeople(peopleAtTheParty, name);

        if(!isPresent) {
            peopleAtTheParty.add(name);
        }else {
            System.out.printf("%s is already in the list!%n",name);
        }
    }

    private static void removePersonFromTheList(List<String> peopleAtTheParty, String name) {
        boolean isPresent = getPartyPeople(peopleAtTheParty, name);

        if (!isPresent) {
            System.out.printf("%s is not in the list!%n", name);
        } else {
            peopleAtTheParty.removeIf(p -> p.equals(name));
        }
    }

    private static boolean getPartyPeople(List<String> peopleAtTheParty, String name) {
        for (String s : peopleAtTheParty) {
           if(s.equals(name)) {
               return true;
           }
        }
        return false;
    }
}
