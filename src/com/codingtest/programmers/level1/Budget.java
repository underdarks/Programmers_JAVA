package com.codingtest.programmers.level1;

import java.util.*;

//예산
public class Budget {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum=0,count=0;

        Arrays.sort(d); //오름차순 정렬

        for(count=0;count<d.length;count++){
            sum+=d[count];
            if(sum > budget) break; //예산값보다 크면
        }

        answer=count;
        return answer;
    }

    public static void main(String[] args) {
        Budget b=new Budget();
        int []d={1,3,2,5,4};
        int budget=9;
        b.solution(d,budget);
    }
}
