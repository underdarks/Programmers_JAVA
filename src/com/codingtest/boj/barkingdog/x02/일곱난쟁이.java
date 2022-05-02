package com.codingtest.boj.barkingdog.x02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 일곱난쟁이 {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            List<Integer> heights = new ArrayList<>();
            int sum = 0;

            for (int i = 0; i < 9; i++) {
                int height = Integer.parseInt(br.readLine());
                heights.add(height);
                sum += height;
            }

            Collections.sort(heights);

            //9명의 난쟁이들 키의 합 - 2명의 난쟁이 키의합 = 100인 경우 찾기
            for (int i = 0; i < heights.size(); i++) {
                int one = heights.get(i);
                for (int j = i + 1; j < heights.size(); j++) {
                    int two = heights.get(j);

                    if (sum - one - two == 100) {
                        for (Integer height : heights) {
                            if (!height.equals(one) && !height.equals(two))
                                System.out.println(height);
                        }

                        return;
                    }

                }
            }

        } catch (Exception e) {

        }
    }
}
