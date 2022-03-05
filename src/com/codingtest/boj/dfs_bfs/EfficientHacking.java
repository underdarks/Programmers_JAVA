package com.codingtest.boj.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class EfficientHacking {

    //DFS로 풀어보기기
    public static void getMaxHackingComNumDFS()


    //BFS 방법
    public static void getMaxHackingComNumBFS(int n, Map<Integer, List<Integer>> graph) {
        Map<Integer, List<Integer>> hackCount = new HashMap<>();   //각 컴퓨터 해킹 갯수 저장(key = 횟수, value= 컴퓨터 번호)
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            boolean[] visit = new boolean[n]; //방문 체크
            int count = 0;
            queue.offer(i);

            while (!queue.isEmpty()) {   //bfs 탐색
                Integer vertex = queue.poll();

                if (!visit[vertex]) {
                    visit[vertex] = true;
                    count++;
                    List<Integer> values = graph.getOrDefault(vertex, new ArrayList<>());

                    for (Integer nextVertex : values) {
                        if (!visit[nextVertex])
                            queue.offer(nextVertex);
                    }
                }
            }


            //컴퓨터 해킹 갯수 저장
            List<Integer> values = hackCount.getOrDefault(count, new ArrayList<>());
            values.add(i + 1);    //컴퓨터 번호 저장
            hackCount.put(count, values);
        }

        //키 내림차순 정렬
        ArrayList<Integer> keys = new ArrayList<>(hackCount.keySet());
        keys.sort(Collections.reverseOrder());

        //최대값을 가진 Key 가져오기
        Integer key = keys.get(0);

        List<Integer> values = hackCount.get(key);
        for (Integer value : values)
            System.out.print(value + " ");


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String nm = br.readLine();
        st = new StringTokenizer(nm);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            st = new StringTokenizer(s);

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            //단방향 설정
            List<Integer> values = graph.getOrDefault(b, new ArrayList<>());
            values.add(a);
            graph.put(b, values);

        }

        getMaxHackingComNumBFS(n, graph);

    }
}
