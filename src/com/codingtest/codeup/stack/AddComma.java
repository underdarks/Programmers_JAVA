package com.codingtest.codeup.stack;

import java.util.Scanner;
import java.util.Stack;

//2016 : 천단위 구분기호
public class AddComma {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String value = sc.next();
        StringBuilder stringBuilder=new StringBuilder();
        int count=0;

        char[] chars = value.toCharArray();
        for (int i = chars.length-1; i>=0; i--) {
            count++;
            stringBuilder.append(chars[i]);

            if(count%3==0 && i>0)    //3자리수 콤마
                stringBuilder.append(",");
        }

        System.out.println(stringBuilder.reverse());
    }
}
