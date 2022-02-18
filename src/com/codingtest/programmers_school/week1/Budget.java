package com.codingtest.programmers_school.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Budget {

    public static int binarySearch(int []list,int value){
        int leftIndex=0;
        int rightIndex=list.length-1;
        int recentIndex=0;

        while(leftIndex <= rightIndex){

            int midIndex=(leftIndex+rightIndex)/2;
            recentIndex=midIndex;

            if(list[midIndex]==value)
                return midIndex;

            //중간값이 찾는값이 찾는값보다 크면
            else if(list[midIndex] > value)
                rightIndex=midIndex-1;

            //중간값이 찾는값보다 작으면
            else
                leftIndex=midIndex+1;

        }

        //값이 없으면
        return recentIndex;
    }

//    public List<Integer> search(int []budgets,int upperPrice){   //value는 상한액
//        int sum=0;
//        List<Integer> list=new ArrayList<>();
//
//        for (int i = 0; i < budgets.length; i++) {
//
//            //예산이 상한액보다 클때(
//            if(budgets[i] > upperPrice){
//                list.add(sum);
//                list.add(i);
//                break;
//            }
//
//            sum+=budgets[i];
//        }
//
//        return list;
//    }

    public static int solution(int[] budgets, int M) {
        int answer = 0;
        int len=budgets.length;

        //1.오름차순 정렬
        Arrays.sort(budgets);

        //2.요청한 예산 총액 얻기
        int sum = Arrays.stream(budgets).sum();

        //3.요청한 금액이 총 예산 보다 작으면
        if(sum < M)
            answer=budgets[len-1];

        //4. 요청한 금액이 총 예산 보다 많으면
        else{
            //평균값 구하기
            double avg = Arrays.stream(budgets).average().orElse(0);
            double valueSum=0;

            for (int j = 0; j < budgets.length; j++) {
                int budget = budgets[j];

                if(budget <= avg)      //평균값보다 작거나 같으면
                    valueSum += budget;

                else      //평균값보다 크면 상한액(=평균값)을 넣어라
                    valueSum+=avg;
            }

            //누적으로 빼기

            for(int i = (int) avg-1; i>=0; i--){
                int index = binarySearch(budgets, i);

                int count=len-index;
                valueSum-=count;

                //총 예산보다 요청한 금액이 적으면
                if(valueSum<=M) {
                    answer = i;
                    break;
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int []budgets=new int[n];

        for (int i = 0; i < budgets.length; i++) {
            budgets[i]=sc.nextInt();
        }

        int m=sc.nextInt();
        int solution = solution(budgets, m);


//
//        int []budgets={120,110,140,150};
//        Budget budget=new Budget();
//        int solution = budget.solution(budgets, 485);

        System.out.println(solution);
    }
}
