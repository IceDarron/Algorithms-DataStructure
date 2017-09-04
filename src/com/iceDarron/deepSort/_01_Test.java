package com.iceDarron.deepSort;

import com.iceDarron.deepSort.impl.AscOrDesc;
import com.iceDarron.deepSort.impl.InsertionSort;

public class _01_Test {

    /**
     * 测试
     */

    public static void main(String[] args) {

        //初始化数据
        int[] num = {12, 25, 12, 3, 99, 56, 1, 45, 23, 23};

        //冒泡排序
//        BubbleSort.bubbleSort(num);

        //选择排序
//        SelectionSort.selectionSort(num);

        //插入排序
        InsertionSort.InsertionSort(num);

        // 输出结果
        AscOrDesc.AscOrDesc(num);


    }

}



