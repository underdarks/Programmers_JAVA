package com.codingtest.leetcode.easy;

//509. Fibonacci Number
public class FibonacciNumber {
    static int dp[]=new int[31];

    public int fib(int n) {
        if(n <= 1) return n;
        if(dp[n] > 0)
            return dp[n];

        dp[n]=fib(n-2) + fib(n-1);

        return dp[n];
    }

    public static void main(String[] args) {
        FibonacciNumber fn= new FibonacciNumber();
        int fib = fn.fib(5);

        System.out.println("fib = " + fib);
    }

}
