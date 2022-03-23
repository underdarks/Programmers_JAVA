package com.codingtest.programmers.dev_match;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//다단계 칫솔 판매
//https://programmers.co.kr/learn/courses/30/lessons/77486
public class ToothBrushSales {

    public Map<String, String> makeGraph(String[] enroll, String[] referral) {
        Map<String, String> graph = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            String child = enroll[i];
            String parents = referral[i];

            graph.putIfAbsent(child, parents);
        }

        return graph;
    }

    //수익을 그룹화 한다(seller 금액 그룹화)
    public Map<String, List<Integer>> groupMoney(String[] seller, int[] amount) {
        Map<String, List<Integer>> moneys = new HashMap<>();

        for (int i = 0; i < seller.length; i++){
            moneys.putIfAbsent(seller[i],new ArrayList<>());
            moneys.get(seller[i]).add(amount[i]*100);
        }


        return moneys;
    }

    //비용 정산(DFS 탐색)
    public void costSettlement(String seller, List<Integer>moneys, Map<String, Integer> total, Map<String, String> graph) {
        String recommand = graph.getOrDefault(seller, ""); //판매자의 추천인

        if (!recommand.isEmpty()) {
            List<Integer> fees = new ArrayList<>();

            for (Integer money : moneys) {
                int fee = (int) (money * 0.1);    //수수료 10퍼
                int revenue = money - fee;        //수익 = 금액 - 수수료
                total.put(seller, total.getOrDefault(seller, 0) + revenue);

                if(fee >0)
                    fees.add(fee);
            }

            if(!fees.isEmpty())
                costSettlement(recommand, fees, total, graph);
        }
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        //1. 그래프 만들기 및 비용 초기화
        Map<String, Integer> total = new HashMap<>();
        Map<String, String> graph = makeGraph(enroll, referral);
        Map<String, List<Integer>> groupMoney = groupMoney(seller,amount);

        //2. 비용 정산
        for (Map.Entry<String, List<Integer>> entry : groupMoney.entrySet()) {
            String sell = entry.getKey();
            costSettlement(sell, groupMoney.get(sell), total, graph);
        }

        //결과
        for (int i = 0; i < enroll.length; i++)
            answer[i] = total.getOrDefault(enroll[i], 0);


        return answer;
    }

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};

        String[] seller = {"young", "john", "young", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};


        ToothBrushSales tbs = new ToothBrushSales();
        int[] solution = tbs.solution(enroll, referral, seller, amount);

        for (int i : solution) {
            System.out.print(i + ", ");
        }


    }
}
