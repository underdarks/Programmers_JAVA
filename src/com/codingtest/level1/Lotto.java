package com.codingtest.level1;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.stream.IntStream;

public class Lotto {
        public int[] solution(int[] lottos, int[] win_nums) {
            List<Integer> result=new ArrayList<Integer>();

            Integer[] answer = {};
            int zero_count=0;   //숫자가 0인 갯수
            int totalCount=0;   //복권 로또 일치 개수

            //시간복잡도 O(n^2)
            for (int i : lottos) {
                //0인 숫자 찾기
                if(i == 0)
                    zero_count++;

                //로또 숫자 확인
                else
                    if (Arrays.stream(win_nums).anyMatch(val -> val == i) == true)
                        totalCount++;

            }

            //최고 등수
            switch (totalCount+zero_count){
                case 6: result.add(1);
                    break;

                case 5: result.add(2);
                    break;

                case 4: result.add(3);
                    break;

                case 3: result.add(4);
                    break;

                case 2: result.add(5);
                    break;

                default: result.add(6);
                    break;
            }

            //최저점수
            switch (totalCount){
                case 6: result.add(1);
                    break;

                case 5: result.add(2);
                    break;

                case 4: result.add(3);
                    break;

                case 3: result.add(4);
                    break;

                case 2: result.add(5);
                    break;

                default: result.add(6);
                    break;
            }

            return result.stream().mapToInt(i->i).toArray();
        }





}
