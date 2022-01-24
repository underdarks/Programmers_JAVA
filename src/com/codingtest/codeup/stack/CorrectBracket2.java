package com.codingtest.codeup.stack;

import java.util.Scanner;
import java.util.Stack;

//3129 : 올바른 괄호 2
public class CorrectBracket2 {
    public static String isCorrectParenthesis(String str){
        Stack<Character> stack=new Stack<>();

        for (String s : str.split("")) {
            if(s.equals(")")) {
                if(stack.isEmpty())
                    return "bad";
                stack.pop();
            }

            else
                stack.push('(');
        }

        return stack.isEmpty() == true ? "good" : "bad";
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String  str = sc.next();
        String correctParenthesis = isCorrectParenthesis(str);
        System.out.println(correctParenthesis);
    }
}
