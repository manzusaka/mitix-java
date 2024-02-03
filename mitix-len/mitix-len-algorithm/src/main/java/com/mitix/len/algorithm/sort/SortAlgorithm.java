package com.mitix.len.algorithm.sort;


import java.util.Arrays;

/**
 * @author oldflame-jm
 * @since 1.0.0
 * 排序算法
 */
public class SortAlgorithm {
    /**
     * 进行冒泡排序
     *
     * @param sourceArray
     * @return
     */
    public int[] bubbleSort(int[] sourceArray) {
        int[] copyArray = Arrays.copyOf(sourceArray, sourceArray.length);
        int length = copyArray.length;
        //数组为0->length-1  比较length[length-2]==length[length-1]
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (copyArray[j] > copyArray[j + 1]) {
                    int temp = copyArray[j];
                    copyArray[j] = copyArray[j + 1];
                    copyArray[j + 1] = temp;
                }
            }
        }
        return copyArray;
    }

    /**
     * 选择排序
     *
     * @param sourceArray
     * @return
     */
    public int[] selectionSort(int[] sourceArray) {
        int[] copyArray = Arrays.copyOf(sourceArray, sourceArray.length);
        int length = copyArray.length;
        for (int i = 0; i < length; i++) {
            int minPos = i;
            int minVal = copyArray[i];
            for (int j = i + 1; j < length; j++) {
                if (copyArray[j] < minVal) {
                    minPos = j;
                    minVal = copyArray[j];
                }
            }
            if (i != minPos) {
                int temp = copyArray[i];
                copyArray[i] = minVal;
                copyArray[minPos] = temp;
            }
        }
        return copyArray;
    }

    /**
     * 插入排序
     *
     * @param sourceArray
     * @return
     */
    public int[] insertSort(int[] sourceArray) {
        int[] copyArray = Arrays.copyOf(sourceArray, sourceArray.length);
        int length = copyArray.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j > 0; j--) {
                //后面的数比前面的要小，进行换位插队
                //第一个开始比,开始换位
                if (copyArray[j] < copyArray[j - 1]) {
                    int temp = copyArray[j - 1];
                    copyArray[j - 1] = copyArray[j];
                    copyArray[j] = temp;
                } else {
                    break;
                }
            }
        }
        return copyArray;
    }

    /**
     * 快速排序
     *
     * @param sourceArray
     * @return
     */
    public int[] quickSort(int[] sourceArray) {
        int[] copyArray = Arrays.copyOf(sourceArray, sourceArray.length);
        int length = copyArray.length;
        doQuickSort(copyArray, 0, length - 1);
        return copyArray;
    }

    private void doQuickSort(int[] copyArray, int start, int end) {
        int stand = copyArray[start];
        int low = start;
        int high = end;
        while (low < high) {
            while (low < high && copyArray[high] >= stand) {
                high--;
            }
            copyArray[low] = copyArray[high];
            while (high > low && copyArray[low] < stand) {
                low++;
            }
            copyArray[high] = copyArray[low];
        }
        //把数据写回去
        copyArray[high] = stand;
        if (start < low) {
            doQuickSort(copyArray, start, low - 1);
        }
        if (high < end) {
            doQuickSort(copyArray, high + 1, end);
        }
    }
}
