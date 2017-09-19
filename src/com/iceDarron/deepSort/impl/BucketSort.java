package com.iceDarron.deepSort.impl;

import com.iceDarron.deepSort.abstra.AbstraDeepSort;

public class BucketSort extends AbstraDeepSort {

    /**
     * 桶排序
     * Author Darron
     * 2017.09.19
     * 桶排序的基本思想是将一个数据表分割成许多buckets，然后每个bucket各自排序，或用不同的排序算法，或者递归的使用bucket sort算法。
     * 也是典型的divide-and-conquer分而治之的策略。它是一个分布式的排序，介于MSD基数排序和LSD基数排序之间。
     * 桶排序是计数排序的变化。计数排序利用了bitmap算法。
     * 例子：
     * 建立一堆buckets；
     * 遍历原始数组，并将数据放入到各自的buckets当中；
     * 对非空的buckets进行排序；
     * 按照顺序遍历这些buckets并放回到原始数组中即可构成排序后的数组。
     */

    @Override
    public void sort(int[] intArray) {

    }
}
