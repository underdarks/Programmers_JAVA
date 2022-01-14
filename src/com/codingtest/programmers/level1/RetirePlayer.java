package com.codingtest.programmers.level1;

import java.util.*;

//완주하지 못한 선수
public class RetirePlayer {
    public String solution(String[] participant, String[] completion) {
          //------------------------ 리팩토링 전 -------------------------------//
//        LinkedList<String> result=new LinkedList<>(Arrays.asList(participant));
//
//        //오름차순 정렬
//        Collections.sort(result);
//        Arrays.sort(completion);
//
//        for(int i=0;i<completion.length;i++){
//            int index = result.indexOf(completion[i]);
//            if(index == -1)     //해당 값이 없으면 완주하지 못한 선수
//                return completion[i];
//            result.remove(index);
//        }
//
//        return result.get(0);   //맨 마지막 값이 완주하지 못한 선수


        //------------------------ 리팩토링 후 -------------------------------/
        HashMap<String, Integer> map=new HashMap<>();

        for (String s : participant) {
            //getOrDefault찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환하는 메서드
            Integer value = map.getOrDefault(s,0);
            map.put(s,value+1);
        }

        for (String s : completion) {
            Integer value = map.get(s);
            map.put(s,value-1);
        }

        for (String s : map.keySet()) {
            if(map.get(s) > 0)
                return s;
        }

        return "";
    }

    public static void main(String[] args) {
        String []part={"mislav", "stanko", "mislav", "ana"};
        String []comp={"stanko", "ana", "mislav"};

        RetirePlayer r=new RetirePlayer();
        System.out.println(r.solution(part,comp));
    }
}

