package com.iceDarron.deepSort.abstra;

import com.iceDarron.deepSort.interf.IDeepSort;

import java.util.List;

public abstract class AbstraDeepSort implements IDeepSort {

    @Override
    public abstract void sort(int[] intArray);

    public void sort(String[] array) {
        int length = array.length;
        int[] intArray = new int[length];
        for (int i = 0; i < length; i++) {
            intArray[i] = Integer.parseInt(array[i]);
        }
        sort(intArray);
    }

    public void sort(List<?> array) {
        int size = array.size();
        int[] intArray = new int[size];
        for (int i = 0; i < size; i++) {
            intArray[i] = Integer.parseInt((String) array.get(i));
        }
        sort(intArray);
    }

    public void sort(Integer[] array) {
        int length = array.length;
        int[] intArray = new int[length];
        for (int i = 0; i < length; i++) {
            intArray[i] = array[i];
        }
        sort(intArray);
    }
}
