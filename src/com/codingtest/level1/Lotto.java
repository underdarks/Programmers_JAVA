package com.codingtest.level1;

import java.util.*;

import java.util.stream.IntStream;

public class Lotto {
        public Map<Integer,Integer> setRank(){
            //당첨 갯수,순위 Map 구현
            Map<Integer,Integer> score=new HashMap<>();

            score.put(6,1);
            score.put(5,2);
            score.put(4,3);
            score.put(3,4);
            score.put(2,5);
            score.put(1,6);
            score.put(0,6);

            return score;
        }

        public int[] solution(int[] lottos, int[] win_nums) {
            int []answer=new int[2];
            int zero_count=0;   //숫자가 0인 갯수
            int totalCount=0;   //복권 로또 일치 개수
            Map<Integer,Integer> score=setRank();

            //시간복잡도 O(n^2)
            for (int i : lottos) {
                //0인 숫자 찾기
                if(i == 0)  zero_count++;

                //로또 숫자 확인
                else
                    if (Arrays.stream(win_nums).anyMatch(val -> val == i) == true)
                        totalCount++;
            }

            answer[0]=score.get(totalCount+zero_count); //최고점수
            answer[1]=score.get(totalCount);            //최저점수

            return answer;
        }





}
