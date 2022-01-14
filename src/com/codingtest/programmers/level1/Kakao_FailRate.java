package com.codingtest.programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

//실패율
public class Kakao_FailRate {

    public int[] descendingSort(int N,HashMap<Double, ArrayList<Integer>> map)
    {
        int []answer=new int[N];
        int i=0;

        ArrayList<Double> keys = new ArrayList<>(map.keySet());
        keys.sort(Collections.reverseOrder());

        for (Double key : keys) {
            ArrayList<Integer> list=map.get(key);
            for (Integer value : list) {
                answer[i++]=value+1;
            }
        }

        return answer;
    }

    public int[] solution(int N, int[] stages) {
        double []answer = new double[N];  //스테이지 개수 만큼 생성
        double beforeLoserCount=0;
        double loserCount =0;                //스테이지 실패자
        double totalChallenger=stages.length;  //총 도전자
        HashMap<Double, ArrayList<Integer>> map=new HashMap<Double, ArrayList<Integer>>();

        for(int i=0;i<N;i++){
            loserCount =0;
            for(int j=0;j< stages.length;j++) {
                if (stages[j] < i + 2)    //스테이지를 클리어 못했으면
                    loserCount++;
            }

            double key=0.0;
            //굉장히 문제가 생길 코드!!
            //분모가 0일 경우 생각해야한다.
            if(totalChallenger-beforeLoserCount > 0)
                key=((loserCount-beforeLoserCount) / (totalChallenger-beforeLoserCount));

            ArrayList<Integer> list=new ArrayList<>();
            if(map.containsKey(key)){ //중복값이 있으면
                list=map.get(key);
                list.add(i);
                Collections.sort(list);
            }
            else{
                list.add(i);
            }

            map.put(key,list);
            beforeLoserCount=loserCount;
        }

        return descendingSort(N,map);
    }

    public static void main(String[] args) {
        int []stages={4,4,4,4};
        Kakao_FailRate f=new Kakao_FailRate();
        int []result=f.solution(6,stages);
        for (int i : result) {
            System.out.println("i = " + i);
        }
    }

}
