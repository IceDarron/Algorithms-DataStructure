package com.iceDarron.deepSort.impl;

import com.iceDarron.deepSort.abstra.AbstraDeepSort;

public class InsertionSort extends AbstraDeepSort {

    /**
     * 插入排序
     * Author Darron
     * 2016.3.20
     * 有一个已经有序的数据序列，要求在这个已经排好的数据序列中插入一个数，但要求插入后此数据序列仍然有序，
     * 这个时候就要用到一种新的排序方法——插入排序法,插入排序的基本操作就是将一个数据插入到已经排好序的有序数据中，
     * 从而得到一个新的、个数加一的有序数据，算法适用于少量数据的排序。
     * 最糟糕的时候，时间复杂度为O(n^2)。最佳的时候时间复杂度为O(n)。即如果基本有序的话效率则会高于冒泡和选择。
     * 是稳定的排序方法。
     * 插入排序的基本思想是：每步将一个待排序的纪录，按其关键码值的大小插入前面已经排序的文件中适当位置上，直到全部插入完为止。
     * 例如:2 12 25 3    i=3   temp=3;
     * 2 12 25 3        j=2     3
     * 2 12 25 25       j=1     3
     * 2 12 12 25       j=0     3
     * 2 3  12 25
     */
    @Override
    public void sort(int[] num) {
        System.out.println("插入排序");
        for (int i = 1; i < num.length; i++) {
            int temp = num[i];
            int j = i - 1;
            while (j >= 0 && num[j] > temp) {
                num[j + 1] = num[j];
                j--;
            }
            num[j + 1] = temp;
        }
    }
}
