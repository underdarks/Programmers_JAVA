package com.codingtest.codeup.binarysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//2631 : 보물 찾기
public class Treasure {
    public static int getTreasure(List<Integer> list,int k){
        int count=0;
        int sum=0;

        for (int i = 0; i < list.size(); i++) {
            sum=list.get(i);

            for(int j=i+1;j< list.size() && sum<k;j++){
                sum+=list.get(j);
                if(sum == k)
                    count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        List<Integer> list=new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        System.out.println(getTreasure(list,k));

    }
}
