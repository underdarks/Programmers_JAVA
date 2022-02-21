package com.codingtest.programmers_school.week1;

import java.util.*;
import java.util.stream.IntStream;

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
        int answer=0;
        int now=0;  // 1<=n<=10,000
        int idx=0;
        int distance=2*w+1;

        while (now < n){
            if (idx < stations.length && now + w >= stations[idx] - 1)    //기지국 이면
            {
                now = stations[idx] + w;
                idx++;
            }

            //기지국이 아니면
            else {
                answer++;   //기지국 설치
                now += distance;
            }
        }

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
