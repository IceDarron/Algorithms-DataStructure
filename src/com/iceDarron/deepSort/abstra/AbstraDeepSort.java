package com.iceDarron.deepSort.abstra;

import com.iceDarron.deepSort.interf.IDeepSort;

public abstract class AbstraDeepSort implements IDeepSort{

    @Override
    public abstract void sort(int[] num);

    public void sort(String num) {

    }
}
