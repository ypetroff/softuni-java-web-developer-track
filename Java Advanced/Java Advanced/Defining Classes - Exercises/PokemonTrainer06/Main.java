package PokemonTrainer06;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Pokemon>> trainersPokemon = new LinkedHashMap<>();

        String command;
        while (!(command = scanner.nextLine()).equals("Tournament")) {

            catchPokemons(trainersPokemon, command);
        }
        List<Trainer> trainers = new ArrayList<>();
        trainersPokemon.forEach((key, value) -> {
            Trainer trainer = new Trainer(key, 0, value);
            trainers.add(trainer);
        });

        while (!(command = scanner.nextLine()).equals("End")) {

            earnBadge(command, trainers);
            loseHP(command, trainers);
            removePokemonsWithNoHP(trainers);
        }

        trainers.stream()
                .sorted(Comparator.comparingInt(Trainer::getBadges).reversed())
                .map(Trainer::toString).forEach(System.out::println);

    }

    private static void catchPokemons(Map<String, List<Pokemon>> trainersPokemon, String command) {
        String[] captureData = command.split("\\s+");
        String trainerName = captureData[0];
        String pokemonName = captureData[1];
        String pokemonElement = captureData[2];
        int pokemonHealth = Integer.parseInt(captureData[3]);
        Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
        trainersPokemon.putIfAbsent(trainerName, new ArrayList<>());
        trainersPokemon.get(trainerName).add(pokemon);
    }

    private static void earnBadge(String command, List<Trainer> trainers) {
        trainers.stream().filter(t -> t.getPokemons().stream()
                        .anyMatch(p -> p.getElement().equals(command)))
                .forEach(trainer -> trainer.setBadges(trainer.getBadges() + 1));
    }

    private static void loseHP(String command, List<Trainer> trainers) {
        trainers.stream().filter(t -> t.getPokemons().stream()
                        .noneMatch(p -> p.getElement().equals(command)))
                .forEach(trainer -> trainer.getPokemons()
                        .forEach(p -> p.setHealth(p.getHealth() - 10)));
    }

    private static void removePokemonsWithNoHP(List<Trainer> trainers) {
        trainers.forEach(t -> t.getPokemons().removeIf(p -> p.getHealth() <= 0));
    }
}
