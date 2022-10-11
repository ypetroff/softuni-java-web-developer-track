import java.util.*;

public class SumOfCoins03 {
    public static int coinCounter = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));


        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

        System.out.println("Number of coins to take: " + coinCounter);

        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.println(usedCoin.getValue() + " coin(s) with value " + usedCoin.getKey());
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {

        Arrays.sort(coins);

        Map<Integer, Integer> temp = new LinkedHashMap<>();
        for (int i = coins.length - 1; i >= 0; i--) {
            int amountOfCoins = countCoins(targetSum, coins[i]);
            if (amountOfCoins == 0) {
                continue;
            }
            coinCounter += amountOfCoins;
            int sumOfCurrentCoin = coins[i] * amountOfCoins;
            targetSum -= sumOfCurrentCoin;
            temp.put(coins[i], amountOfCoins);
        }
        if (targetSum > 0) {
            throw new IllegalArgumentException("Error");
        }
        return temp;
    }

    private static int countCoins(int targetSum, int coin) {
        return targetSum / coin;
    }
}