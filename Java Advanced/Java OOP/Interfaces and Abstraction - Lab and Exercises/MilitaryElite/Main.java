package MilitaryElite;

import MilitaryElite.entities.*;
import MilitaryElite.enums.Corps;
import MilitaryElite.interfaces.*;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Map<Integer, Private> soldiersById = new LinkedHashMap<>();
    private static final Map<Integer, Spy> spiesById = new LinkedHashMap<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        while (!(input = scanner.nextLine()).equals("End")) {

            Private soldier = createSoldier(input);

            if (soldier != null) {
                soldiersById.put(soldier.getId(), soldier);
            }
        }

        soldiersById.values().stream()
                .filter(x -> x.getClass().getSimpleName().equals("PrivateImpl"))
                .map(Private::toString)
                .forEach(System.out::println);

        spiesById.values().stream().map(Spy::toString).forEach(System.out::println);

        soldiersById.values().stream()
                .filter(x -> x.getClass().getSimpleName().equals("LieutenantGeneralImpl"))
                .forEach(ltG -> System.out.printf("%s%n", ltG.toString()));

        soldiersById.values().stream()
                .filter(x -> x.getClass().getSimpleName().equals("EngineerImpl"))
                .map(z -> z.toString())
                .forEach(System.out::println);

        soldiersById.values().stream()
                .filter(x -> x.getClass().getSimpleName().equals("CommandoImpl"))
                .forEach(ltG -> System.out.printf("%s%n", ltG.toString()));
    }

    private static Private createSoldier(String input) {
        String[] tokens = input.split("\\s+");

        String type = tokens[0];

        Private soldier;
        switch (type) {

            case "Private":
                soldier = new PrivateImpl(Integer.parseInt(tokens[1]), tokens[2], tokens[3], Double.parseDouble(tokens[4]));
                break;
            case "LieutenantGeneral":
                soldier = createLieutenantGeneral(tokens);
                break;
            case "Engineer":
                soldier = createEngineer(tokens);
                break;
            case "Commando":
                soldier = createCommando(tokens);
                break;
            case "Spy":
                Spy spy = new SpyImpl(Integer.parseInt(tokens[1]), tokens[2], tokens[3], tokens[4]);
                spiesById.put(spy.getId(), spy);

            default:
                soldier = null;
                break;

        }
        return soldier;
    }

    private static Private createLieutenantGeneral(String[] tokens) {

        LieutenantGeneral lieutenantGeneral = new LieutenantGeneralImpl(Integer.parseInt(
                tokens[1]),
                tokens[2],
                tokens[3],
                Double.parseDouble(tokens[4]));

        for (int i = 5; i < tokens.length; i++) {
            lieutenantGeneral.addPrivate(soldiersById.get(Integer.parseInt(tokens[i])));
        }

        return lieutenantGeneral;
    }

    private static Private createEngineer(String[] tokens) {

        String corps = tokens[5];

        if (tokens[5].equals("Airforces") || tokens[5].equals("Marines")) {
            Engineer engineer = new EngineerImpl(Integer.parseInt(
                    tokens[1]),
                    tokens[2],
                    tokens[3],
                    Double.parseDouble(tokens[4]),
                    Corps.valueOf(corps.toUpperCase(Locale.ROOT)));

            for (int i = 6; i < tokens.length; i += 2) {
                String partName = tokens[i];
                int hoursWorked = Integer.parseInt(tokens[i + 1]);

                Repair repair = new RepairImpl(partName, hoursWorked);
                engineer.addRepair(repair);
            }

            return engineer;
        }
        return null;
    }

    private static Private createCommando(String[] tokens) {
        String corps = tokens[5];

        if (tokens[5].equals("Airforces") || tokens[5].equals("Marines")) {
            Commando commando = new CommandoImpl(Integer.parseInt(
                    tokens[1]),
                    tokens[2],
                    tokens[3],
                    Double.parseDouble(tokens[4]),
                    Corps.valueOf(corps));

            for (int i = 6; i < tokens.length; i += 2) {
                String codeName = tokens[i];
                String status = tokens[i + 1];

                if (!status.equals("inProgress") && !status.equals("finished")) {
                    continue;
                }

                Mission mission = new MissionImpl(
                        codeName,
                        status.equals("inProgress")
                                ? MissionImpl.Status.IN_PROGRESS
                                : MissionImpl.Status.FINISHED);
                commando.addMission(mission);

            }

            return commando;
        }
        return null;
    }

}
