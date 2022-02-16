package com.codingtest.codeup.dp;


import java.util.*;

//3803 : RGB 거리
//https://codeup.kr/problem.php?id=3803
public class RGB {
//    public static int dp[][];


    public static int getMinCost(int n,int color,int [][]cost,int [][]dp){
        if(n == 0)
            return cost[n][color];

        if(dp[n][color] == 0){
            //RED 이면
            if(color == 0)
                dp[n][color]=Math.min(getMinCost(n-1,1,cost,dp),getMinCost(n-1,2,cost,dp))
                        +cost[n][color];

            //GREEN 이면
            else if(color == 1)
                dp[n][color]=Math.min(getMinCost(n-1,0,cost,dp),getMinCost(n-1,2,cost,dp))
                        +cost[n][color];

            //BLUE 이면
            else
                dp[n][color]=Math.min(getMinCost(n-1,0,cost,dp),getMinCost(n-1,1,cost,dp))
                        +cost[n][color];

        }

        return dp[n][color];
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();   //n<=1000
        int [][]cost=new int[n][3];

        for (int i = 0; i < n; i++) {
            for(int j=0;j<3;j++)
                cost[i][j]=sc.nextInt();
        }

        int [][]dp=new int[n][3];

        //R이랑 G 비교
        int min = Math.min(getMinCost(n - 1, 0, cost,dp), getMinCost(n - 1, 1, cost,dp));
        //최소값이랑 B랑 비교
        System.out.println(Math.min(min,getMinCost(n-1,2,cost,dp)));


    }
}
