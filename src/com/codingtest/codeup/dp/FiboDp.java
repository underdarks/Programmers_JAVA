package com.codingtest.codeup.dp;

import java.util.Scanner;

//피보나치를 DP 방식으루 구현
public class FiboDp {
    static int []dp=new int[100+1];
    static int []fdp=new int[100+1];

    public static int getTopDownFibo(int n){
        if(n<=2)
            return 1;

        //배열에 값이 없으면
        if(dp[n] == 0) {
            int fibo = getTopDownFibo(n - 1) + getTopDownFibo(n - 2);
            dp[n]=fibo;
        }

        return dp[n];
    }

    public static int getBottomUpFibo(int n){
        fdp[1]=1;
        fdp[2]=1;

        //메모이제이션에 값있으면 연산안하고
        if(fdp[n] ==0) {
            for (int i = 3; i <=n; i++) {
                if(fdp[i] ==0)  //패스
                    fdp[i] = fdp[i - 2] + fdp[i - 1];
            }
        }

        return fdp[n];
    }



    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();


        int topDownFibo = getTopDownFibo(n);
        System.out.println(topDownFibo);
    }
}
