package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private static final Integer[] NUMBERS = {1, 2, 3 ,4};
    private static final int NUMBER_TOO_BIG = 17;
    private static final int NUMBER_TOO_SMALL = 0;

    Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void testDatabaseConstructorInitializing() {
        Assert.assertEquals(database.getElements().length, NUMBERS.length);
    }

    @Test
    public void testArrayElementsEqualsDatabaseElements () {
        for (int i = 0; i < NUMBERS.length; i++) {
            Assert.assertEquals(database.getElements()[i], NUMBERS[i]);
        }
    }
    /// or test Arrays -> assertArrayEquals

    @Test (expected = OperationNotSupportedException.class)
    public void testConstructorThrowsONSExceptionMoreThan16Elements() throws OperationNotSupportedException {
        Integer[] largeArray = new Integer[NUMBER_TOO_BIG];

        new Database(largeArray);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testConstructorThrowsONSExceptionSizeLessThan1() throws OperationNotSupportedException {
        Integer[] smallArray = new Integer[NUMBER_TOO_SMALL];
        new Database(smallArray);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddWithNullThrowsONSException() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddNumberAtTheEndOfDB() throws OperationNotSupportedException {
        database.add(NUMBERS.length);
        Assert.assertEquals(database.getElements().length, NUMBERS.length + 1);
        Assert.assertEquals((int)database.getElements()[database.getElements().length - 1], NUMBERS.length);
    }

    @Test
    public void testRemoveLastElementFromDB() throws OperationNotSupportedException {
        database.remove();
        Assert.assertEquals(database.getElements()[database.getElements().length - 1], NUMBERS[NUMBERS.length - 2]);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testRemoveElementThrowsONSE() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }
}