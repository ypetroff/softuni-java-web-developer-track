import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int[] specialNumberAndPower = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int specialNumber = specialNumberAndPower[0];
        int power = specialNumberAndPower[1];

        detonateList(listNumbers, specialNumber, power);

        long sum = 0;
        for (Integer listNumber : listNumbers) {
            sum+=listNumber;
        }
        System.out.println(sum);
    }

    private static void detonateList(List<Integer> listNumbers, int specialNumber, int power) {
        for (int i = 0; i < listNumbers.size(); i++) {
           if (listNumbers.get(i).equals(specialNumber)) {
               for (int j = power; j > 0; j--) {

                   removeFollowingNumber(listNumbers, i);

                   boolean isInbound = i - 1 >= 0;

                   if(isInbound) {
                       removePreviousNumber(listNumbers, i);
                       i--;
                   }
               }
               listNumbers.remove(i);
                   i--;

           }
        }
    }

    private static void removeFollowingNumber(List<Integer> listNumbers, int i) {
        boolean isInbound = i + 1 < listNumbers.size();

        if(isInbound) {
            listNumbers.remove(i + 1);
        }

    }

    private static void removePreviousNumber(List<Integer> listNumbers, int i) {
            listNumbers.remove(i - 1);
    }


}
