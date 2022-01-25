package com.codingtest.codeup.recursion;

import java.util.Scanner;

//1905 : (재귀함수) 1부터 n까지 합 구하기
public class SumOneToN {
    public static int getSum(int n){
        //종료조건
        if(n<=1)
            return n;

        return n+getSum(n-1);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(getSum(n));
    }
}
