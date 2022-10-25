package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BubbleTest {

    @Test
    public void testBubbleSort() {
        int[] initialArray = {23, 13, -8};
        int[] sortedArray = {-8, 13, 23};
        Bubble.sort(initialArray);
        Assert.assertArrayEquals(sortedArray, initialArray);
    }

}