package com.codingtest.codeup.dp;

import java.util.List;
import java.util.Scanner;

//3707 : 합의 개수
//https://codeup.kr/problem.php?id=3707
public class SumNum {

    public static Long getSumNum(int n){
        long sum=1L;

        for(int i=1;i<n-1;i++) {
            Long v=1L;
            for(int j=0;j<i;j++)
                v*=2;
            sum+=v;
        }

        return sum;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();

        long sumNum = getSumNum(n);
        System.out.println(sumNum);

    }
}
