package com.codingtest.programmers.level2;

import java.util.Arrays;

//H-Index(정렬)
public class HIndex {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for(int i=0;i<=10000;i++){
            int count=0;
            for (int value : citations) {
                if(i <= value)
                    count++;    //큰값 개수
            }
            //비교
            if(i > count)
                break;

            answer=i;
        }


        return answer;
    }

    public static void main(String[] args) {
        int []ciat={9, 9, 9, 12};
        HIndex h=new HIndex();
        System.out.println(h.solution(ciat));

    }
}
