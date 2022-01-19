package com.codingtest.programmers.level2;

import java.util.Arrays;
import java.util.MissingFormatArgumentException;

//H-Index(정렬)
public class HIndex {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for(int i=0;i<=10000;i++){
            int count=0;

            //해당 인용갯수 보다 큰 인용논문 횟수
            for (int j = 0; j < citations.length; j++) {
                if(i <= citations[j]){
                    count=citations.length-j;
                    break;
                }
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
