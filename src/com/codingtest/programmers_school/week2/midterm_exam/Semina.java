package com.codingtest.programmers_school.week2.midterm_exam;

import java.util.Arrays;

public class Semina {
    public int solution(int[] people, int[] tshirts) {
        int answer = 0;

        //1.정렬
        Arrays.sort(people);
        Arrays.sort(tshirts);

        //2.맨뒤부터 탐색
        for(int i=people.length-1,j=tshirts.length-1; i>=0 && j>=0; i--){
            if(tshirts[j] >= people[i]) {  //티셔츠의 크기가 참가자의 상의크기보다 크면
                answer++;
                j--;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        int []people={2,3};
        int []tshirts={1,1};

        Semina semina=new Semina();
        int solution = semina.solution(people, tshirts);
        System.out.println("solution = " + solution);

    }
}
