package com.codingtest.codeup.recursion;

import java.util.Scanner;

//1912 : (재귀함수) 팩토리얼 계산
public class factorial {

    public static int getFactorial(int n){
        if(n<=2)
            return n;

        return getFactorial(n-1)*n;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(getFactorial(n));
    }

}
