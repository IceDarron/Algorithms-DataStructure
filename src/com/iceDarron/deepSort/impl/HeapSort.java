package com.iceDarron.deepSort.impl;

import com.iceDarron.deepSort.abstra.AbstraDeepSort;

public class HeapSort extends AbstraDeepSort {

    /**
     * 堆排序
     * Author Darron
     * 2017.09.20
     * 堆排序是一种树形选择排序，是对直接选择排序的有效改进。
     * 需要了解树结构
     * 堆排序利用了大根堆(或小根堆)堆顶记录的关键字最大(或最小)这一特征
     * 步骤：
     * 1.初始化操作：将R[1..n]构造为初始堆；
     * 2.每一趟排序的基本操作：将当前无序区的堆顶记录R[1]和该区间的最后一个记录交换，然后将新的无序区调整为堆(亦称重建堆)。
     */

    @Override
    public void sort(int[] num) {
        for (int i = 0; i < num.length; i++) {
            createMaxdHeap(num, num.length - 1 - i);
            swap(num, 0, num.length - 1 - i);
//            print(num);
        }
    }

    // 交换
    private static void swap(int[] data, int i, int j) {
        if (i == j) {
            return;
        }
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }

    private static void createMaxdHeap(int[] data, int lastIndex) {
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // 保存当前正在判断的节点
            int k = i;
            // 若当前节点的子节点存在
            while (2 * k + 1 <= lastIndex) {
                // biggerIndex总是记录较大节点的值,先赋值为当前判断节点的左子节点
                int biggerIndex = 2 * k + 1;
                if (biggerIndex < lastIndex) {
                    // 若右子节点存在，否则此时biggerIndex应该等于 lastIndex
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        // 若右子节点值比左子节点值大，则biggerIndex记录的是右子节点的值
                        biggerIndex++;
                    }
                }
                if (data[k] < data[biggerIndex]) {
                    // 若当前节点值比子节点最大值小，则交换2者得值，交换后将biggerIndex值赋值给k
                    swap(data, k, biggerIndex);
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    private static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }


}
