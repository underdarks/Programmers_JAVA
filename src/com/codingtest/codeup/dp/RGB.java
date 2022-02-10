package com.codingtest.codeup.dp;


import java.util.*;

//3803 : RGB 거리
//https://codeup.kr/problem.php?id=3803
public class RGB {

    public static int getLowCost(int [][] cost,int n){
        int lowCost=0;
        int minCost=0;
        int selectCost=0;
        int beforeIndex=-1;
        int tmp=0;

        //값이 1개이면
        if(n == 1) {
            Arrays.sort(cost[0]);
            return cost[0][0];
        }


        for (int i = 0; i < cost.length-1; i++) {
            minCost=10000000;

            for(int k=0;k<3;k++) {
                if(k == beforeIndex) continue;      //
                for (int j = 0; j < 3; j++) {
                    if (k != j ) {
                        int value = cost[i][k] + cost[i + 1][j];  //위의 행과 아래행 합 식별
                        if (minCost >= value) {
                            minCost = value;
                            selectCost = cost[i][k];
                            tmp=k;

                            if(i == cost.length - 2)
                                selectCost=minCost;
                        }
                    }
                }
            }

            beforeIndex=tmp;
            lowCost += selectCost;
        }

        return lowCost;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();   //n<=1000
        int [][]cost=new int[n][3];

        for (int i = 0; i < n; i++) {
            for(int j=0;j<3;j++)
                cost[i][j]=sc.nextInt();
        }

        int lowCost = getLowCost(cost,n);
        System.out.println(lowCost);
    }
}
