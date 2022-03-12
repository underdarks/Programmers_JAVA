package com.codingtest.company_coding_test.sk;

import com.codingtest.codeup.tree.Graph;

import java.util.*;

//트리 문제
public class Four {

    //양방향 그래프 생성
    public Map<Integer, List<Integer>> makeGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int startVertex = edge[0];
            int endVertex = edge[1];

            //양방향 설정
            List<Integer> values = graph.getOrDefault(startVertex, new ArrayList<>());
            values.add(endVertex);
            graph.put(startVertex, values);

            List<Integer> values2 = graph.getOrDefault(endVertex, new ArrayList<>());
            values2.add(startVertex);
            graph.put(endVertex, values2);
        }

        return graph;
    }

    //그래프 탐색
    public int searchTree(Map<Integer, List<Integer>> graph, int startVertex, int endVertex,int n) {
        boolean []visit=new boolean[n]; //방문 체크
        int count=1;
        Queue<Integer> que=new LinkedList<>();
        que.offer(startVertex);

        while(!que.isEmpty()){
            Integer v = que.poll();
            List<Integer> vertexs = graph.get(v);

            if(!visit[v]) {
                visit[v] = true;

                if (vertexs.contains(endVertex))
                    return count;

                for (Integer vertex : vertexs){
                    que.offer(vertex);
                }

                count++;
            }
        }

        return Integer.MIN_VALUE;
    }


    public long solution(int n, int[][] edges) {
        long answer = 0;
        Map<Integer, List<Integer>> graph = makeGraph(edges);

        //순서쌍 개수 조회
        for (int k = 0; k < n; k++) {

            for (int i = 0; i < n; i++) {
                if(k==i) continue;

                for (int j = 0; j < n ; j++) {
                    if (k == j || i == j)   continue;
                    int v1 = searchTree(graph, k, i, n);
                    int v2 = searchTree(graph, i, j, n);
                    int v3 = searchTree(graph, k, j, n);

                    if(v1+v2 == v3)
                        answer++;
                }

            }
        }

        return answer;
    }

    public static void main(String[] args) {
//        int n = 5;
//        int[][] edges = {
//                {0, 1},
//                {0, 2},
//                {1, 3},
//                {1, 4}
//        };

        int n = 4;
        int[][] edges = {
                {2, 3},
                {0, 1},
                {1, 2}
        };

        Four four = new Four();
        long solution = four.solution(n, edges);
        System.out.println("solution = " + solution);

    }
}
