package com.iceDarron.algorithms.deepSort.abstra;

import com.iceDarron.algorithms.deepSort.interf.IDeepSort;

import java.util.List;

public abstract class AbstraDeepSort implements IDeepSort {

    @Override
    public abstract void sort(int[] intArray);

    public void sort(String[] array) {
        int length = array.length;
        int[] intArray = new int[length];

        // 排序
        for (int i = 0; i < length; i++) {
            intArray[i] = Integer.parseInt(array[i]);
        }
        sort(intArray);

        // 返回
        for (int i = 0; i < length; i++) {
            array[i] = intArray[i] + "";
        }
    }

    public void sort(List<Integer> array) {
        int size = array.size();
        int[] intArray = new int[size];

        // 排序
        for (int i = 0; i < size; i++) {
            intArray[i] = array.get(i);
        }
        sort(intArray);

        // 返回
        for (int i = 0; i < size; i++) {
            array.set(i,intArray[i]);
        }
    }

    public void sort(Integer[] array) {
        int length = array.length;
        int[] intArray = new int[length];

        // 排序
        for (int i = 0; i < length; i++) {
            intArray[i] = array[i];
        }
        sort(intArray);

        // 返回
        for (int i = 0; i < length; i++) {
            array[i] = intArray[i];
        }
    }

    public String getSortName() {
        return this.getClass().getName();
    }
}
