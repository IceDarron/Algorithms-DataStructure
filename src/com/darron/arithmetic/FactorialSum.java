package com.darron.arithmetic;


import java.math.BigDecimal;

/**
 * 计算50000！的各个位数之和
 */
public class FactorialSum {

    public static void main(String[] args) {
        BigDecimal num = new BigDecimal(5000);
        System.out.println(factorial(num));
    }


    // 算法入口
    public static int factorialArithmetic() {
        int init = 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9;
        int temp = 1;
        for (int i = 11; i < 301; i++) {
            temp = temp * i;
            temp = NumDivisionTen(temp);
        }

        return sumNum(init * temp);
    }

    // 排除所有所乘数为10的倍数的
//	public static boolean numIsUnable(int num){
//		if(num % 10 == 0){
//			return true;
//		}
//		return false;
//	}

    // 计算各个位数之和
    public static int sumNum(Integer num) {
        int sum = 0;
        int lenght = num.toString().length();
        for (int i = 0; i < lenght; i++) {
            if (num % 10 != 0) {
                sum = sum + num % 10;
            }
            num = num / 10;
        }
        return sum;
    }

    public static int NumDivisionTen(Integer num) {
        while (num % 10 == 0) {
            num = num / 10;
        }
        return num;
    }

    /**
     * 使用递归方法计算n的阶乘
     *
     * @param n
     * @return
     */
    private static BigDecimal factorial(BigDecimal n) {
        BigDecimal one = new BigDecimal(1);
        if (n.intValue() == 0) {
            System.out.println(n + "! = " + 1);
            return one;
        } else {
            BigDecimal num = n.multiply(factorial(n.subtract(one)));
            System.out.println(n + "! = " + num);
            return num;
        }
    }

}






