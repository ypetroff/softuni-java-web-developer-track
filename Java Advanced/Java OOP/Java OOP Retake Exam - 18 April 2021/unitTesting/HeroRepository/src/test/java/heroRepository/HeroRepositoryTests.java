package heroRepository;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class HeroRepositoryTests {

    private final static String NAME_1 = "Gogo";
    private final static String NAME_2 = "Dimo";
    private final static int LEVEL_1 = 1;
    private final static int LEVEL_2 = 2;


    private HeroRepository heroRepository;
    private Hero hero_1;
    private Hero hero_2;


    @Before
    public void setup() {
        heroRepository = new HeroRepository();
        hero_1 = new Hero(NAME_1, LEVEL_1);
        hero_2 = new Hero(NAME_2, LEVEL_2);
    }

    @Test
    public void testGetCountWorksCorrectly() {
        heroRepository.create(hero_1);
        assertEquals(1, heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testCreateThrowsExceptionWhenHeroIsNull() {
        heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateThrowsExceptionWhenAddingHeroWithTheSameName() {
        heroRepository.create(hero_1);
        heroRepository.create(hero_1);
    }

    @Test
    public void testCreateWorksCorrectly() {
        String actualOutput = heroRepository.create(hero_1);
        String expectedOutput = String.format("Successfully added hero %s with level %d",
                hero_1.getName(), hero_1.getLevel());

        assertEquals(expectedOutput, actualOutput);
    }

    @Test (expected = NullPointerException.class)
    public void testRemoveThrowsExceptionWhenHeroNameIsNull() {
        heroRepository.remove(null);
    }

    @Test (expected = NullPointerException.class)
    public void testRemoveThrowsExceptionWhenHeroNameIsEmptyString() {
        heroRepository.remove("  ");
    }

    @Test
    public void testRemoveReturnsFalseWhenHeroIsNotInTheRepository() {
        assertFalse(heroRepository.remove(hero_1.getName()));
    }

    @Test
    public void testRemoveReturnsTrueWhenHeroIsNotInTheRepository() {
        heroRepository.create(hero_1);
        assertTrue(heroRepository.remove(hero_1.getName()));
    }

    @Test
    public void testGetHeroWithHighestLevelReturnsCorrectHero() {
        heroRepository.create(hero_1);
        heroRepository.create(hero_2);
        assertEquals(hero_2, heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHeroWithHighestLevelReturnsNullWhenRepositoryIsEmpty() {
        assertNull(heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHeroReturnsNullWhenHeroIsNotInTheRepository() {
        assertNull(heroRepository.getHero("Machine"));
    }

    @Test
    public void testGetHeroReturnsTheRequestedHeroWhenTheRepositoryContainsIt() {
        heroRepository.create(hero_2);
        Hero requestedHero = heroRepository.getHero(hero_2.getName());
        assertEquals(hero_2.getName(), requestedHero.getName());
        assertEquals(hero_2.getLevel(), requestedHero.getLevel());
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testGetHeroesIsUnmodifiableCollection() {
       heroRepository.getHeroes().clear();
    }

    @Test
    public void testGetHeroesReturnsCorrectHeroes() {
        heroRepository.create(hero_1);
        heroRepository.create(hero_2);

        Collection<Hero> heroes = heroRepository.getHeroes();
        assertEquals(2, heroes.size());
        assertTrue(heroes.contains(hero_1));
        assertTrue(heroes.contains(hero_2));
    }
}
