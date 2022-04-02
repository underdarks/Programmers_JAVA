package com.codingtest.programmers.dev_match_2022_backend_1;

import java.util.*;

public class Second {

    public int search(char[][] grid, char value, Map<Character, Integer> count) {
        int rows = grid.length;
        int cols = grid[0].length;
        Map<Character, Integer> check = new HashMap<>(count);

        boolean[][] visit = new boolean[rows][cols];
        Queue<int[]> que = new LinkedList<>();

        que.add(new int[]{0, 0});

        while (!que.isEmpty()) {
            int[] poll = que.poll();
            int xPos = poll[0];
            int yPos = poll[1];

            visit[xPos][yPos] = true;


            //상
            if (xPos - 1 >= 0 && !visit[xPos - 1][yPos] && grid[xPos - 1][yPos] == value) {
                visit[xPos - 1][yPos] = true;
                que.add(new int[]{xPos - 1, yPos});
            }

            //하
            if (xPos + 1 < rows && !visit[xPos + 1][yPos] && grid[xPos + 1][yPos] == value) {
                visit[xPos + 1][yPos] = true;
                que.add(new int[]{xPos + 1, yPos});
            }

            //좌
            if (yPos - 1 >= 0 && !visit[xPos][yPos - 1] && grid[xPos][yPos - 1] == value) {
                visit[xPos][yPos - 1] = true;
                que.add(new int[]{xPos, yPos - 1});
            }

            //우
            if (yPos + 1 < cols && !visit[xPos][yPos + 1] && grid[xPos][yPos + 1] == value) {
                visit[xPos][yPos + 1] = true;
                que.add(new int[]{xPos, yPos + 1});
            }
        }


        return 1;
    }

    public char[][] makeSettle(String[] grid) {
        char[][] settle = new char[grid.length][grid[0].length()];

        for (int i = 0; i < grid.length; i++) {
            String s = grid[i];
            char[] chars = s.toCharArray();

            for (int j = 0; j < chars.length; j++) {
                settle[i] = chars.clone();
            }
        }

        return settle;
    }

    public Map<Character, Integer> getCount(String[] grid) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            String s = grid[i];
            char[] chars = s.toCharArray();

            for (int j = 0; j < chars.length; j++) {
                Integer count = map.getOrDefault(chars[j], 0);
                map.put(chars[j], count + 1);
            }
        }

        return map;
    }


    public int solution(String[] grid) {
        int answer = 0;

        char[][] settle = makeSettle(grid);
        Map<Character, Integer> count = getCount(grid);
        char[] c = {'a', 'b', 'c'};

        for (int i = 0; i < 3; i++) {
            answer += search(settle, c[i], count);
        }


        return answer;
    }

    public static void main(String[] args) {
        String[] grid = {
                "??b",
                "abc",
                "cc?"
        };
        Second sc = new Second();
        int solution = sc.solution(grid);

        System.out.println("solution = " + solution);

    }
}
