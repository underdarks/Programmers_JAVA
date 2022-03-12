package com.codingtest.boj.dfs_bfs;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

//단지 번호 붙이기
//https://www.acmicpc.net/problem/2667
public class HostNumbering {

    public static void getDanjiNums(int [][]graph, int n){
        PriorityQueue<Integer> list=new PriorityQueue<>();   //단지 내 집의 수(우선 순위 큐)
        Queue<Point> queue=new LinkedList<>();
        boolean [][]visit = new boolean[n][n];


        int count=0;

        for (int i = 0; i < graph.length; i++) {
            count=0;
            for (int j = 0; j < graph[i].length; j++) {
                count=0;
                //집이 있는곳이고 방문하지 않았으면
                if(graph[i][j] == 1 && !visit[i][j])
                    queue.offer(new Point(i,j));

                while (!queue.isEmpty()){
                    Point pos = queue.poll();
                    int row= pos.x;
                    int col= pos.y;

                    if(graph[row][col] == 1 && !visit[row][col]) {
                        count++;
                        visit[row][col]=true;

                        //BFS - 상하좌우 집 Que에 넣기

                        //상
                        if (row - 1 >= 0 && graph[row - 1][col] == 1 && !visit[row - 1][col])
                            queue.offer(new Point(row - 1, col));

                        //하
                        if (row + 1 < n && graph[row + 1][col] == 1 && !visit[row + 1][col])
                            queue.offer(new Point(row + 1, col));

                        //좌
                        if (col - 1 >= 0 && graph[row][col - 1] == 1 && !visit[row][col - 1])
                            queue.offer(new Point(row, col - 1));

                        //우
                        if (col + 1 < n && graph[row][col + 1] == 1 && !visit[row][col + 1])
                            queue.offer(new Point(row, col + 1));


                    }
                }//end of while

                //연결된 단지이고(2이상)
                if(count > 0)
                    list.add(count);

            }//end of inner loop

        }//end of outer loop



        //총 단지수 출력
        System.out.println(list.size());
        while (!list.isEmpty())
            System.out.println(list.poll());

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int [][]graph=new int[n][n];
        Map<Integer,Integer> map=new HashMap<>();



        //1. 그래프 만들기
        for (int i = 0; i < graph.length; i++) {
            String s = br.readLine();
            char[] chars = s.toCharArray();

            for (int j = 0; j < chars.length; j++) {
                graph[i][j]= Integer.parseInt(String.valueOf(chars[j]));
            }

        }

        getDanjiNums(graph,n);
    }
}
