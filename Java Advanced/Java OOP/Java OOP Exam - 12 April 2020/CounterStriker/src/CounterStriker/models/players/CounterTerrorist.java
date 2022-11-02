package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

public class CounterTerrorist extends PlayerImpl{
    public CounterTerrorist(String username, int health, int armor, Gun gun) {
        super(username, health, armor, gun);
    }

    @Override
    public String toString() {
        return String.format("%s%s", this.getClass().getSimpleName(), super.toString());
    }
}
