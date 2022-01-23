package com.codingtest.codeup.stack;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

//1402 : 거꾸로 출력하기 3
public class ReversePring3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> datas=new Stack<>();

        for (int i = 0; i < n; i++) {
            datas.push(sc.nextInt());
        }

        while(!datas.empty()){
            System.out.print(datas.pop() + " ");
        }
    }
}
