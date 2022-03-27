package com.codingtest.leetcode.easy;

import java.util.Arrays;

public class AverageSalary {
    public double average(int[] salary) {
        double sum=0;
        Arrays.sort(salary);

        for(int i=1;i<salary.length-1;i++)
            sum+=salary[i];


        return sum/(salary.length-2);
    }

    public static void main(String[] args) {
        int []salary={4000,3000,2000,1000};
        AverageSalary as=new AverageSalary();
        System.out.println(as.average(salary));
    }
}
