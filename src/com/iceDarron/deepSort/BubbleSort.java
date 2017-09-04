package com.darron.deepSort;

public class BubbleSort {

    /**
     * 冒泡排序
     * Author Darron
     * 2016.3.18
     * 冒泡排序算法的运作如下：（从后往前）
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较
     * 冒泡排序总的平均时间复杂度为  。
     * 冒泡排序是一种稳定排序算法。
     */

    public int[] bubbleSort(int[] num) {
        System.out.println("冒泡排序");
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length - 1 - i; j++) {
                if (num[j] < num[j + 1]) {
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                }
            }
        }
        return num;
    }
}
