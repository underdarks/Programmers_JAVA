package com.codingtest.programmers.level1.kakao;

import java.util.*;

//https://programmers.co.kr/learn/courses/30/lessons/92334
//2022 KAKAo BLIND RECRIUITMENT > 신고 결과 받기
public class ReportResult {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, List<String>> reportId=new HashMap<>();        //해당 유저를 신고한 Id
        Map<String, Integer> reportedCount =new HashMap<>();       //해당 유저가 신고당한 회수
        Map<String, Integer> mailCount=new HashMap<>();            //해당 유저가 메일을 받은 횟수
        int idx=0;

        //1. 중복 제거
        Set<String> set=new HashSet<String>(List.of(report));

        //2. 신고 조회
        for (String r : set) {
            String[] ids = r.split(" ");

            reportId.putIfAbsent(ids[1],new ArrayList<>());
            reportId.get(ids[1]).add(ids[0]);                       //해당 유저를 신고한 사람들을 추가

            reportedCount.put(ids[1], reportedCount.getOrDefault(ids[1], 0) + 1);  //해당 유저의 신고 횟수 증가
        }

        //3. 메일 보내기
        for (String id : id_list) {
            if(reportedCount.getOrDefault(id,0) >=k){   //해당 유저가 k이상 신고 당했으면
                List<String> list = reportId.get(id);             //해당 유저를 신고한 ID 가져옴

                for (String mailId : list)
                    mailCount.put(mailId,mailCount.getOrDefault(mailId,0)+1);   //메일 발송 횟수 증가

            }

        }

        for (String s : id_list)
            answer[idx++]=mailCount.getOrDefault(s,0);



        return answer;
    }

    public static void main(String[] args) {
        String []idList={"con", "ryan"};
        String []report={"ryan con", "ryan con", "ryan con", "ryan con"};
        int k=3;

        ReportResult reportResult=new ReportResult();
        int[] solution = reportResult.solution(idList, report, k);

        for (int i = 0; i < solution.length; i++) {
            System.out.print("solution[i] = " + solution[i]);

        }
    }
}
