package com.codingtest.codeup.recursion;

import java.util.Scanner;

//1915 : (재귀함수) 피보나치 수열
public class Fibo {

    public static int getFibo(int n){
        if(n<=2)
            return 1;

        return getFibo(n-2)+getFibo(n-1);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(getFibo(n));
    }
}
