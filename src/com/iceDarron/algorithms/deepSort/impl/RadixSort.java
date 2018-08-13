package com.iceDarron.algorithms.deepSort.impl;

import com.iceDarron.algorithms.deepSort.abstra.AbstraDeepSort;

import java.util.Arrays;

public class RadixSort extends AbstraDeepSort {

    /**
     * 基数排序
     * Author Darron
     * 2017.09.19
     * 是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。
     * 有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。
     * 最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。基数排序基于分别排序，分别收集，所以是稳定的。
     * 分为两种：
     * LSD从低位开始排到高位，每排一位都是把各个桶合并，再按下一位排序；
     * MSD从高位开始排到低位，排完一位后不合并桶，相同的高位划分子桶继续分配，最后再合并
     * <p>
     * 例子LSD：278、109、063、930、589、184、505、269、008、083
     * 第一次 930、063、083、184、505、278、008、109、589、269
     * 第二次 505、008、109、930、063、269、278、083、184、589
     * 第三次 008、063、083、109、184、269、278、505、589、930
     * 时间复杂度O (nlog(r)m)其中r为所采取的基数，而m为堆数
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

        // 确定桶容量
        int bucketCapacity = 10;

        // 最高位
        int d = (int) Math.log10((double) max) + 1;

        // 缓存数组
        int[] tmp = new int[num.length];
        // buckets用于记录待排序元素的信息
        // buckets数组定义了max-min个桶
        int[] buckets = new int[bucketCapacity];

        for (int i = 0, rate = 1; i < d; i++) {

            // 重置count数组，开始统计下一个关键字
            Arrays.fill(buckets, 0);
            // 将data中的元素完全复制到tmp数组中
            System.arraycopy(num, 0, tmp, 0, num.length);

            // 计算每个待排序数据的子关键字
            for (int j = 0; j < num.length; j++) {
                int subKey = (tmp[j] / rate) % bucketCapacity;
                buckets[subKey]++;
            }

            for (int j = 1; j < bucketCapacity; j++) {
                buckets[j] = buckets[j] + buckets[j - 1];
            }

            // 按子关键字对指定的数据进行排序
            for (int m = num.length - 1; m >= 0; m--) {
                int subKey = (tmp[m] / rate) % bucketCapacity;
                num[--buckets[subKey]] = tmp[m];
            }
            rate *= bucketCapacity;
        }
    }

}
