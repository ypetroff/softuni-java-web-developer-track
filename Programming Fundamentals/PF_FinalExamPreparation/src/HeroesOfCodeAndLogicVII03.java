import java.util.*;

public class HeroesOfCodeAndLogicVII03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfHeroes = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> heroes = new TreeMap<>();

        for (int i = 0; i < numberOfHeroes; i++) {
            String[] heroStats = scanner.nextLine().split("\\s");
            String name = heroStats[0];
            int HP = Integer.parseInt(heroStats[1]);
            int MP = Integer.parseInt(heroStats[2]);
            heroes.put(name, Arrays.asList(HP, MP));
        }

        String commands;
        while (!"End".equalsIgnoreCase(commands = scanner.nextLine())) {
            String[] tokens = commands.split(" - ");

            switch (tokens[0]) {
                case "CastSpell":
                    castSpell(heroes, tokens[1], tokens[2], tokens[3]);
                    break;
                case "TakeDamage":
                    takeDamage(heroes, tokens[1], tokens[2], tokens[3]);
                    break;
                case "Recharge":
                    recharge(heroes, tokens[1], tokens[2]);
                    break;
                case "Heal":
                    heal(heroes, tokens[1], tokens[2]);
                    break;
            }
        }

        heroes.entrySet().stream().sorted((h1, h2) -> h2.getValue().get(0).compareTo(h1.getValue().get(0)))
                .forEach(hero -> System.out.printf("%s%n" +
                        "  HP: %d%n" +
                        "  MP: %d%n", hero.getKey(), hero.getValue().get(0), hero.getValue().get(1)));
    }

    private static void castSpell(Map<String, List<Integer>> heroes, String heroName, String MpNeeded, String spellName) {
        int manaRequired = Integer.parseInt(MpNeeded);
        if (manaRequired <= heroes.get(heroName).get(1)) {
            heroes.get(heroName).set(1, heroes.get(heroName).get(1) - manaRequired);
            System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, heroes.get(heroName).get(1));
        } else {
            System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
        }
    }

    private static void takeDamage(Map<String, List<Integer>> heroes, String heroName, String damageTaken, String attacker) {
        int damage = Integer.parseInt(damageTaken);
        if (damage < heroes.get(heroName).get(0)) {
            heroes.get(heroName).set(0, heroes.get(heroName).get(0) - damage);
            System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, heroes.get(heroName).get(0));
        } else {
            System.out.printf("%s has been killed by %s!%n", heroName, attacker);
            heroes.remove(heroName);
        }
    }

    private static void recharge(Map<String, List<Integer>> heroes, String heroName, String amountMP) {
        int manaPotion = Integer.parseInt(amountMP);
        int manaAfterRecharge = heroes.get(heroName).get(1) + manaPotion;
        if (manaAfterRecharge > 200) {
            manaPotion = 200 - heroes.get(heroName).get(1);
            manaAfterRecharge = 200;
        }
        heroes.get(heroName).set(1, manaAfterRecharge);
        System.out.printf("%s recharged for %s MP!%n", heroName, manaPotion);
    }

    private static void heal(Map<String, List<Integer>> heroes, String heroName, String amountHP) {
        int heal = Integer.parseInt(amountHP);
        int healthAfterHeal = heroes.get(heroName).get(0) + heal;
        if (healthAfterHeal > 100) {
            heal = 100 - heroes.get(heroName).get(0);
            healthAfterHeal = 100;
        }
        heroes.get(heroName).set(0, healthAfterHeal);
        System.out.printf("%s healed for %s HP!%n", heroName, heal);
    }
}
