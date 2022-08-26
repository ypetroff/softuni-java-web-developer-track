package Songs04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSongs = Integer.parseInt(scanner.nextLine());
        List<Songs> listOfSongs = new ArrayList<>();

        for (int i = 0; i < numberOfSongs; i++) {
            String[] input = scanner.nextLine().split("_");
            String type = input[0];
            String name = input[1];
            String time = input[2];
            Songs song = new Songs(type, name, time);

            listOfSongs.add(song);
        }

        String searchFor = scanner.nextLine();

        if(searchFor.equals("all")) {
            for (Songs song : listOfSongs) {
                System.out.println(song.getName());
            }
        }else {
            for (Songs song : listOfSongs) {
                if(song.getType().equals(searchFor)) {
                    System.out.println(song.getName());
                }
            }
        }

    }
}
