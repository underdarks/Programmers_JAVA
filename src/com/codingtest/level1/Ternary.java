package com.codingtest.level1;

import java.util.ArrayList;
import java.util.List;

//3진법 뒤집기
public class Ternary {
    public int solution(int n) {
        int x=3;        //n진법
        int answer = 0;
        int m=1;
        List<Integer> list=new ArrayList<>();

        //1. 10진법 -> 3진법 변환
        while (n>0){
            list.add(n%x);  //나머지
            n=n/x;  //몫
        }

        //2. 3진법 -> 10진법 변환
        for (int i=list.size()-1;i>=0;i--) {
            answer+=list.get(i)*m;
            m*=x;
        }

        return answer;
    }

    public static void main(String[] args) {
        Ternary t=new Ternary();
        System.out.println(t.solution(45));
    }
}
