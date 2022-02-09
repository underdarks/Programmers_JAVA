package com.codingtest.codeup.dp;


import java.math.BigInteger;
import java.util.Scanner;

//3720 : nCr (Hell)
//https://codeup.kr/problem.php?id=3720
public class NCRHell {

    //nCr= n!/(n-r)!*r!
    public static double getNcrNum(Long n,Long r){
        BigInteger bunja=new BigInteger("1");
        BigInteger bunmo=new BigInteger("1");

        String tag = (n-r) >= r ? "n-r" : "r";

        //ex.n=1
        //n-r이 r보다 크거나 같으면
        if(tag.equals("n-r")){
            for(Long i=n;i>n-r;i--)
                bunja=bunja.multiply(BigInteger.valueOf(i));

            for(Long i=2L;i<=r;i++)
                bunmo=bunmo.multiply(BigInteger.valueOf(i));
        }

        //n-r이 r보다 작으면
        else {
            for(Long i=n;i>r;i--)
                bunja = bunja.multiply(BigInteger.valueOf(i));

            for(Long i=2L;i<=n-r;i++)
                bunmo = bunmo.multiply(BigInteger.valueOf(i));

        }

        bunja=bunja.divide(bunmo);
        double result = bunja.remainder(BigInteger.valueOf(1999)).doubleValue();

        return result;
    }



    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Long n=sc.nextLong();
        Long r=sc.nextLong();


        double ncrNum = getNcrNum(n, r);
        System.out.printf("%.0f",ncrNum);
    }
}
