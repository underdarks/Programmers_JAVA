package com.codingtest.leetcode.easy;

//1523. Count Odd Numbers in an Interval Range
public class CountOddNumbers {

    /**
     * 1번째 로직
     * (high-low)/2를 한 후 low랑 high가 홀수 이면 1을 더해준다
     *
     */

//    public int countOdds(int low, int high) {
//        int count = (high - low) / 2;
//
//        if (high % 2 == 1 || low % 2 == 1)
//            count++;
//
//        return count;
//    }

    /**\
     * low ~ high까지 홀수 개수 = 1~high 까지의 홀수 개수 - 1~ (low-1) 까지의 홀수 개수
     */
    public int countOdds(int low, int high) {
        return (high+1)/2 - low/2;
    }

    public static void main(String[] args) {
        CountOddNumbers c = new CountOddNumbers();
        c.countOdds(21, 22);
    }
}
