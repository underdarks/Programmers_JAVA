package com.codingtest.codeup.stack;

import java.util.Scanner;
import java.util.Stack;

//1714 : 숫자 거꾸로 출력하기
public class ReverseOrder {

    public static String getNum(int n){
        Stack<Character> stack =new Stack<>();
        String s = Integer.toString(n);
        StringBuilder str=new StringBuilder();

        for (char c : s.toCharArray()) {
            stack.push(c);
        }

        while (!stack.empty()){
            str.append(stack.pop());
        }

        return str.toString();
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(getNum(n));

    }
}
