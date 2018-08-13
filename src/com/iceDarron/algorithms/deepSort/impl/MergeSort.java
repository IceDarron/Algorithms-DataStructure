package com.iceDarron.algorithms.deepSort.impl;

import com.iceDarron.algorithms.deepSort.abstra.AbstraDeepSort;

public class MergeSort extends AbstraDeepSort {

    /**
     * 归并排序
     * Author Darron
     * 2017.09.20
     * 归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
     * 主要思想：分而治之
     */

    @Override
    public void sort(int[] num) {
        int length = num.length;
        int[] temp = new int[length];
        group(num, 0, length - 1, temp);
    }

    /**
     *
     * 比较a[i]和a[j]的大小，若a[i]≤a[j]，则将第一个有序表中的元素a[i]复制到r[k]中，并令i和k分别加上1；
     * 否则将第二个有序表中的元素a[j]复制到r[k]中，并令j和k分别加上1，如此循环下去，直到其中一个有序表取完。
     * 然后再将另一个有序表中剩余的元素复制到r中从下标k到下标t的单元。
     * 归并排序的算法我们通常用递归实现，先把待排序区间[s,t]以中点二分，接着把左边子区间排序，再把右边子区间排序，
     * 最后把左区间和右区间用一次归并操作合并成有序的区间[s,t]。
     */
    private void merge(int a[], int first, int mid, int last, int temp[]) {
        int i = first; // 左序列开始索引
        int m = mid; // 左序列结束索引
        int j = mid + 1; // 右序列开始索引
        int n = last; // 右序列结束索引
        int k = 0; // 临时数组索引

        // 从两个数组中取出最小的放入临时数组
        while (i <= m && j <= n) {
            if (a[i] <= a[j])
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }

        // 剩余部分依次放入临时数组，实际上两个while只会执行其中一个
        while (i <= m)
            temp[k++] = a[i++];

        while (j <= n)
            temp[k++] = a[j++];

        // 将临时数组中的内容拷贝回原数组中
        for (i = 0; i < k; i++)
            a[first + i] = temp[i];
    }

    private void group(int a[], int first, int last, int temp[]) {
        if (first < last) {
            int mid = (first + last) / 2;
            group(a, first, mid, temp); // 左边有序
            group(a, mid + 1, last, temp); // 右边有序
            merge(a, first, mid, last, temp); // 再将二个有序数列合并
        }
    }
}
