package com.iceDarron.algorithms.deepSort;

import com.iceDarron.algorithms.deepSort.impl.*;
import com.iceDarron.algorithms.deepSort.interf.IDeepSort;

public class _01_Test {

    /**
     * 测试
     */

    public static void main(String[] args) {

        // 初始化数据
        int[] num = {12, 25, 12, 3, 99, 561, 1, 45, 231, 2112};
        IDeepSort iDeepSort = null;

        // 冒泡排序
//        iDeepSort = new BubbleSort();

        // 选择排序
//        iDeepSort = new SelectionSort();

        // 插入排序
//        iDeepSort = new InsertionSort();

        // 希尔排序
//        iDeepSort = new ShellSort();

        // 快速排序
//        iDeepSort = new FastSort();

        // 计数排序
//        iDeepSort = new CountingSort();

        // 桶排序
//        iDeepSort = new BucketSort();

        // 堆排序
//        iDeepSort = new HeapSort();

        // 基数排序
//        iDeepSort = new RadixSort();

        //归并排序
        iDeepSort = new MergeSort();

        // 排序
        iDeepSort.sort(num);



        // 输出结果
        AscOrDesc.AscOrDesc(num);
        System.out.println("排序方式：" + iDeepSort.getSortName());


    }

}



