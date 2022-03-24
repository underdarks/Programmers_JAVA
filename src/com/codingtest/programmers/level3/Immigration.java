package com.codingtest.programmers.level3;

import java.util.Arrays;

//입국 심사
public class Immigration {
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times); //1. 오름차순 정렬
        int[] total = times.clone();

        int left=0;
        int right=times.length-1;

        //이분 탐색
        while (n>0) {
            int mid=(left+right)/n;

            if(total[mid] < total[mid +1]){
                answer=total[mid];
                total[mid]+=times[mid];
                left=mid+1;
            }
            else if (total[mid] > total[mid + 1]){
                answer=total[mid+1];
                total[mid+1]+=times[mid+1];
                right--;
            }

            n--;

        }



        return answer;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] times = {7,10};
        Immigration immigration = new Immigration();
        long solution = immigration.solution(n, times);

        System.out.println("solution = " + solution);

    }
}
