package com.iceDarron.compression;

/**
 * @ClassName_BigAdd 压缩字符串
 * @author_IceDarron
 * @Date_201805021752
 * @Description_算法描述 
 * 给定一组字符，使用原地算法将其压缩。
 * 压缩后的长度必须始终小于或等于原数组长度。
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 * 在完成原地修改输入数组后，返回数组的新长度。
 * 仅使用O(1) 空间。
 *
 * 输入：
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * 输出：
 * 返回4，输入数组的前4个字符应该是：["a","b","1","2"]。
 */
public class CompressedString {
  public int compress(char[] chars) {
          if (chars == null || chars.length == 0) return 0;
          if (chars.length == 1) return 1;
          int length = chars.length;
          int newSet = 0;
          int count = 1;
          char temp = chars[0];
          for (int i = 1; i < length; i++) {
              if (temp == chars[i]) {
                  count++;
              } else {
                  if (count > 1) {
                      newSet += setNum(count, newSet, temp, chars) + 1;
                  } else {
                      chars[newSet] = temp;
                      newSet++;
                  }
                  temp = chars[i];
                  count = 1;
              }
          }

          if (count > 1) {
              newSet += setNum(count, newSet, temp, chars);
          } else {
              chars[newSet] = temp;
          }

          return ++newSet;
      }

      private int setNum(int count, int set, char target, char[] chars) {
          chars[set] = target;
          int num = count;
          int index = (num + "").length();
          num = count;
          for (int j = index - 1; j >= 0; j--) {
              chars[set + 1 + j] = Integer.valueOf(num % 10).toString().charAt(0);
              num /= 10;
          }
          return index;
      }
}
