package com.codingtest.codeup.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//4564 : 계단 오르기
public class Stairs {

    public static int getMaxScore(List<Integer> list,int n){
        int sum=0;
        int count=0;


        getMaxScore(list,n-1);
        getMaxScore(list,n-2);

        return 0;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int stairs = sc.nextInt();
        List<Integer> list=new ArrayList<>();

        for (int i = 0; i < stairs; i++) {
            list.add(sc.nextInt());
        }

        getMaxScore(list,list.size());

    }
}
