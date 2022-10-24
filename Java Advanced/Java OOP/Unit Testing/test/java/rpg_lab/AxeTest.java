package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {

    // Arrange
    // Act
    // Assert

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;

    private Dummy dummy;
    private Axe axe;
    private Axe brokenAxe;

    @Before
    public void setUp() {
        this.dummy = new Dummy(100, 100);
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.brokenAxe = new Axe(AXE_ATTACK, 0);
    }

    @Test
    public void testIfWeaponLosesDurabilityAfterAttack() {


        this.axe.attack(this.dummy);
        Assert.assertEquals(AXE_ATTACK - 1, this.axe.getDurabilityPoints());
    }

    @Test (expected = IllegalStateException.class)
    public void testAxeAttackIfBroken() {
        this.brokenAxe.attack(this.dummy);
    }

}