import java.util.Scanner;

public class SumPrimeNonPrime03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        int sumPrime = 0;
        int sumComposite = 0;

        while (!number.equals("stop")) {
            boolean prime = true;
            int currentNumber = Integer.parseInt(number);
            if (currentNumber < 0) {
                System.out.println("Number is negative.");
                number = scanner.nextLine();
                continue;
            }

            if (currentNumber <= 1 || currentNumber % 2 == 0 && currentNumber != 2) {
                prime = false;
            }

            int boundary = (int) Math.floor(Math.sqrt(currentNumber));
            for (int i = 3; i <= boundary; i += 2) {
                if (currentNumber % i == 0) {
                    prime = false;
                    break;
                }
                //  prime = true;


            }
            if (prime) {
                sumPrime += currentNumber;
            } else {
                sumComposite += currentNumber;
            }
            number = scanner.nextLine();
        }
        System.out.printf("Sum of all prime numbers is: %d%n", sumPrime);
        System.out.printf("Sum of all non prime numbers is: %d%n", sumComposite);
    }
}

