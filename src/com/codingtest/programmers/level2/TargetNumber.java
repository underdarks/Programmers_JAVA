package com.codingtest.programmers.level2;

import java.util.Arrays;

public class TargetNumber {

    static int answer=0;
    public void makeTargetNum(int[] nums,int idx,int target){
        if(Arrays.stream(nums).sum()==target) {
            answer++;
            return;
        }


//        makeTargetNum(nums,);

    }


    public int solution(int[] numbers, int target) {

        makeTargetNum(numbers,numbers.length-1,target);
        return answer;
    }

    public static void main(String[] args) {

    }
}
