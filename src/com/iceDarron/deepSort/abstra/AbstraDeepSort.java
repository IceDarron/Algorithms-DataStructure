package com.iceDarron.deepSort.abstra;

import com.iceDarron.deepSort.interf.IDeepSort;

import java.util.List;

public abstract class AbstraDeepSort implements IDeepSort{

    @Override
    public abstract void sort(int[] intArray);

    public void sort(String[] strArray) {
        int length = strArray.length;
        int[] intArray = new int[length];
        for (int i = 0; i < length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        sort(intArray);
    }

    public void sort(List<?> listArray) {
        int size = listArray.size();
        int[] intArray = new int[size];
        for (int i = 0; i < size; i++) {
            intArray[i] = Integer.parseInt((String) listArray.get(i));
        }
        sort(intArray);
    }
}
