package com.codingtest.barkingdog.x02;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2576
//홀수
public class 숫자 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s = br.readLine();
        st=new StringTokenizer(s);

        BigInteger a=new BigInteger(st.nextToken());
        BigInteger b=new BigInteger(st.nextToken());

        BigInteger min = a.min(b);
        BigInteger max = a.max(b);

        System.out.println(max.subtract(min).subtract(BigInteger.valueOf(1)));
        for (BigInteger i = min.add(BigInteger.valueOf(1)); i.compareTo(max) == -1; i=i.add(BigInteger.valueOf(1)))
            System.out.print(i+" ");


    }
}
