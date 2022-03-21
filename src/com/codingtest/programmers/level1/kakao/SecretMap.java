package com.codingtest.programmers.level1.kakao;

import java.util.ArrayList;
import java.util.List;

public class SecretMap {

    public String fillZero(int n,String s){
        int len=n-s.length();
        StringBuilder result=new StringBuilder();

        for (int i = 0; i < len; i++) {
             result.append("0");
        }

        return  result.toString()+s;
    }


    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < arr1.length; i++) {
            //or 연산
            answer[i]=Integer.toBinaryString( arr1[i] | arr2[i]);
        }

        for (int i = 0; i < answer.length; i++) {
            String value = answer[i];
            if(value.length() <n)
                value=fillZero(n,value);

            answer[i]= value.replaceAll("0"," ").replaceAll("1","#");
        }


        return answer;
    }


    public static void main(String[] args) {
        int n=6;
        int []arr1={46, 33, 33, 22, 31,50};
        int []arr2={27, 56, 19, 14, 14,10};

        System.out.println(9 | 30);
        String s = Integer.toBinaryString(9 | 30);
        System.out.println("s = " + s);

        SecretMap secretMap=new SecretMap();
        String[] solution = secretMap.solution(n, arr1, arr2);


    }
}
