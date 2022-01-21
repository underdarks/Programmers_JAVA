package com.codingtest.codeup.greedy;

import java.util.*;

public class RemoteControl {
    public static int getCount(int curTemp,int targetTmp){
        Integer []buttons={1,5,10,-1,-5,-10};
        Arrays.sort(buttons, Collections.reverseOrder());

        int count=0;
        int value=Math.abs(curTemp-targetTmp);
        int []dp=new int[buttons.length];

        while(value != 0){
            int index=0;
            for (int i = 0; i < buttons.length; i++) {
                dp[i]=Math.abs(value-buttons[i]);
            }

            int min=dp[0];
            for (int i = 1; i < dp.length; i++) {
                if(min > dp[i]){
                    min=dp[i];
                    index=i;
                }
            }

            value-=buttons[index];
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(getCount(a,b));
    }
}
