package com.codingtest.boj.dfs_bfs;

import java.io.*;
import java.util.*;

public class EfficientHacking {

    static boolean[] visit;

    //DFS로 풀어보기
    public static void getMaxHackingComNumDFS(Map<Integer, List<Integer>> graph, int vertex, int []hackCount) {

        //방문하지 않았으면
        if (!visit[vertex]) {
            visit[vertex] = true;
            List<Integer> coms = graph.getOrDefault(vertex, new ArrayList<>()); //연결된 컴퓨터들 (A <-> B 신뢰관계에서 B -> A(단방향)의 A에 해당하는 컴퓨터들)

            for (Integer com : coms) {
                if(!visit[com]) {
                    getMaxHackingComNumDFS(graph, com, hackCount);
                    hackCount[vertex] += hackCount[com] + 1;    //
                }

                //방문 했으면
                else
                    hackCount[vertex] += hackCount[com] + 1;    //
            }

        }

    }


    //BFS 방법
    public static void getMaxHackingComNumBFS(int n, Map<Integer, List<Integer>> graph) {
        Map<Integer, List<Integer>> hackCount = new HashMap<>();   //각 컴퓨터 해킹 갯수 저장(key = 횟수, value= 컴퓨터 번호)
        Queue<Integer> queue = new LinkedList<>();
        int []counts=new int[n];

        for (int i = 0; i < n; i++) {
            queue.offer(i);

            while (!queue.isEmpty()) {   //bfs 탐색
                Integer vertex = queue.poll();

                if (!visit[vertex]) {
                    visit[vertex] = true;
                    List<Integer> values = graph.getOrDefault(vertex, new ArrayList<>());

                    for (Integer nextVertex : values) {
                        if (!visit[nextVertex]) {
                            queue.offer(nextVertex);
                            counts[i]+=1;
                        }
                    }
                }
            }

            //컴퓨터 해킹 갯수 저장
            List<Integer> values = hackCount.getOrDefault(counts[i], new ArrayList<>());
            values.add(i + 1);    //컴퓨터 번호 저장
            hackCount.put(counts[i], values);
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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String nm = br.readLine();
        st = new StringTokenizer(nm);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visit = new boolean[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] hackCount = new int[n];

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

        for (int i = 0; i < n; i++)
            getMaxHackingComNumDFS(graph, i, hackCount);

        Map<Integer, List<Integer>> rankMap=new HashMap<>();    //가장 많이 해킹한 컴퓨터 번호 저장하기 위한 자료

        for (int i = 0; i < hackCount.length; i++) {
            int key=hackCount[i];   //각 컴퓨터의 최대 해킹 갯수

            List<Integer> values = rankMap.getOrDefault(key, new ArrayList<>());
            values.add(i+1);
            rankMap.put(key,values);
        }

        //키 내림차순 정렬
        ArrayList<Integer> keys = new ArrayList<>(rankMap.keySet());
        keys.sort(Collections.reverseOrder());

        //최대값을 가진 Key 가져오기
        Integer key = keys.get(0);

        List<Integer> values = rankMap.get(key);
        for (Integer value : values)
            bw.write(value+" ");


//        getMaxHackingComNumBFS(n, graph);

    }
}
