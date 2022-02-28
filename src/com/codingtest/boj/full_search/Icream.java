package com.codingtest.boj.full_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/2422
public class Icream {

//    public static int getMethod(int n,){
//
//        for(int i=1;i<n;i++){
//
//        }
//
//    }
//

    public static void main(String[] args){
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());


            String s1 = br.readLine();
            for (int i = 0; i < m; i++) {
                Integer.parseInt(st.nextToken());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
