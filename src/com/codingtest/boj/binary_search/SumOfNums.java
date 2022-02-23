package com.codingtest.boj.binary_search;


import java.util.Scanner;

public class SumOfNums {

    public static Long getMaxNum(Long n){
        long start = 1;
        long end = n;


        while (start <= end) {
            long mid = (start + end) / 2;

            long result = mid * (mid+1) / 2;

            if (result == n) {
                start = mid + 1;
                break;
            }

            if (result < n)
                start = mid + 1;

            else
                end = mid - 1;
        }

        return start - 1;
//        Long sum=0L;    //덧셈
//        Long answer=0L;
//        Long left=0L;
//        Long right=s;
//
//        while(left <= right){
//            Long mid=(left+right)/2;    //중간값 구하기
//            sum=(mid+1)*mid/2;  //1부터 n까의 덧셈은 n*(n+1)/2이다.
//
//            if(sum > s) //1~mid 까지의 합이 자연수의 합(S)보다 크면
//                right=mid-1;
//
//            else {
//                left = mid + 1;
//                answer=mid;
//            }
//
//        }
//
//        return answer;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Long s=sc.nextLong();

        Long maxNum = getMaxNum(s);
        System.out.println(maxNum);
    }
}
