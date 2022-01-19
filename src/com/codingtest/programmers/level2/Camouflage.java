package com.codingtest.programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//위장(해시)
public class Camouflage {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map=new HashMap<>();

        for (String[] clothe : clothes) {
            String key = clothe[1]; //의상 종류(key)
            Integer value = map.getOrDefault(key, 0);
            map.put(key,value+1);
        }

        for (Integer value : map.values()) {
            answer*=(value+1);
        }

        return answer-1;
    }

    public static void main(String[] args) {
        Camouflage c=new Camouflage();

    }

}
