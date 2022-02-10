package com.codingtest.codeup.dp;


import java.math.BigInteger;
import java.util.Scanner;

//3720 : nCr (Hell)
//https://codeup.kr/problem.php?id=3720
public class NCRHell {

    //nCr= n!/(n-r)!*r!
    public static double getNcrNum(Long n,Long r){
        BigInteger nFac=new BigInteger("1");
        BigInteger rFac=new BigInteger("1");
        BigInteger nminusRFac=new BigInteger("1");

        for (int i = 2; i <= n; i++) {
            nFac=nFac.multiply(BigInteger.valueOf(i));

            if(i == r)
                rFac=nFac.multiply(BigInteger.valueOf(1));

            if(i == (n-r))
                nminusRFac=nFac.multiply(BigInteger.valueOf(1));
        }

        rFac=rFac.multiply(nminusRFac);
        nFac=nFac.divide(rFac);

        double result = nFac.remainder(BigInteger.valueOf(1999)).doubleValue();
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
