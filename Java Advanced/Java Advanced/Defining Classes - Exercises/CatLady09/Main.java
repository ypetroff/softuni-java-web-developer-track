package CatLady09;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Cat> cats = new HashMap<>();

        String command;
        while(!(command = scanner.nextLine()).equals("End")) {
            String[] catInfo = command.split("\\s+");
            String breed = catInfo[0];
            String name = catInfo[1];
            double measurement = Double.parseDouble(catInfo[2]);

            switch (breed) {
                case "Cymric":
                    cats.putIfAbsent(name, new Cymric(breed, name, measurement));
                    break;
                case "Siamese":
                    cats.putIfAbsent(name, new Siamese(breed, name, measurement));
                    break;
                case "StreetExtraordinaire":
                    cats.putIfAbsent(name, new StreetExtraordinaire(breed, name, measurement));
                    break;
            }
        }
        System.out.println(cats.get(scanner.nextLine()));
    }
}
