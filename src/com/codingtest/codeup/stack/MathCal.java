package com.codingtest.codeup.stack;

import java.util.Scanner;
import java.util.Stack;

//3127. 수식 계산 1
public class MathCal {
    public static Long getNum(String a){
        String[] values = a.split(" ");
        Stack<Long> stack=new Stack<>();

        for (String value : values) {
            Long data=0L;
            if(value.equals("-") || value.equals("+") || value.equals("*")){    //부호 기호면
                if(!stack.empty()){
                    Long v1 = stack.pop();
                    Long v2 = stack.pop();

                    if(value.equals("-"))
                        data=v2-v1;

                    else if(value.equals("+"))
                        data=v2+v1;

                    else
                        data=v2*v1;
                }
            }

            else
                data=Long.valueOf(value);

            stack.push(data);
        }

        return stack.peek();
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a = sc.nextLine();

        Long num = getNum(a);
        System.out.println(num);
    }
}
