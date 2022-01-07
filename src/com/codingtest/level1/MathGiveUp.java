package com.codingtest.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MathGiveUp {

    public int getMax(int []nums)
    {
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            if (max < nums[i])
                max=nums[i];
        }

        return max;
    }

    public int[] solution(int[] answers) {
        int []first={1,2,3,4,5};
        int []second={2,1,2,3,2,4,2,5};
        int []third={3,3,1,1,2,2,4,4,5,5};
        int[] answer;
        List<Integer> list=new ArrayList<>();

        int []score={0,0,0};    //맞힌 점수

        for(int i=0;i<answers.length;i++){
            if(first[i%5] == answers[i])
                score[0]++;

            if(second[i%8] == answers[i])
                score[1]++;

            if(third[i%10] == answers[i])
                score[2]++;
        }
        //최대값 구하기
        int max=getMax(score);
        for(int i=0;i<score.length;i++){
            if(score[i] == max)
                list.add(i+1);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        int []answer={1,3,2,4,2};

        MathGiveUp m=new MathGiveUp();
        System.out.println(m.solution(answer));
    }
}
