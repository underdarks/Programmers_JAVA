package com.codingtest.codeup.binarysearch;

import java.util.Scanner;

//https://codeup.kr/problem.php?id=2655
//2655 : 1차 함수의 x절편 구하기
public class XIntercept {
    
    public static double getXIntercept(double a, double b){
        return -b/a;
    }

    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();

        double xIntercept = getXIntercept(a, b);
        System.out.printf("%.4f",xIntercept);

    }
}
