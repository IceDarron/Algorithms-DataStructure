package com.iceDarron.deepSort;

public class AscOrDesc {

    /**
     * 升降序排列
     * Author Darron
     * 2016.3.18
     */

    public AscOrDesc(int[] num) {
        int count = 0;
        int zero = 0;
        String str = "";
        for (int i = 0; i < num.length - 1; i++) {
            if (num[i] < num[i + 1])
                count++;
            if (num[i] > num[i + 1])
                count--;
            if (num[i] == num[i + 1]) {
                zero++;
                str += num[i] + " ";
            }
        }
        if (count == num.length - 1 - zero)
            System.out.println("从小到大");
        if (count == -num.length + 1 + zero)
            System.out.println("从大到小");
        if (zero != 0)
            System.out.println("重复数据 " + str);
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        //分割线
        System.out.println("\n********************************");
    }
}
