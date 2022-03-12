package com.codingtest.programmers_school.week4;

import java.util.*;

public class Prerequisite {

    //선수과목 그래프 만드는 함수
    public Map<String,List<String >> makeGraph(String[] s1, String[] s2){
        Map<String,List<String>> graph=new HashMap<>(); //key = 후수과목 , values = 선수과목들

        for (int i = 0; i < s1.length; i++) {
            String preSubject = s1[i];   //선수과목
            String postSubject = s2[i];  //후수과목

            List<String> values = graph.getOrDefault(postSubject, new ArrayList<>());
            values.add(preSubject);
            graph.put(postSubject,values);
        }

        return graph;
    }


    //맨 처음 선수과목 찾기
    public void findFirstPreSubject(List<String> list,Map<String, List<String>> graph,String subject){
        List<String> values = graph.getOrDefault(subject, new ArrayList<>());

        if(values.size()>0){
            for (String value : values){
                findFirstPreSubject(list,graph,value);
            }
        }

        else {
            if(!list.contains(subject))
                list.add(subject);
        }
    }

    public String[] solution(String[] s1, String[] s2, String k) {
        List<String> answer=new ArrayList<>();
        int i=0;
        List<String> list=new ArrayList<>();

        //1. 그래프 만들기
        Map<String, List<String>> graph = makeGraph(s1, s2);
        findFirstPreSubject(list,graph,k);

        //2. 오름차순 정렬
        Collections.sort(list);

        answer.add(list.get(0));

        for (int j = 1; j < list.size();) {
            String subject=list.get(j);
            answer.add(subject);
        }

        return answer.toArray(new String[answer.size()]);
    }

    public static void main(String[] args) {

    }
}
