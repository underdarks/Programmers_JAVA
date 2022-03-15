package com.codingtest.programmers_school.week4;

import java.util.*;

//위상정렬 개념 적용
public class Prerequisite {

    //정방향, 역방향 그래프 및 각 과목의 선수과목 개수 구하는 함수
    public void makeGraph(String[] s1, String[] s2,Map<String,List<String>> forwardGraph,Map<String,List<String>> backwardGraph,Map<String,Integer> preSubjectCount){

        for (int i = 0; i < s1.length; i++) {
            String preSubject = s1[i];   //선수과목
            String postSubject = s2[i];  //후수과목

            //정방향 그래프(=B의 다음 과목들 ex.B -> G, J )
            forwardGraph.putIfAbsent(preSubject,new ArrayList<>());
            forwardGraph.get(preSubject).add(postSubject);

            //역방향 그래프(=B의 선수 과목들 ex.B -> C, f)
            backwardGraph.putIfAbsent(postSubject,new ArrayList<>());
            backwardGraph.get(postSubject).add(preSubject);

            //해당 과목의 선수과목의 개수 구하기
            preSubjectCount.put(postSubject, preSubjectCount.getOrDefault(postSubject, 0) + 1);
        }

    }

    //맨 처음 선수과목 찾기(DFS), 그리고 중복 연산 방지를 위한 hashSet리턴
    public void findFirstPreSubject(PriorityQueue<String> pq,Map<String, List<String>> backwardGraph,String subject,Set<String> avoidDup){
        List<String> list = backwardGraph.getOrDefault(subject, new ArrayList<>());
        avoidDup.add(subject);

        if(list.size() >0){
            for (String presubject : list) {
                if(!avoidDup.contains(presubject))  //해당 과목을 탐색 안했으면
                    findFirstPreSubject(pq,backwardGraph,presubject,avoidDup);
            }

        }
        else
            pq.add(subject);

    }


    public String[] solution(String[] s1, String[] s2, String k) {
        Map<String,List<String>> forwardGraph=new HashMap<>();
        Map<String,List<String>> backwardGraph=new HashMap<>();
        Map<String,Integer> preSubjectCount=new HashMap<>();
        PriorityQueue<String> pq=new PriorityQueue<>(); //문자열 우선순위를 위한
        Set<String> avoidDup =new HashSet<>();      //중복 방지를 위한
        List<String> answer=new ArrayList<>();

        //1. 그래프 만들기
        makeGraph(s1, s2,forwardGraph,backwardGraph,preSubjectCount);

        //해당 과목의 선수과목이 없으면
        if(preSubjectCount.getOrDefault(k,0) == 0)
            return  new String[]{k};

        //2. 맨 처음 수강해야할 과목 탐색
        findFirstPreSubject(pq,backwardGraph,k, avoidDup);

        //3. 위상정렬
        while(!pq.isEmpty()){
            String subject = pq.poll();

            //탐색하지 않고 선수과목을들을 수강했으면
            if(avoidDup.contains(subject) && preSubjectCount.getOrDefault(subject,0) == 0){
                List<String> postSubjects = forwardGraph.getOrDefault(subject, new ArrayList<>());//다음 과목들

                for (String postSubject : postSubjects) {
                    pq.add(postSubject);
                    preSubjectCount.put(postSubject, preSubjectCount.get(postSubject) - 1);    //해당 과목의 다음 과목의 선수 과목 갯수 감소
                }

                avoidDup.remove(subject);   //해당과목 완료
                answer.add(subject);
            }

        }


        return answer.toArray(new String[answer.size()]);
    }

    public String[] solution2(String[] s1, String[] s2, String k) {

        List<String> ans = new ArrayList<>();
        Map<String, Integer> needs = new HashMap<>(); // 필요한 선수과목들 수
        Map<String, List<String>> before = new HashMap<>(); // A가 B들의 선수과목
        Map<String, List<String>> after = new HashMap<>(); // 반대

        for(int idx = 0; idx < s1.length; idx++) {
            before.putIfAbsent(s1[idx], new ArrayList<>());
            before.get(s1[idx]).add(s2[idx]);
            after.putIfAbsent(s2[idx], new ArrayList<>());
            after.get(s2[idx]).add(s1[idx]);
            needs.put(s2[idx], needs.getOrDefault(s2[idx], 0) + 1);
        }

        if(!needs.containsKey(k)) return new String[]{k};

        Set<String> targets = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        targets.add(k);
        q.add(k);
        PriorityQueue<String> codes = new PriorityQueue<>(); // 시작할 현재 노드들

        while(!q.isEmpty()) {
            String curr = q.poll();

            for(String next : after.get(curr)) {
                if(!targets.contains(next)) {
                    if(!after.containsKey(next)) {
                        codes.add(next);
                        targets.add(next);
                        continue;
                    }
                    q.add(next);
                    targets.add(next);
                }
            }
        }

        while(!codes.isEmpty()){
            String curr = codes.poll();
            ans.add(curr);

            if(!before.containsKey(curr))
                continue;

            for(String next : before.get(curr)) {
                //방문하지 않고 선수 과목이 1개 남았으면(해당 과목 제외하고 다 완료했으면) => 결국 큐에 중복 값을 안넣기 위해
                if(needs.get(next) == 1 && targets.contains(next)) {
                    codes.add(next);
                    targets.remove(next);
                }
                else
                    needs.put(next, needs.get(next) - 1);   //다음 과목의 선수 과목 하나 감소

            }
        }

        return ans.toArray(new String[ans.size()]);
    }

    public static void main(String[] args) {
        String []s1={"A","E","B","D","B","H","F","H","C"};
        String []s2={"G","C","G","F","J","E","B","F","B"};
        String k="B";

        Prerequisite p=new Prerequisite();
        String[] solution = p.solution2(s1, s2, k);

        for (int i = 0; i < solution.length; i++) {
            String s = solution[i];
            System.out.print(s + " ");
        }

    }
}
