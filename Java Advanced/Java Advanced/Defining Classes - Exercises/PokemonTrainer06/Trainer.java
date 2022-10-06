package PokemonTrainer06;

import java.util.List;

public class Trainer {
    private final String name;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer(String name, int badges, List<Pokemon> pokemons) {
        this.name = name;
        this.badges = badges;
        this.pokemons = pokemons;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.badges, this.pokemons.size());
    }
}
