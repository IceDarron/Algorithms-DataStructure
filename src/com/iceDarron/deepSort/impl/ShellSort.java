package com.iceDarron.deepSort.impl;

import com.iceDarron.deepSort.abstra.AbstraDeepSort;

public class ShellSort extends AbstraDeepSort {

    /**
     * 希尔排序(壳排序)
     * Author Darron
     * 2016.3.20
     * 希尔排序(Shell Sort)是插入排序的一种。也称缩小增量排序，是直接插入排序算法的一种更高效的改进版本。
     * 因为排序过程中元素可能会前后跳跃，希尔排序是非稳定排序算法。
     * 效率估计O（nlog2^n）~O（n^1.5），取决于增量值的最初大小。
     * 建议使用质数作为增量值，因为如果增量值是2的幂，则在下一个通道中会再次比较相同的元素。
     * 壳（Shell）排序改进了插入排序，减少了比较的次数。
     */
    @Override
    public void sort(int[] num) {


    }

}
