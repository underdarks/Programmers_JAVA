package com.codingtest.level1;

import java.util.Arrays;

public class NoNumAdd {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);

        for(int i=1;i<10;i++) {
            int j=i;
            if (!Arrays.stream(numbers).anyMatch(val -> val == j)){
                answer+=i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int []numbers={1,2,3,4,6,7,8,0};
        NoNumAdd noNumAdd=new NoNumAdd();
        System.out.println(noNumAdd.solution(numbers));

    }


}
