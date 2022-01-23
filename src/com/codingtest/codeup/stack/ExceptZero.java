package com.codingtest.codeup.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

//3117 : 0은 빼!
public class ExceptZero {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<Integer> list=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        int sum=0;
        int k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            list.add(sc.nextInt());
        }

        for (Integer data : list) {
            if(data == 0) {
                if(!stack.empty())
                    stack.pop();
            }

            else
                stack.push(data);
        }

        while(!stack.empty()){
            sum+=stack.pop();
        }

        System.out.println(sum);

    }
}
