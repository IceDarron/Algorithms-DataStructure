package com.iceDarron.algorithms.pointsGameOf24;

import com.iceDarron.utils.IOUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PointsGameOf24 {

    static String[] calsymbol = {"+", "-", "*", "/"};
    static Double n1 = 0.00000;
    static Double n2 = 0.00000;
    static int stoi1 = 3;
    static int stoi2 = 7;
    static int cal = 0;
    static List<Object> list = new ArrayList<Object>();
    static int count = 0;
    /**
     * 3.26
     * 24点游戏算法 处理四则运算和括号的基本思想是拆分为三个单独的方法降低耦合。
     * 三个方法的基本结构也是一致的，主要是通过参数（四则运算符，括号，全字符串）和递归的方式处理数据。
     * 处理方式为，以方法所要处理的运算为主题，循环判定或测得想要的运算符后，对该运算符周围的数据进行处理后前移数据。
     * 以*\/法为例，循环验证运算符数组，当数组出现高级运算符的时候，调用用对应的高级运算符的运算方法，
     * 处理数据后将数据存储到运算字段的最前端，并根据此位置和没有涉及的字段的位置依次赋值。 赋值后跳出方法，进行新数组的遍历后递归。
     * 3.30尝试，对参数进行对象封装，使各方法直接返回一个对象，降低方法之间的耦合。以此在循环遍历64种组合式直接封装对象写一个对象类或直接用集合。
     * 4.3优化加减乘除四则运算，将两个方法合并为一个方法通过全局变量cal控制方法加减乘除的优先级。
     * 现扩展24点游戏为根据输入个数数字和想要的计算结果得出想要的解。
     * 4.4完成了括号处理，四则运算处理部分，需要编写六种括号模式。
     * 基本完成了24点游戏，开始测试bug和优化代码。
     * bug5*5-5/4=24 已修正
     */
    IOUtils wf = new IOUtils();
    String url = "H:/Myeclipse/workspace/TestUtil/src/com/darron/arithmetic/TestPointsGameOf24.txt";

    // 遍历所有无括号情况
    public PointsGameOf24(int[] num) {
        boolean flag = true;
        for (int i = 0; i < calsymbol.length; i++) {
            for (int j = 0; j < calsymbol.length; j++) {
                for (int k = 0; k < calsymbol.length; k++) {
                    for (int n = 0; n < 7; n++) {
                        String result = "";
                        stoi1 = 3;
                        stoi2 = 7;
                        cal = 0;
                        int[] temp = {i, j, k};
                        String[] s = {"" + num[0], calsymbol[i], "" + num[1],
                                calsymbol[j], "" + num[2], calsymbol[k],
                                "" + num[3]};
                        //六种括号结构
                        String[] ss = sixBrackets(temp, n, num);
                        list.clear();
                        list.add(temp);
                        if (ss != null) {
                            list.add(ss);
                            for (int m = 0; m < ss.length; m++) {
                                result += ss[m];
                            }
                        } else {
                            list.add(s);
                        }
                        list = calBrackets(list);
//						String[] str = (String[]) list.get(1);// list.get(0)虽然空但是在之前的递归里是有存在的意义的。
                        if (YOrNfor24(list) && flag) {//加上&&flag后针对一组数据只显示一个结果，其他结果计算但不显示。
                            if (ss != null) {
                                System.out.println(result + "=24");
                                wf.writeFile(url, result + "=24");
                            }
                            flag = false;
                        } else if (i * j * k == 27 && flag) {
                            count++;
                            if (count == 7) {
                                System.out.println("" + num[0] + ", " + num[1] + ", " + num[2] + ", " + num[3] + " 无解");
                                wf.writeFile(url, "" + num[0] + ", " + num[1] + ", " + num[2] + ", " + num[3] + " 无解");
                                count = 0;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Date date1 = new Date();
        Long l1 = date1.getTime();
//		System.exit(0);
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                for (int k = 1; k <= 10; k++) {
                    for (int l = 1; l <= 10; l++) {
                        int[] num = {i, j, k, l};
                        new PointsGameOf24(num);
                    }
                }
            }
        }
        Date date2 = new Date();
        Long l2 = date2.getTime();
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l2 - l1);
    }

    //为字符串添加六种括号结构
    public String[] sixBrackets(int[] args1, int args2, int[] num) {
        if (args2 == 0) {
            String[] args = {"" + num[0], calsymbol[args1[0]], "" + num[1], calsymbol[args1[1]], "" + num[2], calsymbol[args1[2]], "" + num[3]};
            return args;
        }
        if (args2 == 1 && args1[0] < 2 && args1[1] > 1) {
            String[] args = {"(", "" + num[0], calsymbol[args1[0]], "" + num[1], ")", calsymbol[args1[1]], "" + num[2], calsymbol[args1[2]], "" + num[3]};
            return args;
        }
        if (args2 == 2 && args1[1] < 2 && (args1[0] > 1 || args1[2] > 1)) {
            String[] args = {"" + num[0], calsymbol[args1[0]], "(", "" + num[1], calsymbol[args1[1]], "" + num[2], ")", calsymbol[args1[2]], "" + num[3]};
            return args;
        }
        if (args2 == 3 && args1[2] < 2 && args1[1] > 1) {
            String[] args = {"" + num[0], calsymbol[args1[0]], "" + num[1], calsymbol[args1[1]], "(", "" + num[2], calsymbol[args1[2]], "" + num[3], ")"};
            return args;
        }
        if (args2 == 4 && args1[2] > 1 && (args1[0] < 2 || args1[1] < 2)) {
            String[] args = {"(", "" + num[0], calsymbol[args1[0]], "" + num[1], calsymbol[args1[1]], "" + num[2], ")", calsymbol[args1[2]], "" + num[3]};
            return args;
        }
        if (args2 == 5 && args1[0] > 1 && (args1[2] < 2 || args1[1] < 2)) {
            String[] args = {"" + num[0], calsymbol[args1[0]], "(", "" + num[1], calsymbol[args1[1]], "" + num[2], calsymbol[args1[2]], "" + num[3], ")"};
            return args;
        }
        if (args2 == 6 && args1[0] < 2 && args1[1] > 1 && args1[2] < 2) {
            String[] args = {"(", "" + num[0], calsymbol[args1[0]], "" + num[1], ")", calsymbol[args1[1]], "(", "" + num[2], calsymbol[args1[2]], "" + num[3], ")"};
            return args;
        }
        return null;
    }

    // 判断是否为24
    public boolean YOrNfor24(List<Object> list) {
        String[] str = (String[]) list.get(1);
        if (str[0].indexOf(".") != -1) {//str[0]有可能会是Infinity
            n1 = Double.parseDouble(str[0].substring(0, str[0].indexOf(".")));
            n2 = Double.parseDouble(str[0].substring(str[0].indexOf(".") + 1, str[0].indexOf(".") + 2));
        }
        if (n1 == 24 && n2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    // 计算括号
    public List<Object> calBrackets(List<Object> list) {
        boolean flag = true;
        int[] temp = (int[]) list.get(0);// 需要处理的数据
        String[] s = (String[]) list.get(1);
        int start = -1;
        int end = -1;
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("(")) {
                start = i;
            }
            if (s[i].equals(")")) {
                end = i;
            }
            if (start != -1 && end != -1) {
                int[] temp1 = new int[(end - start) / 2 - 1];// 组合了括号内的运算
                String[] s1 = new String[end - start - 1];
                for (int n = 0; n < temp1.length; n++) {
                    temp1[n] = temp[end / 2 - 1 - temp1.length + n];// temp[end/2-1-temp1.length+n+1]n=0时是括号里的第一个运算符
                    temp[end / 2 - 1 - temp1.length + n] = -1;// 如果括号里的运算符用过了就给运算符标识设置为-1
                }
                for (int m = 0; m < s1.length; m++) {
                    s1[m] = s[start + 1 + m];
                    s[start + 1 + m] = "";
                }
                list.clear();
                list.add(temp1);
                list.add(s1);
                String[] str = (String[]) calASMD(list).get(1);
                s[start] = str[0];// 等价于s[2 * n] = ASMD(s[2 * n], s[2 * n + 2], temp[n]) + "";
                s[end] = "";
                int[] temp2 = new int[temp.length - temp1.length];// 经过一次括号处理后的数据
                String[] s2 = new String[s.length - s1.length - 1];
                for (int j = 0; j < temp2.length; j++) {
                    for (int q = 0; q < temp.length; q++) {
                        if (temp[q] != -1) {
                            temp2[j] = temp[q];
                            temp[q] = -1;
                            break;
                        }
                    }
                }
                for (int k = 0; k < s2.length; k++) {
                    for (int p = 0; p < s.length; p++) {
                        if (!s[p].equals("")) {
                            s2[k] = s[p];
                            s[p] = "";
                            break;
                        }
                    }
                }
                list.clear();
                list.add(temp2);
                list.add(s2);
                flag = false;
                break;
            }
        }
        if (flag) {
            cal = 0;
            return calASMD(list);
        } else {
            return calBrackets(list);
        }
    }

    // 处理加减乘除运算
    public List<Object> calASMD(List<Object> list) {
        boolean flag = true;
        int[] temp = (int[]) list.get(0);
        String[] s = (String[]) list.get(1);
        stoi1 = temp.length;
        stoi2 = s.length;
        for (int n = 0; n < temp.length; n++) {
            if (temp[n] > 1 || cal == 1) {
                s[2 * n] = ASMD(s[2 * n], s[2 * n + 2], temp[n]) + "";
                double nn = n;
                for (double m = 2 * nn + 3; m < (double) s.length; ) {// m++的问题
                    s[(int) (2 * nn + 1)] = s[(int) (2 * nn + 3)];
                    nn += 0.5;
                    m = 2 * nn + 3;
                }
                for (; n < temp.length - 1; ) {//for (int c = n; n < temp.length - 1;) 2016.07.20修改
                    temp[n] = temp[n + 1];
                    n++;
                }
                stoi1--;
                stoi2 -= 2;
                flag = false;
                break;
            }

        }
        int[] temp1 = new int[stoi1];
        String[] s1 = new String[stoi2];
        for (int i = 0; i < stoi1; i++) {
            temp1[i] = temp[i];
        }
        for (int j = 0; j < stoi2; j++) {
            s1[j] = s[j];
        }
        list.clear();
        list.add(temp1);
        list.add(s1);
        if (flag) {
            if (cal == 1) {
                return list;
            }
            cal = 1;
            return calASMD(list);
        } else {
            return calASMD(list);
        }
    }

    // 四则运算
    public double ASMD(String s1, String s2, int s3) {
        if (s3 == 0) {
            return Double.parseDouble(s1) + Double.parseDouble(s2);
        }
        if (s3 == 1) {
            return Double.parseDouble(s1) - Double.parseDouble(s2);
        }
        if (s3 == 2) {
            return Double.parseDouble(s1) * Double.parseDouble(s2);
        }
        if (s3 == 3) {
            return Double.parseDouble(s1) / Double.parseDouble(s2);
        }
        return -1;
    }

}








