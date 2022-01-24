package com.codingtest.codeup.stack;

import java.util.Scanner;

//3130 : 소들의 헤어스타일
public class CowHair {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String  str = sc.next();
        String correctParenthesis = isCorrectParenthesis(str);
        System.out.println(correctParenthesis);
    }
}
