import java.util.Scanner;

public class TreasureFinder03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().trim().split("\\s+");

        int[] key = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            key[i] = Integer.parseInt(input[i]);
        }

        String stings;

        while (!"find".equals(stings = scanner.nextLine())) {
            char[] chars = stings.toCharArray();

            for (int i = 0, j = 0; i < chars.length; i++, j ++) {

                chars[i] = (char)(chars[i] - key[j]);
                if(j == key.length - 1) {
                    j = -1;
                }
            }

            StringBuilder itemAndLocation = new StringBuilder();
            for (char aChar : chars) {
                itemAndLocation.append(aChar);
            }

            String output = itemAndLocation.toString();

            int startItemIndex = output.indexOf("&") + 1;
            int endItemIndex = output.lastIndexOf("&");
            int startLocation = output.indexOf("<") + 1;
            int endLocation = output.indexOf(">");

            String item = output.substring(startItemIndex, endItemIndex);
            String location = output.substring(startLocation, endLocation);

            System.out.printf("Found %s at %s%n",item, location);

        }
    }
}
