package cn.liko.imporvement;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * MultiplicationOfLargeNumbers
 *
 * @author liko
 * @date 2020/7/19
 */
public class MultiplicationOfLargeNumbers {

    public static void main(String[] args) {
        String i = "897";
        String j = "625";
//        long begin = System.currentTimeMillis();
//        System.out.println(multiplicationOfLargeNumbers(i, j));
//        System.out.println(System.currentTimeMillis() - begin);
//        begin = System.currentTimeMillis();
//        System.out.println(Arrays.toString(bigNumberMultiply(toIntArray(i), toIntArray(j))));
//        System.out.println(System.currentTimeMillis() - begin);
        bigNumberMultiplyLiko(toIntArray(i), toIntArray(j));
    }

    private static String multiplicationOfLargeNumbers(String arg1, String arg2) {
        char[] charArray1 = arg1.toCharArray();
        char[] charArray2 = arg2.toCharArray();

        char[][] chars = new char[charArray1.length * charArray2.length][charArray1.length + charArray2.length];
        int length = 0;
        for (int i = 0; i < charArray1.length; i++) {
            for (int j = 0; j < charArray2.length; j++) {
                StringBuilder sb = new StringBuilder(Integer.valueOf(charArray1[i] + "") * Integer.valueOf(charArray2[j] + "") + fillZero(charArray1.length - i + charArray2.length - j - 2));
                sb.reverse();
                char[] chars1 = sb.toString().toCharArray();
                for (int i1 = 0; i1 < chars1.length; i1++) {
                    chars[length][i1] = chars1[i1];
                }
                length++;
            }
        }

        StringBuilder result = new StringBuilder();
        long k = 0;
        for (int i = 0; i < charArray1.length + charArray2.length; i++) {
            long sum = 0 + k;
            for (int j = 0; j < charArray1.length * charArray2.length; j++) {
                if (chars[j][i] == '\0') {
                    continue;
                }
                sum += Long.parseLong(chars[j][i] + "");
            }
            k = sum / 10;
            result.append(sum % 10);
        }
        return trimLeftZero(result.reverse().toString());
    }

    private static String trimLeftZero(String args) {
        String result = args;
        for (int i = 0; i < args.length(); i++) {
            if ((args.charAt(i) + "").equals("0")) {
                result = args.substring(i + 1);
            } else {
                break;
            }
        }
        return result;
    }

    private static String fillZero(long size) {
        StringBuilder result = new StringBuilder();
        for (long i = 0; i < size; i++) {
            result.append("0");
        }
        return result.toString();
    }


    /**
     * 大数相乘 - 模拟乘法手算累加
     */
    public static Integer[] bigNumberMultiply(int[] arr1, int[] arr2){
        ArrayList<Integer> result = new ArrayList<>();  //中间求和的结果

        //arr2 逐位与arr1相乘
        for(int i = arr2.length - 1; i >= 0; i--){
            int carry = 0;
            ArrayList<Integer> singleList = new ArrayList<>();

            //arr2 逐位单次乘法的结果
            for(int j = arr1.length - 1; j >= 0; j--){
                int r = arr2[i] * arr1[j] + carry;
                int digit = r % 10;
                carry = r / 10;

                singleList.add(digit);
            }
            if(carry != 0){
                singleList.add(carry);
            }

            int resultCarry = 0, count = 0;
            int k = 0;
            int l = 0;
            int offset = arr2.length - 1 - i;       //加法的偏移位
            ArrayList<Integer> middleResult = new ArrayList<>();

            //arr2每位乘法的结果与上一轮的求和结果相加，从右向左做加法并进位
            while (k < singleList.size() || l < result.size()) {
                int kv = 0, lv = 0;
                if (k < singleList.size() && count >= offset) {
                    kv = singleList.get(k++);
                }
                if (l < result.size()) {
                    lv = result.get(l++);
                }
                int sum = resultCarry + kv + lv;
                middleResult.add(sum % 10);     //相加结果从右向左（高位到低位）暂时存储，最后需要逆向输出
                resultCarry = sum / 10;
                count++;
            }
            if(resultCarry != 0){
                middleResult.add(resultCarry);
            }
            result.clear();
            result = middleResult;
        }

        Collections.reverse(result);    //逆向输出结果
        return result.toArray(new Integer[result.size()]);
    }

    private static int[] toIntArray(String str) {
        int[] result = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = Integer.parseInt(str.charAt(i) + "");
        }
        return result;
    }

    private static Integer[] bigNumberMultiplyLiko(int[] arr1, int[] arr2) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = arr2.length - 1; i >= 0; i--) {
            int carry = 0;
            ArrayList<Integer> firstStepResult = new ArrayList<>();


            for (int j = arr1.length - 1; j >= 0; j--) {
                int value = arr2[i] * arr1[j] + carry;

                firstStepResult.add(value % 10);

                carry = value / 10;

            }

            if (carry != 0) {
                firstStepResult.add(carry);
            }


            int k = 0, kv = 0, j = 0, jv = 0, count = 0, tempCarry = 0;
            int offset = arr2.length - i - 1;
            ArrayList<Integer> secondStepResult = new ArrayList<>();

            while (k < firstStepResult.size() || j < result.size()) {

                if (k < firstStepResult.size() && count >= offset) {
                    kv = firstStepResult.get(k++);
                }

                if (j < result.size()) {
                    jv = firstStepResult.get(j++);
                }

                int tv = kv + jv + tempCarry;
                secondStepResult.add(tv % 10);
                tempCarry = tv / 10;

            }

            if (tempCarry != 0) {
                secondStepResult.add(tempCarry);
            }

            result.clear();
            result = secondStepResult;
            System.out.println(result);

        }
        return null;
    }
}
