package com.codingtest.level1;

import java.util.*;

//완주하지 못한 선수
public class RetirePlayer {
    public String solution(String[] participant, String[] completion) {
        LinkedList<String> result=new LinkedList<>(Arrays.asList(participant));

        //오름차순 정렬
        Collections.sort(result);
        Arrays.sort(completion);

        for(int i=0;i<completion.length;i++){
            int index = result.indexOf(completion[i]);
            if(index == -1)     //해당 값이 없으면 완주하지 못한 선수
                return completion[i];
            result.remove(index);
        }

        return result.get(0);   //맨 마지막 값이 완주하지 못한 선수
    }

    public static void main(String[] args) {
        String []part={"mislav", "stanko", "mislav", "ana"};
        String []comp={"stanko", "ana", "mislav"};

        List<String> strings = Arrays.asList(part);


        RetirePlayer r=new RetirePlayer();
        System.out.println(r.solution(part,comp));
    }
}

