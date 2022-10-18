package birthdayCelebrations;

import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) {
     Scanner scanner = new Scanner (System.in);

        List<Birthable> objectsWithBirthdate = new ArrayList<>();

     String command;
     while(!(command = scanner.nextLine()).equals("End")) {

         String[] info = command.split("\\s+");

         if(!info[1].contains("-")) {
             Birthable birthable = info.length== 5
                     ? new Citizen(info[1], Integer.parseInt(info[2]), info[3], info[4])
                     : new Pet(info[1], info[2]);

             objectsWithBirthdate.add(birthable);
         }
     }

     String year = scanner.nextLine();

     objectsWithBirthdate.stream().map(Birthable::getBirthDate).filter(y -> y.endsWith(year)).forEach(System.out::println);
    }
}
