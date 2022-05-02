package com.codingtest.company_coding_test.ESTSOFT;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class codingtext {


    //점수 Map 생성
    public Map<Character,Integer> makeScoreMap(){
        Map<Character,Integer> score=new HashMap<>();
        score.put('A',5);
        score.put('B',4);
        score.put('C',3);
        score.put('D',2);
        score.put('E',1);
        score.put('F',0);

        return score;
    }

    public int solution(String[] scores) {
        Map<Character,Integer> scoreMap= makeScoreMap();
        int answer = 0;

        for (String score : scores) {
            int sum=0;
            int len=score.length()-2;

            //1.F가 2개인 경우 찾는다
            if(score.chars().filter(value -> value == 'F').count() >=2)
                continue;

            //2.A가 2개인 경우 찾는다
            if(score.chars().filter(value -> value == 'A').count() >=2) {
                answer++;
                continue;
            }

            //3. 그 외 경우
            char[] scoreValues = score.toCharArray();
            Arrays.sort(scoreValues);

            for (int i = 1; i < scoreValues.length-1; i++)     //최저, 최고점 제외
                sum+=scoreMap.get(scoreValues[i]);

            if(sum / len >= 3)
                answer++;

        }

        return answer;
    }

    public static void main(String[] args) {
        String []str=new String[]{"AAFAFA", "FEECAA", "FABBCB", "CBEDEE", "CCCCCC"};

//
//        String []str=new String[]{
//                "BCD","ABB","FEE"
//        };
        codingtext c=new codingtext();
        int solution = c.solution(str);
        System.out.println("solution = " + solution);

    }
}
