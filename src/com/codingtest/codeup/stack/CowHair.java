package com.codingtest.codeup.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//3130 : 소들의 헤어스타일
public class CowHair {

    public static int getCowCount(List<Integer> list){
        int cowCount=0;

        for (int i = 0; i < list.size()-1; i++) {
            int cow=list.get(i);
            for(int j=i+1; j< list.size();j++){
                if(cow>list.get(j))
                    cowCount++;
                else
                    break;

            }
        }

        return cowCount;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list=new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int cowCount = getCowCount(list);
        System.out.println(cowCount);
    }
}
