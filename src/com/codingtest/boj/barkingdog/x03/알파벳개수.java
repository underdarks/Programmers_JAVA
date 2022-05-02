package com.codingtest.boj.barkingdog.x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10808
public class 알파벳개수 {
    public static void main(String[] args) throws IOException {
        int []words=new int[26];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s = br.readLine();

        char[] chars = s.toCharArray();
        for (char c : chars)
            words[c-'a']++;


        for (int word : words)
            System.out.print(word+" ");


    }
}
