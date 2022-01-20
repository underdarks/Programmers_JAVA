package com.codingtest.codeup.greedy;

import java.util.*;

public class MeanPrice {

    public static double getPrice(List<Integer> pasta,List<Integer> fruit){
        Collections.sort(pasta);
        Collections.sort(fruit);

        return (pasta.get(0)+fruit.get(0))*1.1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=5;
        List<Integer> pasta=new ArrayList<>();
        List<Integer> fruit=new ArrayList<>();

        for(int i=0;i<num-2;i++){
            pasta.add(sc.nextInt());
        }

        for(int i=0;i<2;i++){
            fruit.add(sc.nextInt());
        }

        double price = getPrice(pasta, fruit);
        System.out.printf("%.1f", price);
    }


}
