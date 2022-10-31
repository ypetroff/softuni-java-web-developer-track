package aquarium;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class AquariumTests {

    private final static String NAME = "FishHeaven";
    private final static int CAPACITY = 1;
    private final static Fish FISH_1 = new Fish("FlashyFlash");
    private final static Fish FISH_2 = new Fish("DorkyDork");

    private Aquarium aquarium;
    private List<Fish> fish;

    @Before
    public void setup() {
        aquarium = new Aquarium(NAME, CAPACITY);
        fish = new ArrayList<>();
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameThrowsExceptionWhenNameIsNull() {
        aquarium = new Aquarium(null, CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameThrowsExceptionWhenNameIsEmptyString() {
        aquarium = new Aquarium(" ", CAPACITY);
    }

    @Test //This tests both setName and setCapacity in the case when all provided values are correct
    public void testCreateAquariumWorksCorrectly() {
        aquarium = new Aquarium(NAME, CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityThrowsExceptionWhenValueIsLessThanZero() {
        aquarium = new Aquarium(NAME, -3);
    }

    @Test
    public void testCountReturnsTheCorrectNumberOfFishInTheAquarium() {
        fillAquariumWithOneFish();
        fish.add(FISH_1);
        assertEquals(fish.size(), aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFishExceedsCapacityThrowsException() {
        fillAquariumWithOneFish();
        aquarium.add(FISH_2);
    }

    @Test
    public void testAddSuccessfullyAddsAFish() {
        aquarium = new Aquarium(NAME, CAPACITY);
        assertEquals(fish.size(), aquarium.getCount());
        aquarium.add(FISH_1);
        fish.add(FISH_1);
        assertEquals(fish.size(), aquarium.getCount());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveThrowsExceptionWhenFishNameIsNotPartOfTheCollection() {
        fillAquariumWithOneFish();
        aquarium.remove(FISH_2.getName());
    }

    @Test
    public void testRemoveWorksCorrectly() {
        fillAquariumWithOneFish();
        aquarium.remove(FISH_1.getName());
        assertEquals(0, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellFishThrowsExceptionWhenFishNameISNotPartOfTheCollection() {
        fillAquariumWithOneFish();
        aquarium.sellFish(FISH_2.getName());
    }

    @Test
    public void testSellFishWorksCorrectly() {
        fillAquariumWithOneFish();
        Fish soldFish = aquarium.sellFish(FISH_1.getName());
        soldFish.setAvailable(false);
        assertEquals(FISH_1, soldFish);
        assertFalse(soldFish.isAvailable());
    }

    @Test
    public void testSoldFish() {
        aquarium.add(FISH_1);
        assertFalse(aquarium.sellFish(FISH_1.getName()).isAvailable());
    }

    @Test
    public void testReportReturnsStringAboutTheFishInTheAquarium() {
        fillAquariumWithOneFish();
        fish.add(FISH_1);

        String names = this.fish.stream().map(Fish::getName).collect(Collectors.joining(", "));
        String expectedOutput = String.format("Fish available at %s: %s", aquarium.getName(), names);
        String actualOutput = aquarium.report();

        assertEquals(expectedOutput, actualOutput);

    }

    private void fillAquariumWithOneFish() {

        aquarium.add(FISH_1);
    }

}

