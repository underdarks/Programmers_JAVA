package com.codingtest.codeup.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//1920 : (재귀함수) 2진수 변환
public class BinaryConversion {

    public static void getBinary(int n,StringBuilder str){
        if(n>=0){
            getBinary(n/2 ==0 ? -1 : n/2, str);
            str.append(n%2);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder str=new StringBuilder();

        getBinary(n,str);
        System.out.println(str.toString());
    }
}
