package com.iceDarron.deepSort.impl;

import com.iceDarron.deepSort.abstra.AbstraDeepSort;

public class CountingSort extends AbstraDeepSort {

    /**
     * 计数排序
     * Author Darron
     * 2017.09.19
     * 当输入的元素是 n 个 0 到 k 之间的整数时，它的运行时间是 Θ(n + k)。计数排序不是比较排序，排序的速度快于任何比较排序算法。
     * 找出待排序的数组中最大和最小的元素
     * 统计数组中每个值为i的元素出现的次数，存入数组C的第i项
     * 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）
     * 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1
     *
     * 类似于bitmap算法
     */

    @Override
    public void sort(int[] intArray) {

    }
}
