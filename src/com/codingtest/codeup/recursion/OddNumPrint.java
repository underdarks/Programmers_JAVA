package com.codingtest.codeup.recursion;

import java.util.Scanner;

//1904 : (재귀함수) 두 수 사이의 홀수 출력하기
public class OddNumPrint {
    public static void getOddNum(int a,int b){
        //종료조건
        if(a>b)
            return;

        if(a%2 != 0)
            System.out.print(a+" ");

        getOddNum(a+1,b);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        getOddNum(a,b);
    }
}
