package com.codingtest.boj.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FindParentTree {

    public static void findParentNode(int n,Map<Integer,List<Integer>> graph) {
        boolean[] visit = new boolean[n];
        int []parent=new int[n];

        Queue<Integer> queue=new LinkedList<>();
        queue.offer(0);

        while(!queue.isEmpty()) {
            Integer vertex = queue.poll();

            //방문하지 않았으면
            if(!visit[vertex]) {
                visit[vertex] = true;
                List<Integer> value = graph.getOrDefault(vertex, new ArrayList<>());

                for (int i = 0; i < value.size(); i++) {
                    Integer child = value.get(i);  //child

                    if (!visit[child]) {
                        parent[child] = vertex;
                        queue.offer(child);
                    }

                }

            }
        }

        for (int i = 1; i < parent.length; i++)
            System.out.println(parent[i]+1);
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int n = Integer.parseInt(br.readLine());
            //정점이 커지면 입력단에서 메모리 초과가 됨(int [][] -> map)
            Map<Integer,List<Integer>> graph=new HashMap<>();

            for (int i = 0; i < n - 1; i++) {
                String s = br.readLine();
                st = new StringTokenizer(s);

                int startVertex= Integer.parseInt(st.nextToken())-1;
                int endVertex= Integer.parseInt(st.nextToken())-1;

                //양방향 설정
                List<Integer> values = graph.getOrDefault(startVertex, new ArrayList<>());
                values.add(endVertex);
                graph.put(startVertex,values);

                List<Integer> values2 = graph.getOrDefault(endVertex, new ArrayList<>());
                values2.add(startVertex);
                graph.put(endVertex,values2);


            }

            findParentNode(n,graph);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
