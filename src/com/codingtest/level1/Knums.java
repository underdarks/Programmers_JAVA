package com.codingtest.level1;

import java.util.Arrays;

public class Knums {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0;i<commands.length;i++){
            int firstIndex=commands[i][0]-1;
            int lastIndex=commands[i][1];
            int k=commands[i][2]-1;

            //int 배열 자르기
            int []arr=Arrays.copyOfRange(array,firstIndex,lastIndex);

            //정렬
            Arrays.sort(arr);
            answer[i]=arr[k];
        }

        return answer;
    }

    public static void main(String[] args) {
        int []array={1,5,2,6,3,7,4};
        int [][]commands={{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        Knums k=new Knums();
        k.solution(array,commands);

    }
}
