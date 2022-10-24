package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.security.PublicKey;

import static org.junit.Assert.*;

public class DummyTest {

    private static final int DUMMY_HEALTH = 50;
    private static final int DUMMY_EXPERIENCE = 50;
    private static final int ATTACK = 10;

    Dummy dummy;
    Dummy deadDummy;

    @Before
    public void setUp() {
        dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
        deadDummy = new Dummy(0, DUMMY_EXPERIENCE);
    }

    @Test
    public void testDummyLosesHealthWhenAttacked() {

        dummy.takeAttack(ATTACK);
        Assert.assertEquals(DUMMY_HEALTH - ATTACK, dummy.getHealth());
    }

    @Test (expected = IllegalStateException.class)
    public void testDeadDummyThrowsException() {
        deadDummy.takeAttack(ATTACK);
    }

    @Test
    public void testDeadDummyCanGiveExperience() {
        int actualExperience = deadDummy.giveExperience();
        Assert.assertEquals(DUMMY_EXPERIENCE, actualExperience);
    }

     @Test (expected = IllegalStateException.class)
    public void testAliceDummyDontGiveExperience() {
        dummy.giveExperience();
     }

}