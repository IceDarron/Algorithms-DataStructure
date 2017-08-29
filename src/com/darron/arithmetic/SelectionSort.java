package com.darron.arithmetic;

public class SelectionSort {

    /**
     * 选择排序
     * Author Darron
     * 2016.3.18
     * 每次最小/大排在相应的位置，小到大，时间复杂度O(n^2)时间换空间，适用于小列表，不稳定。
     * 选择排序的交换操作介于 0 和 (n - 1） 次之间。选择排序的比较操作为 n (n - 1） / 2 次之间。选择排序的赋值操作介于 0 和 3 (n - 1） 次之间。
     * 比较次数O(n^2），比较次数与关键字的初始状态无关，总的比较次数N=(n-1）+(n-2）+...+1=n*(n-1）/2。
     * 交换次数O(n），最好情况是，已经有序，交换0次；最坏情况交换n-1次，逆序交换n/2次。
     * 交换次数比冒泡排序少多了，由于交换所需CPU时间比比较所需的CPU时间多，n值较小时，选择排序比冒泡排序快(但冒泡稳定，选择不稳定)。
     */

    public int[] selectionSort(int[] num) {
        System.out.println("选择排序");
        for (int i = 0; i < num.length - 1; i++) {
            int index = i; // 标记现在需要比较的数字的位置
            for (int j = i + 1; j < num.length; j++) { //从后一个开始比较
                if (num[j] < num[index]) {
                    index = j;
                } // 如果后一个比你现在标记的小，则换标记，记住现在这个最小的数字
            }
            if (i != index) { //如果换过标记则进行交换
                int temp = num[i];
                num[i] = num[index];
                num[index] = temp;
            }
        }
        return num;
    }
}
