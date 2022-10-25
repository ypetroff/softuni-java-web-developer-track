package p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {

    private static final int FIRST_ELEMENT = 23;
    private static final int SECOND_ELEMENT = 31;
    private static final int THIRD_ELEMENT = 88;
    private static final int FORTH_ELEMENT = 101;
    private static final int FIFTH_ELEMENT = 0;


    private static CustomLinkedList<Integer> numbers;

    @Before
    public void setup() {
        numbers = new CustomLinkedList<>();
        numbers.add(FIRST_ELEMENT);
        numbers.add(SECOND_ELEMENT);
        numbers.add(THIRD_ELEMENT);
        numbers.add(FORTH_ELEMENT);
    }

    @Test
    public void testConstructorSetsCorrectValue() {
        numbers = new CustomLinkedList<>();
        assertFalse(numbers.contains(null));
    }

    @Test
    public void testAddMethodAddsElement() {
        assertEquals(FIRST_ELEMENT, (long) numbers.get(0));
        assertEquals(SECOND_ELEMENT, (long) numbers.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetThrowsExceptionWhenIndexISOutOFBounds() {
        numbers = new CustomLinkedList<>();
        numbers.get(0);
    }

    @Test
    public void testRemoveAtDataAsExpected() {
        assertEquals(FORTH_ELEMENT, (long) numbers.removeAt(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtThrowsExceptionWhenIOB() {
        assertEquals(FORTH_ELEMENT, (long) numbers.removeAt(88));
    }

    @Test
    public void testRemoveCorrectElement() {
        assertEquals(2, numbers.remove(THIRD_ELEMENT));
    }

    @Test
    public void testRemoveReturnsNegativeForNonExistingElement() {
        assertEquals(-1, numbers.remove(FIFTH_ELEMENT));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAllElementsThrowExceptionForEmptyList() {

        while (true) {
            numbers.removeAt(0);
        }
    }

    @Test
    public void testIndexOfReturnsCorrectElement() {
        assertEquals(0, numbers.indexOf(23));
        assertEquals(3, numbers.indexOf(101));
    }

    @Test
    public void testSetReturnCorrectValue() {
        numbers.set(0, FIFTH_ELEMENT);
        assertEquals(FIFTH_ELEMENT, (long)numbers.get(0));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetThrowsExceptionWhenNoSuchIndex() {
        numbers.set(23, FIFTH_ELEMENT);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetThrowsExceptionWhenListIsEmpty() {
        numbers = new CustomLinkedList<>();
        numbers.set(0, FIFTH_ELEMENT);
    }

}