package com.codingtest.programmers_school.week1;

import java.util.*;

public class BaseStation {

//    public List<Integer> doCheck(int[] stations, int w, int length){
//        List<Integer> list=new ArrayList<>();
//        int count=0;
//
//        for (int station : stations) {
//
//        }
//
//        for (int j = 0; j < check.length; j++) {
//            if(!check[j])    //통신안되면
//                count++;
//
//            else {
//                list.add(count);
//                count=0;
//            }
//        }
//
//        if(count > 0)
//            list.add(count);
//
//        return list;
//    }

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int x = 2 * w + 1;
        int rightIndex = 0;
        int value = 0;

        for (int station : stations) {
            int currentIndex = station - 1;    //현재 기지국 위치(인덱스)
            value = Math.max(currentIndex - w - rightIndex, 0); //왼쪽 범위값 구하기
            rightIndex = currentIndex + w + 1;       //맨오른쪽 기지국의 위치(인덱스)

            int mok = value / x;
            answer += mok;

            if (value % x > 0)   //나머지가 있으면
                answer += 1;
        }

        //오른쪽 범위 값구하기
        value = n - rightIndex;
        int mok = value / x;
        answer += mok;

        if (value % x > 0)   //나머지가 있으면
            answer += 1;


        return answer;
    }

    public static void main(String[] args) {
        int n = 16;
        int[] stations = {9};
        int w = 2;

        BaseStation baseStation = new BaseStation();
        int solution = baseStation.solution(n, stations, w);
        System.out.println(solution);
    }


}
