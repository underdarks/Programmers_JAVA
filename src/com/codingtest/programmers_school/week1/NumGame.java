package com.codingtest.programmers_school.week1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class NumGame {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        //1. A와 B 오름차순 정렬
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = A.length-1, j=B.length-1; i >=0; i--) {
            if (A[i] < B[j]){
                answer++;
                j--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] a = {5, 1, 3, 7};
        int[] b = {3, 2, 5, 6};  //3,2,5,6

        NumGame numGame = new NumGame();
        int solution = numGame.solution(a, b);
        System.out.println("solution = " + solution);

    }
}

