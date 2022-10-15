package FootballTeamGenerator05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Team> teams = new HashMap<>();

        String command;
        while (!(command = reader.readLine()).equals("END")) {

            String[] tokens = command.split(";");
            String teamName = tokens[1];

                switch (tokens[0]) {
                    case "Team":

                        createTeam(teams, teamName);

                        break;

                    case "Add":

                        addPlayer(teams, tokens, teamName);

                        break;

                    case  "Remove":

                        removePlayer(teams.get(teamName), tokens[2]);

                        break;

                    case "Rating":

                        printRating(teams, teamName);
                }

        }
    }

    private static void createTeam(Map<String, Team> teams, String token) {
        try {

            Team team = new Team(token);
            teams.putIfAbsent(token, team);

        } catch (Exception exception) {

            System.out.println(exception.getMessage());

        }
    }

    private static void addPlayer(Map<String, Team> teams, String[] tokens, String teamName) {
        String playerName = tokens[2];

        if(!teams.containsKey(teamName)) {
            System.out.printf("Team %s does not exist.%n", teamName);
        } else {
            try {
                int[] intTokens = Arrays.stream(tokens).skip(3).mapToInt(Integer::parseInt).toArray();
                Player player = new Player(playerName, intTokens[0], intTokens[1],intTokens[2],intTokens[3], intTokens[4]);
                teams.get(teamName).addPlayer(player);
            }catch (Exception exception) {
                System.out.println(exception.getMessage());
            }

        }
    }

    private static void removePlayer(Team team, String playerName) {
        try {
            team.removePlayer(playerName);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printRating(Map<String, Team> teams, String teamName) {
        if(!teams.containsKey(teamName)) {
            System.out.printf("Team %s does not exist.%n", teamName);
        } else {
            System.out.printf("%s - %d%n", teamName, Math.round(teams.get(teamName).getRating()));
        }
    }
}
