package com.codingtest.boj.barkingdog.x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1475
public class 방번호 {
    public static void main(String[] args) throws IOException {
        int count = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<boolean[]> list = new ArrayList<>();
        list.add(new boolean[10]);

        String n = br.readLine();
        boolean tag=false;

        int k=1;
        for (char c : n.toCharArray()) {
            System.out.println("c = " + k++);
            int idx = c - '0';
            tag=false;

            for(int i=0;i<list.size();i++){
                boolean[] nums = list.get(i);

                if (!nums[idx]) {
                    nums[idx] = true;
                    break;
                }
                //6이랑 9는 상호 교환 가능
                else if (idx == 6 && !nums[idx + 3]) {
                    nums[idx + 3] = true;
                    break;
                }
                else if (idx == 9 && !nums[idx - 3]) {
                    nums[idx - 3] = true;
                    break;
                }

                else {
                    if( i == list.size()-1)
                        tag = true;
                }

            }

            if(tag) {
                list.add(new boolean[10]);
                count++;
            }

        }


        System.out.println(count);

    }
}
