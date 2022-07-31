import java.util.Scanner;

public class MouthPrinterV2_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int position = Integer.parseInt(scanner.nextLine());
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        if (position < 1 || position > 12) {
            System.out.println("Error!");
        } else {
            position--;
            System.out.println(month[position]);
        }
    }
}
