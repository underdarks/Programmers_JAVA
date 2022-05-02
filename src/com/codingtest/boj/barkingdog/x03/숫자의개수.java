package com.codingtest.boj.barkingdog.x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2577
public class 숫자의개수 {
    public static void main(String[] args) throws IOException {
        int [] nums =new int[10];
        long sum=1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Integer> list=new ArrayList<>();

        for(int i=0;i<3;i++)
            list.add(Integer.parseInt(br.readLine()));

        for (Integer num : list)
            sum*=num;

        String s = String.valueOf(sum);

        for (char c : s.toCharArray())
            nums[c-'0']++;

        for (int num : nums)
            System.out.println(num);




    }
}
