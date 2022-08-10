import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LadyBugs10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int sizeOfField = Integer.parseInt(scanner.nextLine());
        int[] ladyBugsLocation = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        List<Integer> realLocation = new ArrayList<>();
        for (int i = 0; i < ladyBugsLocation.length; i++) {
            if (ladyBugsLocation[i] >= 0 && ladyBugsLocation[i] < sizeOfField) {
                realLocation.add(ladyBugsLocation[i]);
            }
        }

        int[] field = new int[sizeOfField];

        for (int i = 0; i < realLocation.size(); i++) {
            field[realLocation.get(i)] = 1;
        }

        String ladyBugMovement = scanner.nextLine();

        while (!ladyBugMovement.equalsIgnoreCase("end")) {
            String[] currentInformation = Arrays.stream(ladyBugMovement.split(" "))
                    .toArray(String[] ::new);

            int ladyBugIndex = Integer.parseInt(currentInformation[0]);
            String direction = currentInformation[1];
            int flyLength = Integer.parseInt(currentInformation[2]);

            if (ladyBugIndex < 0 || ladyBugIndex >= sizeOfField || field[ladyBugIndex] == 0) {
                ladyBugMovement = scanner.nextLine();
                continue;
            }

                field[ladyBugIndex] = 0;
                int flownDistance = 0;
                if (direction.equalsIgnoreCase("right")) {
                    boolean isTaken = false;
                    if (ladyBugIndex + flyLength >= sizeOfField) {
                        ladyBugMovement = scanner.nextLine();
                        continue; // break;
                    } else if (field[ladyBugIndex + flyLength] == 1) {
                        isTaken = true;
                        flownDistance = ladyBugIndex + flyLength;
                    } else if (field[ladyBugIndex + flyLength] == 0) {
                        field[ladyBugIndex + flyLength] = 1;
                    }
                    while (isTaken) {
                        if (sizeOfField <= flownDistance + flyLength || flownDistance + flyLength < 0) { //tuk
                            break;
                        } else if(field[flownDistance + flyLength] == 1) {
                            flownDistance+=flyLength;
                        } else if (field[flownDistance + flyLength] == 0) {
                            field[flownDistance + flyLength] = 1;
                            flownDistance = 0;
                            isTaken = false;
                        }
                    }
                } else if (direction.equalsIgnoreCase("left")) {
                    boolean isTaken = false;
                    if (ladyBugIndex - flyLength < 0) {
                        ladyBugMovement = scanner.nextLine();
                        continue;
                    } else if (field[ladyBugIndex - flyLength] == 1) {
                        isTaken = true;
                        flownDistance = ladyBugIndex - flyLength;
                    } else if (field[ladyBugIndex - flyLength] == 0) {
                        field[ladyBugIndex - flyLength] = 1;
                    }
                    while (isTaken) {
                        if (sizeOfField <= flownDistance - flyLength || flownDistance - flyLength < 0) {
                            break;
                        } else if(field[flownDistance - flyLength] == 1) {
                            flownDistance-=flyLength;
                        } else if (field[flownDistance - flyLength] == 0) {
                            field[flownDistance - flyLength] = 1;
                            flownDistance = 0;
                            isTaken = false;
                        }
                    }
                }
              ladyBugMovement = scanner.nextLine();
        }
        String output = Arrays.stream(field)
                .mapToObj(String ::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(output);

    }
}
