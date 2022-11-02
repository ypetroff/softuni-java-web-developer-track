package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.INVALID_GUN;
import static CounterStriker.utils.CheckIntegerValidity.isNotNegative;
import static CounterStriker.utils.CheckStringValidity.isValid;

public abstract class PlayerImpl implements Player {

    private String username;
    private int health;
    private int armor;
    private Gun gun;

    public PlayerImpl(String username, int health, int armor, Gun gun) {
        setUsername(username);
        setHealth(health);
        setArmor(armor);
        setGun(gun);
    }

    private void setUsername(String username) {
        isValid(username, "player");
        this.username = username;
    }

    private void setHealth(int health) {
        isNotNegative(health, "health");
        this.health = health;
    }

    private void setArmor(int armor) {
        isNotNegative(armor, "armor");
        this.armor = armor;
    }


    public void setGun(Gun gun) {

        if(gun == null) {
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public void takeDamage(int points) {
        int decreaseHealth = points > this.getArmor() ? points - this.getArmor() : 0;
        this.setArmor(Math.max(this.getArmor() - points, 0));
        this.setHealth(Math.max(this.getHealth() - decreaseHealth, 0));
    }

    @Override
    public String toString() {

        return String.format(": %s%n" +
                "--Health: %d%n" +
                "--Armor: %d%n" +
                "--Gun: %s", this.username, this.health, this.armor, this.gun.getName());
    }
}
