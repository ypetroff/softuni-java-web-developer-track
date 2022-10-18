package foodShortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Buyer> buyerMap = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {

            String[] info = scanner.nextLine().split("\\s+");

            buyerMap.putIfAbsent(info[0], info.length == 4
                    ? new Citizen(info[0], Integer.parseInt(info[1]), info[2], info[3])
                    : new Rebel(info[0], Integer.parseInt(info[1]), info[2]));
        }

        String command;
        while (!(command=scanner.nextLine()).equals("End")) {

            if(buyerMap.containsKey(command)) {
                buyerMap.get(command).buyFood();
            }

        }

       int sum = buyerMap.values().stream().map(Buyer::getFood).mapToInt(Integer::valueOf).sum();

        System.out.println(sum);

    }

}
