package com.codingtest.programmers.level2.kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//2019 KAKAO BLIND RECRUITMENT > 오픈채팅방
public class OpenChatRoom {

    public Map<String,String> makeAcation(){
        Map<String, String> action=new HashMap<>();
        action.put("Enter","님이 들어왔습니다.");
        action.put("Leave","님이 나갔습니다.");

        return action;
    }

    public String[] solution(String[] record) {
        Map<String, String> idMap=new HashMap<>();          //key: I, value: NICKNAME
        Map<String, String> actionMap=makeAcation();        //key: action, value: 액션에 따른 출력물
        List<String> list=new ArrayList<>();

        for (String s : record) {
            String[] rec = s.split(" ");

            if(!rec[0].equals("Leave"))
                idMap.put(rec[1],rec[2]);
        }

        for (String s : record) {
            String[] rec = s.split(" ");

            if(!rec[0].equals("Change"))
                list.add(idMap.get(rec[1])+actionMap.get(rec[0]));
        }

        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {
        String []record={"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        OpenChatRoom ocr=new OpenChatRoom();
        String[] solution = ocr.solution(record);

        for (String s : solution) {
            System.out.print(s+ " ");
        }

    }
}
