import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double savings = Double.parseDouble(scanner.nextLine());
        List<Integer> drumSets = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer>  initialQuality = new ArrayList<>();
        initialQuality.addAll(drumSets);
        int powerHit = 0;



            String hitPower = scanner.nextLine();

            while (!hitPower.equals("Hit it again, Gabsy!")) {
                powerHit = Integer.parseInt(hitPower);

                for (int i = 0; i <  drumSets.size(); i++) {

                    int drum = drumSets.get(i);
                    int drumMinusPower = drum - powerHit;

                    if (drumMinusPower > 0) {
                        drumSets.set(i, drumMinusPower);
                    } else {
                        int moneyForNewDrum = initialQuality.get(i) * 3;

                        boolean hasEnoughMoney = savings - moneyForNewDrum > 0;

                        if(hasEnoughMoney) {
                            savings-=moneyForNewDrum;
                            drumSets.set(i, initialQuality.get(i));
                        } else {
                            drumSets.remove(i);
                            initialQuality.remove(i);
                            if (i < drumSets.size()) {
                                i--;
                            }
                        }
                    }
                }

                hitPower = scanner.nextLine();
            }


        String drumsLeft = drumSets.toString().replaceAll("[\\[\\],]", "");
        System.out.println(drumsLeft);
        System.out.printf("Gabsy has %.2flv.%n", savings);

    }
}
