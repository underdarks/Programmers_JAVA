package com.codingtest.programmers_school.week1;

import java.util.Arrays;

public class BigNum {
    public String solution(int[] numbers) {
        String answer = "";

        //1.문자로 변환
        String[] array = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);

        //2.정렬
        Arrays.sort(array);

        for (int i = array.length-1; i >=0; i--) {

        }

        return answer;
    }

    public static void main(String[] args) {
        int []nums={3,30,34,5,9};
        BigNum bigNum=new BigNum();
        String solution = bigNum.solution(nums);
        System.out.println("solution = " + solution);

    }
}
