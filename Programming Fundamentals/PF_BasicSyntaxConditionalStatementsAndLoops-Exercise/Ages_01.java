import java.util.Scanner;

public class Ages_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());

        String[] ages = {"baby", "child", "teenager", "adult", "elder"};
        int position = -1;

        if(age >= 0 && age <= 2){
            position = 0;
        }else if (age >= 3 && age <= 13) {
            position = 1;
        }else if (age >= 14 && age <= 19) {
            position = 2;
        }else if (age >= 20 && age <= 65) {
            position = 3;
        } else if (age >= 66) {
            position = 4;
        }

        if (position != -1) {
            System.out.println(ages[position]);
        }
    }
}
