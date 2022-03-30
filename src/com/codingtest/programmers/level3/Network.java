package com.codingtest.programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

//https://programmers.co.kr/learn/courses/30/lessons/43162
public class Network {

    //DFS 탐색
//    public int searchNetWorkDFS(int[][] computers, int pos, boolean[] visit) {
//        visit[pos] = true;
//
//        for (int j = 0; j < computers[pos].length; j++) {
//            if (pos != j && !visit[j] && computers[pos][j] == 1) {
//                searchNetWork(computers,j,visit);
//            }
//        }
//
//        return 1;
//    }
//
//    public int solution(int n, int[][] computers) {
//        int answer = 0;
//        boolean[] visit = new boolean[n]; //방문 여부 확인
//
//        for (int i = 0; i < n; ++i) {
//            if (!visit[i])
//                answer += searchNetWorkDFS(computers, i, visit);
//        }
//
//        return answer;
//    }

    //BFS 탐색
    public int searchNetWorkBFS(int[][] computers, int n) {
        int count = 0;
        boolean[] visit = new boolean[n];
        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                que.add(i);
                count++;

                while (!que.isEmpty()) {
                    Integer network = que.poll();

                    for (int j = 0; j < computers[network].length; j++) {
                        if (network != j && !visit[j] && computers[network][j] == 1) {
                            visit[j] = true;
                            que.add(j);
                        }

                    }
                }
            }
        }


        return count;
    }

    public int solution(int n, int[][] computers) {
        boolean[] visit = new boolean[n]; //방문 여부 확인
        return searchNetWorkBFS(computers, n);
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };
        Network nw = new Network();
        int solution = nw.solution(n, computers);

        System.out.println("solution = " + solution);

    }
}
