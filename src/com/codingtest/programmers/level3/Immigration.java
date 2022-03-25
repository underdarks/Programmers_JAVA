package com.codingtest.programmers.level3;

import java.util.Arrays;
import java.util.PriorityQueue;

//입국 심사
public class Immigration {
    public long solution(int n, int[] times) {
        long answer = 0;
        PriorityQueue<Long> pq=new PriorityQueue<Long>();

        for (int time : times)
            pq.add(Long.valueOf(time));

        while(n>0){
            Long t = pq.poll();
            n--;
        }

        return pq.poll();
    }

    public static void main(String[] args) {
        int n = 6;
        int[] times = {1,8,7,10};
        Immigration immigration = new Immigration();
        long solution = immigration.solution(n, times);

        System.out.println("solution = " + solution);

    }
}
