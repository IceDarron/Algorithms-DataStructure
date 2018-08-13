package com.iceDarron.algorithms.deepSort.impl;

import com.iceDarron.algorithms.deepSort.abstra.AbstraDeepSort;

public class FastSort extends AbstraDeepSort {

    /**
     * 快速排序
     * Author Darron
     * 2016.09.11
     * 快速排序首先找到一个基准，下面程序以第一个元素作为基准（pivot），然后先从右向左搜索，如果发现比pivot小，则和pivot交换，
     * 然后从左向右*搜索，如果发现比pivot大，则和pivot交换，一直到左边大于右边，此时pivot左边的都比它小，而右边的都比它大，
     * 此时pivot的位置就是排好序后**应该在的位置，此时pivot将数组划分为左右两部分，可以递归采用该方法进行。快排的交换使排序成为不稳定的。
     */
    @Override
    public void sort(int[] num) {
        quickSort(num, 0, num.length - 1);
    }

    private void quickSort(int[] num, int low, int high) {
        if (low < high) { //如果不加这个判断递归会无法退出导致堆栈溢出异常
            int middle = getMiddle(num, low, high);
            quickSort(num, 0, middle - 1);          //递归对低子表递归排序
            quickSort(num, middle + 1, high);        //递归对高子表递归排序
        }
    }

    private int getMiddle(int[] num, int low, int high) {
        int key = num[low];//基准元素，排序中会空出来一个位置
        while (low < high) {
            while (low < high && num[high] >= key) {//从high开始找比基准小的，与low换位置
                high--;
            }
            num[low] = num[high];
            num[high] = key;
            while (low < high && num[low] <= key) {//从low开始找比基准大,放到之前high空出来的位置上
                low++;
            }
            num[high] = num[low];
            num[low] = key;
        }
        num[low] = key;//此时low=high 是基准元素的位置，也是空出来的那个位置
        return low;
    }
}
