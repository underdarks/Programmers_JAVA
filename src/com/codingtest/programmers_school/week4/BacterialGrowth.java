package com.codingtest.programmers_school.week4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BacterialGrowth {

    public class pos {
        private int x;
        private int y;

        public pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public void clear(boolean[][] visits) {
        for (boolean[] visit : visits) {
            Arrays.fill(visit, false);
        }
    }


    public int[][] solution(int rows, int columns, int max_virus, int[][] queries) {
        int[][] answer = new int[rows][columns];
        Queue<pos> que = new LinkedList<>();
        boolean[][] visit = new boolean[rows][columns];

        //상하좌우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int[] query : queries) {
            int x = query[0] - 1;   //행
            int y = query[1] - 1;   //열

            clear(visit);
            que.offer(new pos(x, y));

            while (!que.isEmpty()) {
                pos cell = que.poll();
                int row = cell.getX();   //행
                int col = cell.getY();   //열

                //해당 격자의 바이러스 수가 최대 바이러스 수 보다 작으면
                if (answer[row][col] < max_virus)
                    answer[row][col] += 1;

                //격자 바이러스 수 == 최대 바이러스 수 이면 해당 격자에서 상하좌우 격자의 1씩 바이러스 증가
                else {
                    //BFS 탐색 (상 하 좌 우 격자 1씩 증가)
                    for (int i = 0; i < dx.length; i++) {
                        int xPos = row + dx[i];
                        int yPos = col + dy[i];

                        if (xPos >= 0 && yPos >= 0 && xPos < rows && yPos < columns && !visit[xPos][yPos]) {    //한 쿼리에 동일한 칸에는 최대 한번의 세균 증식만 일어남
                            visit[xPos][yPos]=true;
                            que.offer(new pos(xPos, yPos));
                        }

                    }
                    //BFS 탐색 (상 하 좌 우 격자 1씩 증가)

//                        //상
//                        if (row - 1 >= 0 && !visit[row - 1][col])
//                            que.offer(new pos(row - 1, col));
//
//                        //하
//                        if (row + 1 < rows && !visit[row + 1][col])
//                            que.offer(new pos(row + 1, col));
//
//                        //좌
//                        if (col - 1 >= 0 && !visit[row][col - 1])
//                            que.offer(new pos(row, col - 1));
//
//                        //우
//                        if (col + 1 < columns && !visit[row][col + 1])
//                            que.offer(new pos(row, col + 1));
                }

            }
        }


        return answer;
    }

    public static void main(String[] args) {
        int rows = 3;
        int cols = 4;
        int maxVirus = 2;
        int[][] queries = {
                {3, 2},
                {3, 2},
                {2, 2},
                {3, 2},
                {1, 4},
                {3, 2},
                {2, 3},
                {3, 1},
        };

        BacterialGrowth bacterialGrowth = new BacterialGrowth();
        int[][] solution = bacterialGrowth.solution(rows, cols, maxVirus, queries);

        for (int i = 0; i < solution.length; i++) {
            int[] ints = solution[i];
            for (int j = 0; j < ints.length; j++) {
                int anInt = ints[j];
                System.out.print(anInt + " ");

            }
            System.out.println();

        }


    }
}
