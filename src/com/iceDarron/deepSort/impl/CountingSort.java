package com.iceDarron.deepSort.impl;

import com.iceDarron.deepSort.abstra.AbstraDeepSort;

public class CountingSort extends AbstraDeepSort {

    /**
     * 计数排序
     * Author Darron
     * 2017.09.19
     * 当输入的元素是 n 个 0 到 k 之间的整数时，它的运行时间是 Θ(n + k)。计数排序不是比较排序，排序的速度快于任何比较排序算法。
     * 找出待排序的数组中最大和最小的元素
     * 统计数组中每个值为i的元素出现的次数，存入数组auxiliary的第i项
     * 数组auxiliary中i项元素k，即代表存在原数组元素k个，且代表原数组中的i+min元素
     * 对元素组重新排序
     * 类似于bitmap算法
     * <p>
     * num = {4,5,12,8,7,8,8,7}
     * auxiliary = {0,0,0,0,0,0,0,0,0}
     * auxiliary = {1,1,0,2,3,0,0,0,1} 到下一步转换num的时候，用下角标加原数组最小值后放入原数组，放入的位置需要用一个新变量（初始值0）来计数，这是由于存在重复数字
     * num = {4,5,7,7,8,8,8,12}
     */

    @Override
    public void sort(int[] num) {

        // 设置默认最大最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        //找出数组中的最大最小值
        for (int aNum : num) {
            max = Math.max(max, aNum);
            min = Math.min(min, aNum);
        }

        // 保证能存放待排序数组中的所有元素，按值存放不是按个数存放
        int[] auxiliary = new int[max - min + 1];

        // 找出每个数字出现的次数
        for (int aNum : num) {
            int position = aNum - min;
            auxiliary[position]++;
        }

        int index = 0;
        for (int i = 0; i < auxiliary.length; i++) {
            int count = auxiliary[i];
            while (count-- > 0) {
                num[index++] = i + min;
            }
        }
    }
}
