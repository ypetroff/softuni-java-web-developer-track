package PiratesClass03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cities;
        List<Cities> citiesList = new ArrayList<>();

        while (!"Sail".equalsIgnoreCase(cities = scanner.nextLine())) {
            String[] tokens = cities.split("\\|\\|");

            boolean cityExists = checkCity(citiesList, tokens[0]);
            if(!cityExists) {
                Cities city = new Cities(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
            }else {
                
            }


        }
    }

    private static boolean checkCity(List<Cities> citiesList, String cityName) {
        for (Cities cities : citiesList) {
            if(cities.getName().equals(cityName)) {
                return true;
            }
        }
        return false;
    }
}
