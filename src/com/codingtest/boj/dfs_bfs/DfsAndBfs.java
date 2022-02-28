package com.codingtest.boj.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1260(실버 2)
public class DfsAndBfs {

    //DFS로 구현(재귀)
    public static void findVirusComputersByDFS_Recursion(int [][]graph,boolean []visit,int vertex){
        if(!visit[vertex]) {
            System.out.print(vertex+1+" ");
            visit[vertex] = true;

            for (int i = 0; i < graph.length; i++) {
                if (!visit[i] && graph[vertex][i] == 1)
                    findVirusComputersByDFS_Recursion(graph, visit, i);
            }
        }
    }

    //DFS로 구현(Stack)
    public static void findVirusComputersByDFSUsing_Stack(int [][]graph,int startVertex){
        boolean []visit=new boolean[graph.length];
        Stack<Integer> stack=new Stack<>();
        stack.push(startVertex);

        while(!stack.isEmpty()){
            Integer vertex = stack.pop();
            if(!visit[vertex])  //방문하지 않았으면
                System.out.print(vertex+1+" ");

            visit[vertex]=true; //방문

            for(int i=0;i<graph.length;i++){
                if(!visit[i] && graph[vertex][i] == 1)   //방문하지 않고 연결되어 있으면
                    stack.push(i);
            }

        }

    }

    //BFS로 구현
    public static void findVirusComputersByBFS(int [][]graph,int startVertex){
        boolean []visit=new boolean[graph.length];

        Queue<Integer> que=new LinkedList<Integer>();   //노드
        que.offer(startVertex);   //첫번째 노드

        while (!que.isEmpty()){
            Integer vertex = que.poll();    //Dequeue

            if(!visit[vertex])  //방문하지 않았으면
                System.out.print(vertex+1+" ");

            visit[vertex]=true;

            for(int i=0;i<graph.length;i++){
                if(!visit[i] && graph[vertex][i] == 1)   //방문하지 않고 연결되어 있으면
                    que.offer(i);
            }
        }

    }


    public static void main(String[] args) {
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            String str = br.readLine();
            st=new StringTokenizer(str);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int vertex = Integer.parseInt(st.nextToken());

            int [][]graph=new int[n][n];                //2차원 배열로 구현


            for (int i = 0; i < m; i++) {
                String s = br.readLine();
                st=new StringTokenizer(s);

                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                //양방향 연결
                graph[v1-1][v2-1]=1;
                graph[v2-1][v1-1]=1;
            }

            boolean []visit=new boolean[n];

            findVirusComputersByDFS_Recursion(graph,visit,vertex-1);
            System.out.println();
            findVirusComputersByBFS(graph,vertex-1);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
