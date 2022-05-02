package com.codingtest.company_coding_test.ESTSOFT;

import java.util.*;

public class ct2 {

    public static Map<Integer, Integer> partCounts;     //각 완제품 당 필요한 부품 개수 저장
    public static int maxProductCount = Integer.MIN_VALUE;      //최대 제품 생산량 개수

    //완제품에 필요한 부품 개수
    public void setNumOfParts(int[][] needs) {
        partCounts = new HashMap<>();

        for (int i = 0; i < needs.length; i++) {
            for (int j = 0; j < needs[i].length; j++) {
                if (needs[i][j] == 1) {
                    Integer count = partCounts.getOrDefault(i, 0);
                    partCounts.put(i, count + 1);
                }
            }
        }
    }

    //최대 완제품 생산량 구하기
    public void getMaxMakeProductCount(List<Integer> robots, int[][] needs) {
        int count=0;
        Map<Integer, Integer> parts = new HashMap<>(partCounts);

        //부품 처리 로봇
        for (Integer robot : robots) {
            for (int i = 0; i < needs.length; i++) {
                if (needs[i][robot] == 1)   //needs[x][y] 값이 1이면 x번 물건을 만드는데 y번 부품이 필요하다 의미입니다.
                    parts.put(i,parts.getOrDefault(i,0) -1);
            }

        }

        //완제품 생산된 갯수 확인
        for (Integer value : parts.values()) {
            if(value == 0)
                count++;
        }

        maxProductCount=Math.max(maxProductCount, count);
    }


    //로봇 순서쌍 구하기(백트래킹)
    public void getRobotCombination(int[] arr, boolean[] visited, int start,
                                    int n, int r, int[][] needs) {
        if (r == 0) {
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (visited[i])
                    list.add(arr[i]);
            }

            getMaxMakeProductCount(list, needs);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            getRobotCombination(arr, visited, i + 1, n, r - 1, needs);
            visited[i] = false;
        }
    }


    public int solution(int[][] needs, int r) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < needs[0].length; i++)
            list.add(i);

        int[] robots = list.stream().mapToInt(i -> i).toArray();    //r의 경우의 수
        boolean[] visited = new boolean[robots.length];

        //1. 각 완제품당 필요한 부품 개수 구하기
        setNumOfParts(needs);

        //2. 로봇 순서 쌍 구하기 및 개수 구하기
        for (int i = 1; i <= r; i++)
            getRobotCombination(robots, visited, 0, robots.length, i, needs);

        return maxProductCount;
    }

    public static void main(String[] args) {
        int[][] needs = {
                {1, 0, 0},
                {1, 1, 0},
                {1, 1, 0},
                {1, 0, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        int r = 2;

        ct2 c = new ct2();
        int solution = c.solution(needs, r);

        System.out.println("solution = " + solution);
    }
}
