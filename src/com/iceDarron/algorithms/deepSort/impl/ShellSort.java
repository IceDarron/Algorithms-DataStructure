package com.iceDarron.algorithms.deepSort.impl;

import com.iceDarron.algorithms.deepSort.abstra.AbstraDeepSort;

public class ShellSort extends AbstraDeepSort {

    /**
     * 希尔排序(壳排序)
     * Author Darron
     * 2016.3.20
     * 希尔排序(Shell Sort)是插入排序的一种。也称缩小增量排序，是直接插入排序算法的一种更高效的改进版本。
     * 因为排序过程中元素可能会前后跳跃，希尔排序是非稳定排序算法。
     * 效率估计O（nlogn）~O（n^2），取决于增量值的最初大小。
     * 建议使用质数作为增量值，因为如果增量值是2的幂，则在下一个通道中会再次比较相同的元素。
     * 壳（Shell）排序改进了插入排序，减少了比较的次数。
     */
    @Override
    public void sort(int[] num) {
        //增量gap，并逐步缩小增量
        for (int gap = num.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < num.length; i++) {
                int j = i;
                while (j - gap >= 0 && num[j] < num[j - gap]) {
                    //插入排序采用交换法
                    swap(num, j, j - gap);
                    j -= gap;
                }
            }
        }
    }


    /**
     * 交换数组元素
     *
     * @param num
     * @param a
     * @param b
     */
    public static void swap(int[] num, int a, int b) {
        num[a] = num[a] + num[b];
        num[b] = num[a] - num[b];
        num[a] = num[a] - num[b];
    }

}
