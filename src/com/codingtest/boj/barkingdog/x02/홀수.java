package com.codingtest.boj.barkingdog.x02;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2576
//홀수
public class 홀수 {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int sum=0;
            PriorityQueue<Integer> pq=new PriorityQueue<>();

            for (int i = 0; i < 7; i++) {
                int value = Integer.parseInt(br.readLine());

                if(value % 2 != 0) {
                    sum+=value;
                    pq.add(value);
                }


            }

            if(sum == 0)
                System.out.println(-1);

            else
                System.out.println(sum + "\n" + pq.poll());


        } catch (Exception e) {

        }
    }
}
