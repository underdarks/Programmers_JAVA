package com.codingtest.programmers.level2;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.PriorityQueue;

//더 맵게
public class MoreSpicy {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();    //1.최소 힙 생성

        for (Integer scovil : scoville)
            pq.add(scovil);

        while (!pq.isEmpty() || pq.size() > 1) {
            Integer first = pq.poll();

            if (first < K) {                    //2. 가장 맵지 않은 음식의 스코빌 지수 확인
                if (pq.isEmpty()) return -1;    //5. 모든 음식을 스코빌 지수를 K이상으로 못만드는 경우

                else {                          //3. 스코빌 지수보다 적으면 2번 째로 맵지 않은 음식이랑 섞는다
                    Integer second = pq.poll();
                    pq.add(second * 2 + first);
                    answer++;
                }
            }
            else break;                         //4. 가장 맵지 않음 음식의 스코빌 지수가 K 이상이면 종료한다
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 10000;
        MoreSpicy ms = new MoreSpicy();
        int solution = ms.solution(scoville, k);

        System.out.println("solution = " + solution);
    }
}
