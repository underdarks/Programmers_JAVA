package com.codingtest.codeup.dp;

import java.math.BigInteger;
import java.util.Scanner;

//3801 : 오르막 수
//https://codeup.kr/problem.php?id=3801
public class UphillNum {

    public static double getUphillNum(int n){
        long v=10L;
        BigInteger result=new BigInteger("1");
        BigInteger bunmo=new BigInteger("1");
        BigInteger bunja=new BigInteger("1");
        Long t=1L;

        for(Long i=2L;i<10L;i++){
            t*=i;
        }

        if(n<10) {
            for (int i = 1; i <= n; i++){
                bunja=bunja.multiply(BigInteger.valueOf(v++));
                bunmo=bunmo.multiply(BigInteger.valueOf(i));
            }
            result=bunja.divide(bunmo);
        }

        else{
//            double t=2.0;
            for(int i=n+1;i<10+n;i++){
                result=result.multiply(BigInteger.valueOf(i));
            }
            result=result.divide(BigInteger.valueOf(t));
        }

        double re = result.remainder(BigInteger.valueOf(10007)).doubleValue();
        return re;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();

        double uphillNum = getUphillNum(n);
        System.out.printf("%.0f",uphillNum);
//        System.out.println(uphillNum);
    }
}
