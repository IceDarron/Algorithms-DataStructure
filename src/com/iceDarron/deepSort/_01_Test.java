package com.iceDarron.deepSort;

import com.iceDarron.deepSort.impl.*;
import com.iceDarron.deepSort.interf.IDeepSort;

public class _01_Test {

    /**
     * 测试
     */

    public static void main(String[] args) {

        // 初始化数据
        int[] num = {12, 25, 12, 3, 99, 56, 1, 45, 23, 23};
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
        iDeepSort = new FastSort();

        // 排序
        iDeepSort.sort(num);

        // 输出结果
        AscOrDesc.AscOrDesc(num);


    }

}



