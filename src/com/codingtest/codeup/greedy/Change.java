package com.codingtest.codeup.greedy;

import java.util.*;

//3301. 거스름돈
public class Change {

    //최소 거스름돈 반환
    public static int getChange(int n){
        Integer []moneys={10,50,100,500,1000,5000,10000,50000};
        Arrays.sort(moneys, Collections.reverseOrder());
        int count=0;

        for (Integer money : moneys) {
            if (n >= money) {
                count+=n/money;
                n%=money;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getChange(n));
    }
}
