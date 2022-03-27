package com.codingtest.leetcode.easy;

import java.util.Arrays;

//338. Counting Bits
public class CountingBits {
    public int[] countBits(int n) {
        int []answer=new int[n+1];
        int offset=1;

        for (int i = 1; i <= n; i++) {
            if(offset*2 == i)
                offset*=2;

            answer[i]=answer[i-offset]+1;
        }

        return answer;
    }

    public static void main(String[] args) {
        CountingBits cb=new CountingBits();
        int[] ints = cb.countBits(0);

        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }
}
