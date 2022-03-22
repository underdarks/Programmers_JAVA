package com.codingtest.programmers.dev_match;

import java.util.*;

public class LottoScore {

    public int  findNum(int[] list,int findNum){
        if(findNum == 0) return 0;

        int left=0;
        int right=list.length-1;

        //이분 탐색
        while(left <= right){
            int mid=(left+right)/2;

            if(list[mid] == findNum)
                return 1;

            else if(list[mid] < findNum)
                left=mid+1;

            else
                right=mid-1;

        }

        return -1;
    }


    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Map <Integer,Integer> score=Map.of(
                6,1,
                5,2,
                4,3,
                3,4,
                2,5,
                1,6,
                0,6
        );

        //1.정렬 하기
        Arrays.sort(lottos);
        Arrays.sort(win_nums);

//        Arrays.binarySearch()

        for (int lotto : lottos) {
            int result = findNum(win_nums, lotto);

            if(result == 1) //찾았으면
                answer[1]++;

            else if(result == 0)    //0의 갯수
                answer[0]++;

        }

        answer[0]+=answer[1];

        //순위 내기
        answer[0]=score.get(answer[0]);
        answer[1]=score.get(answer[1]);


        return answer;
    }

    public static void main(String[] args) {
        int [] lottos=new int[]{0, 0, 0, 0, 0, 0};
        int [] winNums=new int[]{38, 19, 20, 40, 15, 25};
        LottoScore lottoScore=new LottoScore();
        int[] solution = lottoScore.solution(lottos, winNums);

        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
