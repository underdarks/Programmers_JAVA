package com.codingtest.codeup.recursion;

import java.util.Scanner;

//1901 : (재귀 함수) 1부터 n까지 출력하기
public class OneToN {
    public static void print1ToN(int n){
        System.out.println(n);
        if(n>1)    //종료조건
            print1ToN(n-1); //자기자신 호출
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();

        print1ToN(n);
    }

}
