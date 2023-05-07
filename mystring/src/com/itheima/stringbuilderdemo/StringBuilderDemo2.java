package com.itheima.stringbuilderdemo;

public class StringBuilderDemo2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 1000000; i++) {
            sb.append("abc");
        }

        System.out.println(sb);
    }
}
