package PokemonTrainer06;

import java.util.Objects;

public class Pokemon {
    private final String name;
    private final String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getElement() {
        return element;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return element.equals(pokemon.element);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element);
    }
}
