package com.itheima.test;

import java.util.Random;
import java.util.Scanner;

public class Test12 {
    public static void main(String[] args) {
        int[] arr = createNumber();
        System.out.println("中奖1000万元所需平均购买次数位：" + avgCount1(arr, 6, 1));
        System.out.println("中奖500万元所需平均购买次数位：" + avgCount1(arr, 6, 0));
        System.out.println("中奖3000元所需平均购买次数位：" + avgCount1(arr, 5, 1));
        System.out.println("中奖200元所需平均购买次数位：" + avgCount2(arr, 5, 0, 4, 1));
        System.out.println("中奖10元所需平均购买次数位：" + avgCount2(arr, 4, 0, 3, 1));
        System.out.println("中奖5元所需平均购买次数位：" + avgCount3(arr));
    }

    public static long avgCount1(int[] arr, int num1, int num2) {
        long count = 0, avgCount;
        for (int i = 0; i < 100; i++) {
            count += winOdds1(arr, num1, num2);
        }
        avgCount = count / 100;
        return avgCount;
    }

    public static int avgCount2(int[] arr, int num1, int num2, int num3, int num4) {
        int count = 0, avgCount;
        for (int i = 0; i < 1000; i++) {
            count += winOdds2(arr, num1, num2, num3, num4);
        }
        avgCount = count / 1000;
        return avgCount;
    }

    public static int avgCount3(int[] arr) {
        int count = 0, avgCount;
        for (int i = 0; i < 10000; i++) {
            count += winOdds3(arr);
        }
        avgCount = count / 10000;
        return avgCount;
    }

    public static int winOdds1(int[] arr, int num1, int num2) {
        int count = 0;
        while (true) {
            int[] colorCount = winNums(arr);
            count++;
            if(colorCount[0] == num1 && colorCount[1] == num2){
                break;
            }
        }
        return count;
    }

    public static int winOdds2(int[] arr, int num1, int num2, int num3, int num4) {
        int count = 0;
        while (true) {
            int[] colorCount = winNums(arr);
            count++;
            if((colorCount[0] == num1 && colorCount[1] == num2) || (colorCount[0] == num3 && colorCount[1] == num4)){
                break;
            }
        }
        return count;
    }

    public static int winOdds3(int[] arr) {
        int count = 0;
        while (true) {
            int[] colorCount = winNums(arr);
            count++;
            if((colorCount[0] == 2 && colorCount[1] == 1) || (colorCount[0] == 1 && colorCount[1] == 1) || (colorCount[0] == 0 && colorCount[1] == 1)) {
                break;
            }
        }
        return count;
    }

    public static int[] winNums(int[] arr) {
        int[] userInputArr = createNumber();
        int[] colorCount = {0, 0};
        for (int i = 0; i < userInputArr.length - 1; i++) {
            int redNumber = userInputArr[i];
            for (int j = 0; j < arr.length - 1; j++) {
                if(redNumber == arr[j]){
                    colorCount[0]++;
                    break;
                }
            }
        }
        int blueNumber = userInputArr[userInputArr.length-1];
        if(blueNumber == arr[arr.length - 1]){
            colorCount[1]++;
        }
        return colorCount;
    }

    public static int[] createNumber() {
        int[] arr = new int[7];
        Random r = new Random();
        for (int i = 0; i < 6; ) {
            int redNumber = r.nextInt(33) + 1;
            boolean flag = contains(arr, redNumber);
            if (!flag) {
                arr[i] = redNumber;
                i++;
            }
        }
        int blueNumber = r.nextInt(16) + 1;
        arr[arr.length - 1] = blueNumber;
        return arr;
    }

    public static boolean contains(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                return true;
            }
        }
        return false;
    }
}
