package com.darron.arithmetic;

public class _01_Test {

    /**
     * 测试
     */

    public static void main(String[] args) {

        //初始化数据
        int[] num = {12, 25, 12, 3, 99, 56, 1, 45, 23, 23};

        //冒泡排序
//		new AscOrDesc(new BubbleSort().bubbleSort(num));

        //选择排序
        new AscOrDesc((new SelectionSort().selectionSort(num)));

        //插入排序
//		new AscOrDesc().AscOrDesc(new InsertionSort().InsertionSort(num));


    }

}



