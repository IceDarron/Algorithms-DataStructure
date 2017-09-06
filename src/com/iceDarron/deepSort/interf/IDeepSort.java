package com.iceDarron.deepSort.interf;

import java.util.List;

public interface IDeepSort {

    /**
     * 排序方法
     * @param intArray 输入参数
     */
    public void sort(int[] intArray);

    public void sort(String[] strArray);

    public void sort(List<?> listArray);
}