import java.util.*;

public class MOBAChallenger03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Map<String, Integer>> playerRooster = new LinkedHashMap<>();

        while (!input.equalsIgnoreCase("Season end")) {
            if (input.contains("->")) {
                String[] playerStats = input.split(" -> ");
                String player = playerStats[0];
                String position = playerStats[1];
                int skill = Integer.parseInt(playerStats[2]);

                playerRooster.putIfAbsent(player, new LinkedHashMap<>());
                playerRooster.get(player).putIfAbsent(position, 0);
                if (playerRooster.get(player).get(position) < skill) {
                    playerRooster.get(player).put(position, skill);
                }
            } else {
                String[] duel = input.split(" vs ");
                String player1 = duel[0];
                String player2 = duel[1];


                if (playerRooster.containsKey(player1) && playerRooster.containsKey(player2)) {
                    loop:
                    for (Map.Entry<String, Map<String, Integer>> entryP1 : playerRooster.entrySet()) {
                        if (entryP1.getKey().equals(player1)) {
                            for (Map.Entry<String, Map<String, Integer>> entryP2 : playerRooster.entrySet()) {
                                if (entryP2.getKey().equals(player2)) {
                                    for (Map.Entry<String, Integer> valP1 : entryP1.getValue().entrySet()) {
                                        for (Map.Entry<String, Integer> valP2 : entryP2.getValue().entrySet()) {
                                            if (valP1.getKey().equals(valP2.getKey())) {
                                                int sumP1 = playerTotalSkillz(playerRooster, player1);
                                                int sumP2 = playerTotalSkillz(playerRooster, player2);
                                                if (sumP1 > sumP2) {
                                                    playerRooster.remove(player2);
                                                } else if (sumP1 < sumP2) {
                                                    playerRooster.remove(player1);
                                                }
                                                break loop;
                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }
//                    String[] fight = input.split("\\s+vs\\s+");
//                    String playerOne = fight[0];
//                    String playerTwo = fight[1];
//                    if (!playerOne.equals(playerTwo) && playerInfo.containsKey(playerOne) && playerInfo.containsKey(playerTwo)) {
//                        int totalPointsPlayerOne = 0;
//                        int totalPointsPlayerTwo = 0;
//                        for (Map.Entry<String, Integer> playerOneEntry : playerInfo.get(playerOne).entrySet()) {
//                            for (Map.Entry<String, Integer> playerTwoEntry : playerInfo.get(playerTwo).entrySet()) {
//                                if (playerOneEntry.getKey().equals(playerTwoEntry.getKey())) {
//                                    totalPointsPlayerOne += playerOneEntry.getValue();
//                                    totalPointsPlayerTwo += playerTwoEntry.getValue();
                }
            }
            input = scanner.nextLine();
        }
        Map<String, Integer> playersTotalSkill = new HashMap<>();

        for (Map.Entry<String, Map<String, Integer>> entry : playerRooster.entrySet()) {
            for (Map.Entry<String, Integer> value : entry.getValue().entrySet()) {
                playersTotalSkill.putIfAbsent(entry.getKey(), 0);
                playersTotalSkill.put(entry.getKey(), playersTotalSkill.get(entry.getKey()) + value.getValue());
            }
        }

        playersTotalSkill.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(p -> {
                    System.out.printf("%s: %d skill%n", p.getKey(), p.getValue());

//                    playerRooster.forEach((k, v) -> v.entrySet().stream()
//                            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
//                            .forEach(s -> System.out.printf("- %s <::> %d%n", s.getKey(), s.getValue())));
                    playerRooster.entrySet().stream().filter(player -> player.getKey().equals(p.getKey()))
                            .forEach(v -> {
                        v.getValue().entrySet().stream()
                                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                                .forEach(s -> System.out.printf("- %s <::> %d%n", s.getKey(), s.getValue()));
                    });

                });

//        playerInfo.entrySet().stream().sorted((player1, player2) ->
//                Integer.compare(player2.getValue().values().stream().mapToInt(Integer::intValue).sum(),
//                        player1.getValue().values().stream().mapToInt(Integer::intValue).sum())).forEach(entry -> {
//            System.out.printf("%s: %d skill%n", entry.getKey(), entry.getValue().values().stream()
//                    .mapToInt(Integer::intValue).sum());
//            entry.getValue().entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
//                            .thenComparing(Map.Entry.comparingByKey()))
//                    .forEach(value -> System.out.printf("- %s <::> %d%n", value.getKey(), value.getValue()));
//        });
    }

    private static int playerTotalSkillz(Map<String, Map<String, Integer>> playerRooster, String player) {
        int sum = 0;
        for (Map.Entry<String, Map<String, Integer>> entry : playerRooster.entrySet()) {
            if (entry.getKey().equals(player)) {
                for (Map.Entry<String, Integer> value : entry.getValue().entrySet()) {
                    sum += value.getValue();
                }
            }

        }
        return sum;
    }
}
