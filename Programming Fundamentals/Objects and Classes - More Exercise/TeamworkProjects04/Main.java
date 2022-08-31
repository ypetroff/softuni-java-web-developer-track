package TeamworkProjects04;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int teamsToRegister = Integer.parseInt(scanner.nextLine());

        List<Team> teamsList = new ArrayList<>();

        for (int i = 0; i < teamsToRegister; i++) {
            String[] newTeam = scanner.nextLine().split("-");
            String creator = newTeam[0];
            String teamName = newTeam[1];

            if (teamsList.stream()
                    .anyMatch(p -> p.getName().equals(teamName))) {
                System.out.printf("Team %s was already created!%n", teamName);
            } else if (teamsList.stream()
                    .anyMatch(p -> p.getCreator().equals(creator))) {
                System.out.printf("%s cannot create another team!%n", creator);
            } else {
                    Team team = new Team();
                    team.setCreator(creator);
                    team.setName(teamName);
                    teamsList.add(team);
                    System.out.printf("Team %s has been created by %s!%n", teamName, creator);
            }
        }

        String newData = scanner.nextLine();
        while (!newData.equals("end of assignment")) {

            String[] memberInfo = newData.split("->");
            String candidate = memberInfo[0];
            String team = memberInfo[1];

            if (teamsList.stream().noneMatch(p -> p.getName().equals(team))) {
                System.out.printf("Team %s does not exist!%n", team);
            } else if (teamsList.stream()
                    .anyMatch(p -> p.getCreator().equals(candidate)) ||
                    teamsList.stream()
                            .flatMap(p -> p.getMembers().stream())
                            .anyMatch(p -> p.equals(candidate))) {
                System.out.printf("Member %s cannot join team %s!%n", candidate, team);
            } else {
                IntStream.range(0,teamsList.size())
                        .filter(i -> teamsList.get(i).getName().equals(team))
                        .forEach(i -> teamsList.get(i).getMembers().add(candidate));
            }
            newData = scanner.nextLine();
            }
        teamsList.sort(Comparator.comparing(Team::countOfMembers).reversed().thenComparing(Team::getName));
        IntStream.range(0, teamsList.size()).filter(i -> !teamsList.get(i).getMembers().isEmpty())
                .forEach(i ->
                {
                    System.out.printf("%s%n", teamsList.get(i).getName());
                    System.out.printf(" - %s%n", teamsList.get(i).getCreator());
                    teamsList.forEach(members -> members.getMembers().sort(String::compareTo));
                    teamsList.get(i).getMembers().forEach(p-> System.out.printf("-- %s%n", p));
                });

        System.out.println("Teams to disband:");
        teamsList.stream().filter(p -> p.getMembers().isEmpty())
                .forEach(teamToBeDisband -> System.out.printf("%s%n", teamToBeDisband.getName()));


        }
    }
