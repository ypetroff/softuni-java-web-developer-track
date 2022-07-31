import java.util.Scanner;

public class TheatrePromotion_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfDay = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        int position = -1;

        int[] price = {5, 10, 12, 15, 18, 20};

        switch (typeOfDay) {

            case "Weekday":
                if ((age >= 0 && age <= 18) || (age > 64 && age <= 122)) {
                    position = 2;
                } else if (age > 18 && age <= 64) {
                    position = 4;
                }
                break;
            case "Weekend":
                if ((age >= 0 && age <= 18) || (age > 64 && age <= 122)) {
                    position = 3;
                } else if (age > 18 && age <= 64) {
                    position = 5;
                }
                break;
            case "Holiday":
                if (age >= 0 && age <= 18) {
                    position = 0;
                } else if (age > 18 && age <= 64) {
                    position = 2;
                } else if (age > 64 && age <= 122) {
                    position = 1;
                }
                break;
        }
        if (position == -1) {
            System.out.println("Error!");
        } else {
            System.out.println(price[position] + "$");
        }
    }
}
