package com.codingtest.boj.binary_search;

import java.io.*;
import java.util.*;

public class NumCard {

    public static void hasNumCard(int[] sangenCards, Map<Integer, Integer> map, int value,StringBuilder stringBuilder) {
//        for (int sangenCard : sangenCards) {
//            map.put(sangenCard,1);
//        }
//
//        for (int findCard : findCards) {
//            Integer value = map.getOrDefault(findCard, -1);
//            if(value == -1)
//                System.out.print("0 ");
//            else
//                System.out.print("1 ");
//        }


        //1.정렬
        int start = 0;
        int end = sangenCards.length - 1;

        //이미 숫자가 있으면
        if (map.getOrDefault(value, 1000) != 1000)
            stringBuilder.append("1 ");

        else {
            while (start <= end) {
                int mid = (start + end) / 2;
//                map.put(sangenCards[mid], 1);

                //숫자 찾았으면
                if (sangenCards[mid] == value) {
                    map.put(value, 1);
                    stringBuilder.append("1 ");     //버퍼에 담기
                    break;
                }

                if (value > sangenCards[mid])
                    start = mid + 1;
                else
                    end = mid - 1;
            }

            //못 찼으면
            if (start > end)
                stringBuilder.append("0 ");
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = 0;
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder stringBuilder=new StringBuilder();

        int[] sangenCards = new int[n];   //상근이 가지고 있는 카드


        for (int i = 0; i < sangenCards.length; i++)
            sangenCards[i] = sc.nextInt();

        Arrays.sort(sangenCards);
        m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int value = sc.nextInt();
            hasNumCard(sangenCards, map, value,stringBuilder);
        }

        System.out.print(stringBuilder.toString());

    }
}
