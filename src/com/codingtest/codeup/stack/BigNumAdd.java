package com.codingtest.codeup.stack;

import java.util.Scanner;
import java.util.Stack;

//3021 : 큰 수 덧셈
public class BigNumAdd implements MyStack{
    public static String getBigNumAdd(String a,String b){
        String tag=a.length() > b.length() ? "a":"b";
        Stack<Integer> stackA=new Stack<>();
        Stack<Integer> stackB=new Stack<>();

        int sum=0;
        int mok=0;

        StringBuilder str=new StringBuilder();


        for (char c : a.toCharArray()) {
            stackA.push(c-'0'); //숫자 값
        }

        for (char c : b.toCharArray()) {
            stackB.push(c-'0'); //숫자 값
        }



        while(!stackA.empty() && !stackB.empty()){
            int v1=stackA.pop();
            int v2=stackB.pop();
            sum=v1+v2+mok;
            mok=sum/10;
            sum%=10;
            str.append(sum);
        }

        //a가 더 길면
        if(tag.equals("a")){
            while(!stackA.empty()){
                int v=stackA.pop();
                sum=v+mok;
                mok=sum/10;
                sum%=10;
                str.append(sum);
            }
        }

        //b가 더 길면
        else{
            while(!stackB.empty()){
                int v=stackB.pop();
                sum=v+mok;
                mok=sum/10;
                sum%=10;
                str.append(sum);

            }
        }

        if(mok>0)
            str.append(1);

        return str.reverse().toString();
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String  a = sc.next();
        String  b = sc.next();

        System.out.println(getBigNumAdd(a,b));

    }
}
