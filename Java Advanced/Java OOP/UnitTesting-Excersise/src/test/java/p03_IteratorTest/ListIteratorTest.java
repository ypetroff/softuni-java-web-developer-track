package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ListIteratorTest {

    private static final String[] TEST_ARRAY_MULTIPLE_ELEMENTS = {"A", "B", "C"};
    private static final String[] TEST_ARRAY_SINGLE_ELEMENT = {"Z"};
    private static final String[] EMPTY_TEST_ARRAY = null;

    ListIterator listIterator;
    ListIterator listIteratorWithSingleElement;


    @Before
    public void setup() throws OperationNotSupportedException {
        listIterator = new ListIterator(TEST_ARRAY_MULTIPLE_ELEMENTS);
        listIteratorWithSingleElement = new ListIterator(TEST_ARRAY_SINGLE_ELEMENT);
    }

    @Test
    public void testCreateNewListFromConstructor() throws OperationNotSupportedException {
        new ListIterator(TEST_ARRAY_MULTIPLE_ELEMENTS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCreateNewNullListThrowONSE() throws OperationNotSupportedException {
        new ListIterator(EMPTY_TEST_ARRAY);
    }

    @Test
    public void testHasNext() {
        while (listIterator.hasNext()) {
            Assert.assertTrue(listIterator.hasNext());
            listIterator.move();
        }
        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void testMove() throws OperationNotSupportedException {
        Assert.assertTrue(listIterator.move());
        Assert.assertTrue(listIterator.move());
        Assert.assertFalse(listIterator.move());
    }

    @Test (expected = IllegalStateException.class)
    public void printThrowsException() throws OperationNotSupportedException {

       new ListIterator().print();

    }

    @Test
    public void printElement() {
        int index = 0;
        while (listIterator.hasNext()) {
            Assert.assertEquals(TEST_ARRAY_MULTIPLE_ELEMENTS[index++], listIterator.print());
            listIterator.move();
        }
    }

}