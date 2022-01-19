package com.codingtest.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//K번째 숫자
public class Knums {

    //정렬
    public void sort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    int tmp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=tmp;
                }
            }
        }
    }


    //int 배열 짜르기
    public int[] getList(int[] arr,int firstIndex,int lastIndex)
    {
        List<Integer> list=new ArrayList<>();
        for(int i=firstIndex;i<=lastIndex;i++){
            list.add(arr[i]);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }


    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index=0;

        for (int i = 0; i < commands.length; i++) {
            int firstIndex=commands[i][0]-1;
            int lastIndex=commands[i][1]-1;
            int findIndex=commands[i][2]-1;

            int[] list = getList(array, firstIndex, lastIndex);
            sort(list);

            answer[index++]=list[findIndex];
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
