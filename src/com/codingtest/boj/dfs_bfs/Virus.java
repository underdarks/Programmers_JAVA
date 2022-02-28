package com.codingtest.boj.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2606
public class Virus {

    static int count=0;
    //DFS로 구현(재귀)
    public static void findVirusComputersByDFS_Recursion(int [][]graph,boolean []visit,int vertex){
        if(!visit[vertex]) {
            count++;
            visit[vertex] = true;

            for (int i = 0; i < graph.length; i++) {
                if (!visit[i] && graph[vertex][i] == 1)
                    findVirusComputersByDFS_Recursion(graph, visit, i);
            }
        }
    }


    //DFS로 구현(Stack)
    public static int findVirusComputersByDFSUsing_Stack(int [][]graph){
        boolean []visit=new boolean[graph.length];
        int count=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(0);

        while(!stack.isEmpty()){
            Integer vertex = stack.pop();
            if(!visit[vertex])  //방문하지 않았으면
                count++;

            visit[vertex]=true; //방문

            for(int i=0;i<graph.length;i++){
                if(!visit[i] && graph[vertex][i] == 1)   //방문하지 않고 연결되어 있으면
                    stack.push(i);
            }

        }

        return count-1;
    }

    //BFS로 구현
    public static int findVirusComputersByBFS(int [][]graph){
        boolean []visit=new boolean[graph.length];
        int count=0;

        Queue<Integer> que=new LinkedList<Integer>();   //노드
        que.offer(0);   //첫번째 노드

        while (!que.isEmpty()){
            Integer vertex = que.poll();    //Dequeue

            if(!visit[vertex])  //방문 여부 확인
                count++;

            visit[vertex]=true;

            for(int i=0;i<graph.length;i++){
                if(!visit[i] && graph[vertex][i] == 1)   //방문하지 않고 연결되어 있으면
                    que.offer(i);
            }
        }

        return count-1;
    }


    public static void main(String[] args) {
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int computers = Integer.parseInt(br.readLine());
            int ssang = Integer.parseInt(br.readLine());
            int [][]graph=new int[computers][computers];                //2차원 배열로 구현


            for (int i = 0; i < ssang; i++) {
                String s = br.readLine();
                st=new StringTokenizer(s);

                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                //양방향 연결
                graph[v1-1][v2-1]=1;
                graph[v2-1][v1-1]=1;
            }


//            int virusComputersByBFS = findVirusComputersByBFS(graph);
//            System.out.println(virusComputersByBFS);

            int dfsUsingStack = findVirusComputersByDFSUsing_Stack(graph);
            System.out.println(dfsUsingStack);


//            boolean []visit=new boolean[graph.length];
//            findVirusComputersByDFS_Recursion(graph,visit,0);
//            System.out.println(count-1);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
