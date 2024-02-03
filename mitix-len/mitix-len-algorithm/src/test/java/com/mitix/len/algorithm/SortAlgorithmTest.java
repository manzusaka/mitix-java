package com.mitix.len.algorithm;

import com.mitix.len.algorithm.sort.SortAlgorithm;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 排序测试
 *
 * @author oldflame-jm
 * @since 1.0.0
 */

public class SortAlgorithmTest {

    @Test
    public void testBubbleSort() {
        int[] array = {8, 22, 79, 35, 66, 54, 111, 23, 87, 22, 110, 90};
        SortAlgorithm sortAlgorithm = new SortAlgorithm();
        int[] result = sortAlgorithm.bubbleSort(array);
        Arrays.sort(array);
        Assert.assertArrayEquals("bubble sort error,the expecteds is " + array.toString() + " by actuals is " + result.toString(), array, result);
    }


    @Test
    public void testSelectionSort() {
        int[] array = {8, 22, 79, 35, 66, 54, 111, 23, 87, 22, 110, 90};
        SortAlgorithm sortAlgorithm = new SortAlgorithm();
        int[] result = sortAlgorithm.selectionSort(array);
        Arrays.sort(array);
        Assert.assertArrayEquals("selection sort error,the expecteds is " + array.toString() + " by actuals is " + result.toString(), array, result);
    }


    @Test
    public void testInsertSort() {
        int[] array = {8, 22, 79, 35, 66, 54, 111, 23, 87, 22, 110, 90};
        SortAlgorithm sortAlgorithm = new SortAlgorithm();
        int[] result = sortAlgorithm.insertSort(array);
        Arrays.sort(array);
        Assert.assertArrayEquals("insert sort error,the expecteds is " + array.toString() + " by actuals is " + result.toString(), array, result);
    }

    @Test
    public void testQuickSort() {
        int[] array = {8, 22, 79, 35, 66, 54, 111, 23, 87, 22, 110, 90};
        SortAlgorithm sortAlgorithm = new SortAlgorithm();
        int[] result = sortAlgorithm.quickSort(array);
        Arrays.sort(array);
        Assert.assertArrayEquals("quick sort error,the expecteds is " + array.toString() + " by actuals is " + result.toString(), array, result);
    }
}
