package com.codingtest.codeup.greedy;

import java.util.*;

//3321 : 최고의 피자
public class BestPizza {


    //1달러당 열량이 최대가 되는 피자 주문
    public static int getBestPizza(List<Integer> topingCalList,int topingCount,int dowPrice,int topingPrice,int dowCal){
        Collections.sort(topingCalList,Collections.reverseOrder());
        int []bestPizzaKcal=new int[topingCount];   //달러당 열량의 수

        //dp식으로
        for (int i = 0; i < topingCalList.size(); i++) {
            int sumKcal=0;
            for(int j=0;j<=i;j++){
                sumKcal+=topingCalList.get(j);
            }

            bestPizzaKcal[i]=(sumKcal+dowCal)/(dowPrice+topingPrice*(i+1));
        }

        Arrays.sort(bestPizzaKcal);
        return bestPizzaKcal[bestPizzaKcal.length-1] > dowCal/dowPrice ? bestPizzaKcal[bestPizzaKcal.length-1]: dowCal/dowPrice;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();           //토핑 종류 수
        int dowPrice=Integer.parseInt(sc.next());      //도우 가격
        int topingPrice=sc.nextInt();   //토핑 가격
        int dowCal=sc.nextInt();         //도우 칼로리

        List<Integer> topingCalList=new ArrayList<>();
        for(int i=1;i<=n;i++){
            topingCalList.add(sc.nextInt());
        }

        int bestPizza = getBestPizza(topingCalList, n, dowPrice, topingPrice, dowCal);
        System.out.println(bestPizza);
    }
}
