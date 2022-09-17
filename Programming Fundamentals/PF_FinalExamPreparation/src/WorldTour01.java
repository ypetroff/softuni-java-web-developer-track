import java.util.Scanner;

public class WorldTour01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder destinations = new StringBuilder(scanner.nextLine());
        String command;
        while(!"Travel".equalsIgnoreCase(command = scanner.nextLine())) {
            String[] tokens = command.split(":");

            switch (tokens[0]) {
                case "Add Stop":
                   addStop(destinations, tokens);
                    break;
                case "Remove Stop":
                    removeStop(destinations, tokens);
                    break;
                case "Switch":
                    swap(destinations, tokens);
                    break;
            }
            System.out.println(destinations);
        }
        System.out.printf("Ready for world tour! Planned stops: %s", destinations);
    }

    private static void addStop(StringBuilder destinations, String[] tokens) {
        int index = Integer.parseInt(tokens[1]);
        String text = tokens[2];
        boolean isValid = validate(destinations, index);

        if(isValid) {
            destinations.insert(index, text);
        }
    }



    private static void removeStop(StringBuilder destinations, String[] tokens) {
        int startIndex = Integer.parseInt(tokens[1]);
        int endIndex = Integer.parseInt(tokens[2]);
        boolean validStart = validate(destinations, startIndex);
        boolean validEnd = validate(destinations, endIndex);

        if(validStart && validEnd && startIndex <= endIndex) {
            destinations.delete(startIndex, endIndex + 1);
        }
    }

    private static void swap(StringBuilder destinations, String[] tokens) {
        String old = tokens[1];
        String current = tokens[2];
        String temp = destinations.toString();

        if(temp.contains(old)) {
            temp = temp.replace(old, current);
        }
        destinations.setLength(0);
        destinations.append(temp);
    }

    private static boolean validate(StringBuilder destinations, int index) {
        return index < destinations.length() && index >= 0;
    }
}
