package com.codingtest.programmers.level3;

import java.util.Collections;
import java.util.PriorityQueue;

public class CollectSticker {

    //인덱스 찾는 함수
    public int getFindIndex(int []sticker, int findValue){
        for (int i = 0; i < sticker.length; i++) {
            if(sticker[i] == findValue)
                return i;
        }

        return -1;
    }

    public int solution(int sticker[]) {
        int answer =0;
        int oddSum=0;
        int notOddSum=0;
        boolean []visit= new boolean[sticker.length];
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for (Integer integer : sticker)
            pq.add(integer);

        while(!pq.isEmpty()){
            Integer stick = pq.poll();
            int idx = getFindIndex(sticker, stick);

            //찢긴스티커가 아니라면
            if(!visit[idx]){
                answer +=stick;
                //스티커 양옆을 찢느다.

                int leftIdx=idx-1;
                int rightIdx=idx+1;

                if (leftIdx <0)
                    leftIdx=sticker.length-1;


                if(rightIdx >= sticker.length)
                    leftIdx=0;

                visit[leftIdx]=true;
                visit[rightIdx]=true;
            }
        }

        for (int i = 0; i < sticker.length; i+=2)
            oddSum += sticker[i];


        for (int i = 1; i < sticker.length; i+=2)
            notOddSum += sticker[i];


        oddSum=Math.max(oddSum,notOddSum);

        return answer > oddSum ? answer: oddSum;
    }


    public static void main(String[] args) {
        int[] sticker = {1,3,2,5,4};
        CollectSticker c = new CollectSticker();
        int solution = c.solution(sticker);

        System.out.println("solution = " + solution);
    }
}
