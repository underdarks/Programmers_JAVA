package com.codingtest.programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {


    public int solution(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<Integer>();
        for(int i : priorities){
            que.add(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length-1;

        while(!que.isEmpty()){
            Integer i = que.poll();
            if(i == priorities[size - answer]){
                answer++;
                l--;
                if(l <0)
                    break;
            }else{
                que.add(i);
                l--;
                if(l<0)
                    l=que.size()-1;
            }
        }

        return answer;
    }

    public int solution2(int[] priorities, int location) {
        int answer = 1;
        Queue<Integer> que=new LinkedList<>();

        for (int i = 0; i < priorities.length; i++)
            que.add(i);

        while(!que.isEmpty()){
            Integer doc = que.poll();

            //우선순위가 높은게 있으면
            if(Arrays.stream(priorities).anyMatch(a -> a > priorities[doc]))
                que.add(doc);

            else {
                if(doc == location) break;  //해당 위치의 문서이면

                //해당 문서는 출력됨
                priorities[doc]=-1;
                answer++;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        int []pri={2,1,3,2};
        int location=2;

        Printer printer=new Printer();
        int solution = printer.solution(pri, location);

        System.out.println("solution = " + solution);
    }
}
