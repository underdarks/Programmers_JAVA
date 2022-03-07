package com.codingtest.programmers_school.week3;

import java.util.Arrays;

public class IntTriangle {

    public int solution(int[][] triangle) {

        int height = triangle.length - 1;
        /**
         * 로직 설명
         * Bottom-Up 방식으로 최대값의 누적해서 꼭대기로 올라온다
         * 꼭대기값이 숫자의 최대값을 의미함
         */

        for (int row = height; row > 0; row--) {
            for (int col = row; col > 0; col--)
                triangle[row-1][col-1]+=Math.max(triangle[row][col], triangle[row][col-1]);
        }


        return triangle[0][0];
    }


//    public int solution(int[][] triangle) {
//        int answer = triangle[0][0];    //맨 처음 꼭대기
//        int [][]dp=new int[triangle.length][triangle[triangle.length-1].length];
//
//        for (int i = 1; i < triangle.length; i++) {
//            int[] curLine = triangle[i];        //현재 줄 숫자
//            int len=curLine.length;
//
//            for (int j = 0; j < len; j++) {
//                if( j == 0) //맨 앞이면
//                    dp[i][j]=dp[i-1][j]+curLine[j];
//
//                else if( j == len-1)    //맨 뒤면
//                    dp[i][j]=dp[i-1][j-1]+curLine[j];
//
//                else
//                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1])+curLine[j];  //현재값은 전의 값 두개 중 최대 값
//            }
//        }
//
//        int[] maxs = dp[dp.length - 1];
//        Arrays.sort(maxs);  //최대값을 위한 정렬
//
//        return maxs[maxs.length-1]+answer; //최대값
//    }

    public static void main(String[] args) {
        int[][] tria = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };

        IntTriangle intTriangle = new IntTriangle();

        int solution = intTriangle.solution(tria);
        System.out.println("solution = " + solution);
    }
}
