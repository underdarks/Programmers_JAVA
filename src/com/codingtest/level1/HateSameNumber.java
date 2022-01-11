package com.codingtest.level1;

import java.util.ArrayList;
import java.util.List;

//같은 숫자는 싫어
public class HateSameNumber {
    public int[] solution(int []arr) {
        int[] answer = {};
        int history=-1;
        List<Integer> list=new ArrayList<>();

        if(arr.length > 0)
            history=arr[0];

        for(int i=1;i<arr.length;i++){
            if(history != arr[i]) {
                list.add(history);
                history = arr[i];
            }
        }
        list.add(arr[arr.length-1]);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int []arr={5, 3, 2, 1, 3, 4};
        HateSameNumber h=new HateSameNumber();
        h.solution(arr);
    }
}
