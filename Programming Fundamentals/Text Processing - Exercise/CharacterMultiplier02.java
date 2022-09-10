import java.util.Scanner;

public class CharacterMultiplier02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        char[] arr1 = input.split(" ")[0].toCharArray();
        char[] arr2 = input.split(" ")[1].toCharArray();

        int commonLength = Math.min(arr1.length, arr2.length);
        int additionalLength = Math.max(arr1.length, arr2.length);
        int sum = 0;

        for (int i = 0; i < commonLength; i++) {
            sum+= arr1[i] * arr2[i];
        }

        if(arr1.length > arr2.length) {
            for (int i = commonLength; i < additionalLength; i++) {
                sum+=arr1[i];
            }
        } else if (arr1.length < arr2.length) {
            for (int i = commonLength; i < additionalLength; i++) {
                sum+= arr2[i];
            }
        }
        System.out.println(sum);
    }
}
