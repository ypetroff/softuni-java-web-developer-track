package halfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PlayerTests {

    private Player alivePlayer;
    private Player deadPlayer;

    @Before
    public void setup() {
        alivePlayer = new Player("Dani", 100);
        deadPlayer = new Player("Pesho", 0);
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testGetGuns() {
        alivePlayer.getGuns().clear();
    }

    @Test (expected = IllegalStateException.class)
    public void testTakeDamagePlayerIsDead() {
        deadPlayer.takeDamage(100);
    }

    @Test
    public void testTakeDamageHealthLessThanZero() {
        alivePlayer.takeDamage(101);
        assertEquals(0, alivePlayer.getHealth());
    }

    @Test
    public void testTakeDamageHealthIsNotNegative() {
        alivePlayer.takeDamage(1);
        assertEquals(99, alivePlayer.getHealth());
    }

    @Test (expected = NullPointerException.class)
    public void testAddGunThrowsException() {
        alivePlayer.addGun(null);
    }

    @Test
    public void testAddGunToCollection() {
        Gun gun = new Gun("Bazooka", 1);
        alivePlayer.addGun(gun);
        assertEquals(1, alivePlayer.getGuns().size());
        assertTrue(alivePlayer.getGuns().contains(gun));
    }

    @Test
    public void testRemoveGun() {
        Gun gun = new Gun("Bazooka", 1);
        alivePlayer.addGun(gun);
        alivePlayer.removeGun(gun);
        assertEquals(0, alivePlayer.getGuns().size());
    }

    @Test
    public void testGetGunReturnsRequestedGun() {
        Gun gun = new Gun("Bazooka", 1);
        alivePlayer.addGun(gun);
        assertEquals(gun, alivePlayer.getGun(gun.getName()));
    }

    @Test (expected = NullPointerException.class)
    public void testSetUsernameThrowsExceptionWhenNameIsNull() {
        Player player = new Player(null, 100);
    }

    @Test (expected = NullPointerException.class)
    public void testSetUsernameThrowsExceptionWhenNameIsLessThanOneSymbol() {
        Player player = new Player("", 100);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetHealthThrowsExceptionWhenHealthIsLessThanZero() {
        Player player = new Player("Gosho", -100);
    }

    @Test
    public void testCreatePlayerAsExpected() {
        Player player = new Player("Gosho", 100);
        assertEquals("Gosho", player.getUsername());
        assertEquals(100, player.getHealth());
    }
}
