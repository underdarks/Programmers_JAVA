package com.codingtest.programmers_school.week3;

import java.util.*;

public class Camo {

    int[] sums;
    int len;

    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> kinds = new HashMap<>();

        for(String[] cloth : clothes) {
            kinds.put(cloth[1], kinds.getOrDefault(cloth[1], 0) + 1);
        }

        len = kinds.size();
        sums = new int[len];
        int idx = 0;
        for(int t : kinds.values())
            sums[idx++] = t;

        for(int i = 0; i < len; i++)
            answer += wear(i, sums[i]);

        return answer;
    }

    int wear(int idx, int sum) {
        int ans = sum;

        for(int i = idx + 1; i < len; i++) {
            ans += wear(i, sum * sums[i]);
        }

        return ans;
    }

//    public int solution(String[][] clothes) {
//        int answer = 1;
//        Map<String, List<String>> map=new HashMap<>();  //종류별 옷 저장 하기위한 자료
//
//        //1.hash에 저장(옷 조합별로 저장)
//        for (String[] clothe : clothes) {
//            String type = clothe[1];   //종류
//            String name = clothe[0];   //이름
//
//            List<String> values = map.getOrDefault(type, new ArrayList<>());
//            values.add(name);
//            map.put(type, values);
//        }
//
//        //2.경우의 수 찾기(옷 조합 수)
//        /**
//         *  완전탐색으로 풀 수 있지만 시간이 많이 걸린다. 따라서, 조합의 규칙을 찾아서 푼다(경우의 수를 찾아보면 패턴이 있음)
//         *  ex. 상의 2벌 하의 2벌인 경우는 => 총 조합 수 : (상의 갯수 + 1) * (하의 개수 + 1) -1(아무것도 안입으면 안됨)
//         *  => +1을 하는 이유는 상의를 안입고 하의를 입는 경우(혹은 그 반대)를 고려한다. 그리고 -1을 하는 이유는 아무것도 안입으면 안되는 조건이 있음(하나는 꼭 입어야함)
//         *
//         */
//        for (Map.Entry<String, List<String>> stringListEntry : map.entrySet()) {
//            int count = stringListEntry.getValue().size();  //유형 별 옷의 개수
//            answer*=(count+1);
//        }
//
//
//        return answer-1;
//    }

    public static void main(String[] args) {
        Camo camo=new Camo();

        String [][]clothes={
                {"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };

        camo.solution(clothes);
    }


}
