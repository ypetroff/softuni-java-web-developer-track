import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PhoneShop03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> phones = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equalsIgnoreCase("end")) {
            String[] instruction = command.split(" - ");

            if (instruction[0].equalsIgnoreCase("add")) {
                addPhone(phones, instruction[1]);
            }else if (instruction[0].equalsIgnoreCase("remove")) {
                removePhone(phones, instruction[1]);
            } else if (instruction[0].equalsIgnoreCase("bonus phone")) {
                bonusPhone(phones, instruction[1]);
            } else if (instruction[0].equalsIgnoreCase("last")) {
                moveToLastPosition(phones, instruction[1]);
            }
            command = scanner.nextLine();
        }

        System.out.println(String.join(", ", phones));
    }

    private static void addPhone(List<String> phones, String phone) {
        if (!phones.contains(phone)) {
            phones.add(phone);
        }
    }

    private static void removePhone(List<String> phones, String phone) {
            phones.remove(phone);
    }

    private static void bonusPhone(List<String> phones, String s) {
        String[] devices = s.split(":");
        String oldPhone = devices[0];
        String newPhone = devices[1];

        if(phones.contains(oldPhone)) {
            phones.add(phones.indexOf(oldPhone) + 1, newPhone);
        }
    }

    private static void moveToLastPosition(List<String> phones, String phone) {
        if(phones.contains(phone)) {
            phones.remove(phone);
            phones.add(phone);
        }
    }
}
