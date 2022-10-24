package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class HeroTest {

    private static final int EXPERIENCE = 50;

    private static class FakeAxe implements Weapon {


        @Override
        public int getAttackPoints() {
            return 0;
        }

        @Override
        public int getDurabilityPoints() {
            return 0;
        }

        @Override
        public void attack(Target target) {

        }
    }

    private static class FakeDeadTarget implements Target {

        @Override
        public int getHealth() {
            return 0;
        }

        @Override
        public void takeAttack(int attackPoints) {

        }

        @Override
        public int giveExperience() {
            return EXPERIENCE;
        }

        @Override
        public boolean isDead() {
            return true;
        }
    }

    private static class FakeAliveTarget implements Target {

        @Override
        public int getHealth() {
            return 50;
        }

        @Override
        public void takeAttack(int attackPoints) {

        }

        @Override
        public int giveExperience() {
            return EXPERIENCE;
        }

        @Override
        public boolean isDead() {
            return false;
        }
    }

    private Hero hero;

    @Before
    public void setUp() {

        Weapon mockedWeapon = Mockito.mock(Weapon.class); // without mockito
        this.hero = new Hero("Vesi", mockedWeapon); //  this.hero = new Hero("Vesi", new FakeAxe());
    }


    @Test
    public void testUponTargetKillHeroGetsExperience() {

        Target mockedTarget = Mockito.mock(Target.class); // without mockito
        Mockito.when(mockedTarget.isDead()).thenReturn(true); // without mockito
        Mockito.when(mockedTarget.giveExperience()).thenReturn(EXPERIENCE);
        hero.attack(mockedTarget); //hero.attack(new FakeDeadTarget());
       Assert.assertEquals(EXPERIENCE, hero.getExperience());

    }

    @Test
    public void testAfterAttackTargetIsAliveNoExperienceForHero() {
        Target mockedTarget = Mockito.mock(Target.class); // without mockito
        Mockito.when(mockedTarget.isDead()).thenReturn(false);
        Mockito.when(mockedTarget.giveExperience()).thenReturn(EXPERIENCE);
        hero.attack(mockedTarget); // hero.attack(new FakeAliveTarget());
        Assert.assertEquals(0, hero.getExperience());
    }

}