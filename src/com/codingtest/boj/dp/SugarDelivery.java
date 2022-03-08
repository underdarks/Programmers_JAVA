package com.codingtest.boj.dp;

import java.io.*;
import java.util.StringTokenizer;

//설탕배달
//https://www.acmicpc.net/problem/2839
public class SugarDelivery {

    public static int getMinBag(int n){
        int bag1=5;
        int bag2=3;

        return 0;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int minBag = getMinBag(n);
        bw.write(minBag);

    }
}
