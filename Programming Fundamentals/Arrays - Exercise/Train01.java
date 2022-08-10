import java.util.Scanner;

public class Train01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());

        int[] peopleOnTheTrain = new int[length];

        for (int i = 0; i < length; i++) {
            int currentWagon = Integer.parseInt(scanner.nextLine());
            peopleOnTheTrain[i] = currentWagon;
        }
        int sum = 0;
        for (int wagon : peopleOnTheTrain) {
            sum+= wagon;
        }

        for (int i = 0; i < length; i++) {
            System.out.printf("%d ",peopleOnTheTrain[i]);
        }
        System.out.println();
        System.out.println(sum);
    }
}
