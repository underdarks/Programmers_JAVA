package com.codingtest.programmers_school.week1;

import java.util.*;
import java.util.stream.IntStream;

public class BaseStation {

    public void doCheck(boolean[] check, int w, int station){
        int lastIndex=station+w >= check.length ? check.length-1: station+w;    //맨끝 인덱스만 체크
        check[lastIndex]=true;
    }

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int index=0;
        boolean []check=new boolean[n];

        for (int i = 0; i < check.length; i++) {
            //통신 여부 확인
            if(!check[i]) {
                if(index < stations.length && stations[index] -1 <= i+w)   //기지국이 이미 설치되어 있으면
                {
                    int station = stations[index++]-1;  //기지국의 인덱스
                    doCheck(check,w,station);
                    i=station+w;
                }

                else {  //기지국 미설치이면
                    doCheck(check, w, i + w);
                    i += w * 2;
                    answer++;
                }
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
