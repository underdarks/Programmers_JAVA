package com.codingtest.programmers_school.week3;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class GameMap {

    //좌표 위치 클래스
    public class Position{
        private int x;  //x 좌표
        private int y;  //y 좌표
        private int count;  //움직이는 횟수

        public Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }


    public int solution(int[][] maps) {
        int answer = Integer.MAX_VALUE;
        int row =maps.length;      //행
        int col=maps[0].length;    //열

        boolean [][]visit=new boolean[row][col];    //방문체크

        Queue<Position> que=new LinkedList<>();
        que.offer(new Position(0,0,1));

        while(!que.isEmpty()){
            Position pos = que.poll();

            int x = pos.getX();
            int y = pos.getY();
            int count= pos.getCount();

            if(!visit[x][y]) {    //방문하지 않았으면
                visit[x][y]=true;

                if (x == row - 1 && y == col - 1)   //끝지점에 도착헀으면
                    answer = Math.min(answer, count);

                /* BFS 탐색(아래 -> 오른 -> 위 -> 왼쪽순으로 벽이 없는 자리 큐에 넣는다) */
                //아래쪽
                if (x + 1 < row && maps[x + 1][y] == 1 && !visit[x+1][y])
                    que.offer(new Position(x + 1, y, count + 1));

                //오른쪽
                if (y + 1 < col && maps[x][y + 1] == 1 && !visit[x][y+1])
                    que.offer(new Position(x, y + 1, count + 1));

                //위쪽
                if (x - 1 >= 0 && maps[x - 1][y] == 1 && !visit[x-1][y])
                    que.offer(new Position(x - 1, y, count + 1));

                //왼쪽
                if (y - 1 >= 0 && maps[x][y - 1] == 1 && !visit[x][y-1])
                    que.offer(new Position(x, y - 1, count + 1));


            }
        }


        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void main(String[] args) throws IOException {
        GameMap gameMap=new GameMap();

        int[][] graph = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        };


        int solution = gameMap.solution(graph);
        System.out.println("solution = " + solution);
    }
}
