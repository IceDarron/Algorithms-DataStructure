package com.iceDarron.algorithms.deepSort.impl;

import com.iceDarron.algorithms.deepSort.abstra.AbstraDeepSort;

import java.util.LinkedList;
import java.util.List;

public class BucketSort extends AbstraDeepSort {

    /**
     * 桶排序
     * Author Darron
     * 2017.09.19
     * 桶排序的基本思想是将一个数据表分割成许多buckets，然后每个bucket各自排序，或用不同的排序算法，或者递归的使用bucket sort算法。
     * 也是典型的divide-and-conquer分而治之的策略。它是一个分布式的排序，介于MSD基数排序和LSD基数排序之间。
     * 桶排序是计数排序的变化。
     * 例子：
     * 建立一堆buckets；
     * 遍历原始数组，并将数据放入到各自的buckets当中；
     * 对非空的buckets进行排序；
     * 按照顺序遍历这些buckets并放回到原始数组中即可构成排序后的数组。
     *
     * 相当于以某一高优先级的关键字将整个数组进行一次大的排序，然后再对每个桶进行排序。因此如何分配桶是关键。
     * 在此简单的固定桶的容量，这种方式适用于分析真实业务场景的数据后来确定一个固定值，对于数据不均匀分布需要其他方式，否则容易每个桶的使用率差距较大。
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

        // 确定桶容量，桶数
        int bucketCapacity = 10;
        int bucketNum = (max - min) / bucketCapacity + 1; // 桶数

        // 创建链表（桶）集合并初始化，集合中的链表用于存放相应的元素
        List<List<Integer>> buckets = new LinkedList<List<Integer>>();
        for (int i = 0; i < bucketNum; i++) {
            buckets.add(new LinkedList<Integer>());
        }

        // 把元素放进相应的桶中
        for (int aNum : num) {
            int index = (aNum - min) / bucketCapacity;
            buckets.get(index).add(aNum);
        }

        // 对每个桶中的元素排序，并放进a中
        int index = 0;
        for (List<Integer> linkedList : buckets) {
            int size = linkedList.size();
            if (size == 0) {
                continue;
            }

            // 利用插入排序对temp排序（可以使用任意排序方式，甚至递归桶排序）
            new InsertionSort().sort(linkedList);

            // 由于从最小桶开始所以，直接进行待排数组的重新排序赋值
            for (Integer integer : linkedList) {
                num[index] = integer;
                index++;
            }
        }
    }
}
