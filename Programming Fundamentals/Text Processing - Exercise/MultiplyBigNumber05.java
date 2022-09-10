import java.util.Scanner;

public class MultiplyBigNumber05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] bigNumber = input.split("");
        boolean zeroCheck = true;
        for (String s : bigNumber) {
            if(!s.equals("0")) {
                zeroCheck = false;
                break;
            }
        }
        int number = Integer.parseInt(scanner.nextLine());
        int remainder = 0;
        if(number == 0 || zeroCheck) {
            System.out.println("0");
        } else {
            for (int i = bigNumber.length - 1; i >= 0; i--) {

                char test = bigNumber[i].charAt(0);

                if(!Character.isDigit(test)) {
                    continue;
                }

                int currentNumber = Integer.parseInt(bigNumber[i]);

                int product = (currentNumber * number) + remainder;

                if (product > 9) {
                    if(i == 0) {
                        bigNumber[i] = String.valueOf(product);
                        break;
                    }
                    remainder = product / 10;
                    product = product % 10;
                } else {
                    remainder = 0;
                }
                bigNumber[i] = String.valueOf(product);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bigNumber.length; i++) {
                    sb.append(bigNumber[i]);
            }
            String output = sb.toString();

            while (true) {
               int index = output.indexOf("0");
               if(index == 0) {
                   output = output.substring(1);
               }else {
                   break;
               }
            }


            System.out.println(output);

        }

    }
}
