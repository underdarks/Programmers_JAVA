package com.codingtest.programmers.level3;

//https://programmers.co.kr/learn/courses/30/lessons/43162
public class Network {

    //DFS 탐색
    public int searchNetWork(int[][] computers, int pos, boolean[] visit) {
        visit[pos] = true;

        for (int j = 0; j < computers[pos].length; j++) {
            if (pos != j && !visit[j] && computers[pos][j] == 1) {
                searchNetWork(computers,j,visit);
            }
        }

        return 1;
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n]; //방문 여부 확인

        for (int i = 0; i < n; ++i) {
            if (!visit[i])
                answer += searchNetWork(computers, i, visit);
        }

        return answer;
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
