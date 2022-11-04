package computers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ComputerManagerTests {

    private static final Computer COMPUTER1 = new Computer("Dell", "XPS", 999.99);
    private static final Computer COMPUTER2 = new Computer("HP", "G8", 998.99);
    private static final Computer COMPUTER3 = new Computer("Lenovo", "V510", 978.99);


    private ComputerManager cm;
    private List<Computer> computers;
    private Computer computer;

    @Before
    public void setup() {
        cm = new ComputerManager();
        computers = new ArrayList<>();
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testGetComputersThrowsExceptionWhenModified() {
        cm.getComputers().clear();
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddComputerThrowsExceptionWhenComputerIsNull() {
        cm.addComputer(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddComputerThrowsExceptionWhenAddingTheSameComputerTwice() {
        cm.addComputer(COMPUTER1);
        cm.addComputer(COMPUTER1);
    }

    @Test
    public void testAddComputerCorrectly() {
        cm.addComputer(COMPUTER1);
        computers.add(COMPUTER1);

        assertEquals(computers.size(), cm.getCount());
        assertEquals(computers.get(0), cm.getComputer(COMPUTER1.getManufacturer(), COMPUTER1.getModel()));

        cm.addComputer(COMPUTER2);
        computers.add(COMPUTER2);

        assertEquals(computers.size(), cm.getCount());
        assertEquals(computers.get(1), cm.getComputer(COMPUTER2.getManufacturer(), COMPUTER2.getModel()));
    }

    @Test
    public void testGetCountReturnsCorrectNumberOfComputers() {
        addToComputers();
        addToCm();

        assertEquals(computers.size(), cm.getCount());
    }

    @Test
    public void testRemoveComputer() {
      cm.addComputer(COMPUTER1);
      cm.removeComputer(COMPUTER1.getManufacturer(), COMPUTER1.getModel());

      assertEquals(0, cm.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetComputerThrowsExceptionWhenManufacturerIsNull() {
        cm.getComputer(null, "test");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetComputerThrowsExceptionWhenModelIsNull() {
        cm.getComputer("null", null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetComputerThrowsExceptionWhenRemovingNonExistingComputer() {
        cm.getComputer(COMPUTER1.getManufacturer(), COMPUTER1.getModel());
    }

    @Test
    public void testGetComputerWorksCorrectly() {
        addToCm();
        Computer actualComputer = cm.getComputer(COMPUTER1.getManufacturer(), COMPUTER1.getModel());
        assertEquals(COMPUTER1, actualComputer);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetComputersByManufacturerThrowExceptionWhenManufacturerIsNull() {
        cm.getComputersByManufacturer(null);
    }

    @Test
    public void testGetComputersByManufacturer() {
        String requestedManufacturer = "Dell";
       addToCm();
       addToComputers();
        List<Computer> actualComputersByRequestedManufacturer =
                cm.getComputersByManufacturer(requestedManufacturer);
        long expectedNumberOfComputersByRequestedManufacturer =
                computers.stream().filter(c -> c.getManufacturer().equals(requestedManufacturer)).count();

        assertEquals(expectedNumberOfComputersByRequestedManufacturer,actualComputersByRequestedManufacturer.size());

        long incorrectlyAddedComputers =
                actualComputersByRequestedManufacturer.stream()
                        .filter(c -> !c.getManufacturer().equals(requestedManufacturer))
                        .count();

        assertEquals(0, incorrectlyAddedComputers);
    }


    private void addToComputers() {
        computers.add(COMPUTER1);
        computers.add(COMPUTER2);
        computers.add(COMPUTER3);
    }

    private void addToCm() {
        cm.addComputer(COMPUTER1);
        cm.addComputer(COMPUTER2);
        cm.addComputer(COMPUTER3);
    }
}