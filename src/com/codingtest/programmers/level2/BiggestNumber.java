package com.codingtest.programmers.level2;

import javax.swing.plaf.InsetsUIResource;
import java.util.*;
import java.util.stream.Collectors;

//가장 큰수(정렬)
public class BiggestNumber {
    public void sort(List<Integer> list){
        for(int i=0;i<list.size()-1;i++){
            for(int j=i+1;j<list.size();j++){
                int iVal=list.get(i);  //맨끝자리 크기 비교
                int jVal=list.get(j);
                int value1=iVal%10;  //맨끝자리 크기 비교
                int value2=jVal%10;

                if(value1 < value2){
                    int tmp=list.get(j);
                    list.set(j,list.get(i));
                    list.set(i,tmp);
                }
//
//                else if(value1 == value2 && iVal<jVal){
//                    int tmp=list.get(j);
//                    list.set(j,list.get(i));
//                    list.set(i,tmp);
//                }
            }
        }
    }

    public Map<Integer,List<Integer>> getRankMap(List<Integer> list){
//        int[] nums = new int[list.size()];
        Map<Integer, List<Integer>> map = new HashMap<>();

        //2번째 자리 정렬
        for (Integer value : list) {
            int tmp=value;
            if (value>99){
                tmp=value/10; //몫
            }
            int key = tmp%10;

            List<Integer> values = map.getOrDefault(key, new ArrayList<>());
            values.add(value);
            map.put(key,values);
        }

        //3번 자리 정렬(맨끝자리가 큰놈)
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> values = entry.getValue();
            sort(values);
        }

        return map;
    }


    //숫자 맨앞에꺼 가져오기
    public int getFirstNum(int num){
        int tmp=num;

        while(tmp>=10){
            tmp/=10;
        }

        return tmp;
    }


    public String solution(int[] numbers) {
        StringBuilder stringBuilder=new StringBuilder();
        String answer = "";
        Map<Integer, List<Integer>> map=new HashMap<>();

        //1. 해쉬화(1번째 자리 정렬)
        for (int number : numbers) {
            int key=getFirstNum(number);
            List<Integer> value = map.getOrDefault(key, new ArrayList<>());
            value.add(number);
            map.put(key,value);
        }

        //2. 정렬 및 문자열 변환
        for (int i = 9; i >= 0 ; i--) {
            List<Integer> values = map.getOrDefault(i, null);
            if(values != null){
                Map<Integer, List<Integer>> rankMap = getRankMap(values);//정렬된 상태
                for (int j = 9; j >= 0 ; j--){
                    List<Integer> list = rankMap.getOrDefault(j, null);
                    if(list != null){
                        for (Integer integer : list) {
                            stringBuilder.append(integer.toString());
                        }
                    }

                }
            }

        }

        answer = stringBuilder.toString();
//        answer=answer.replaceAll("0","");

        return answer;
    }

    public static void main(String[] args) {
//        int []nums={99, 98, 91,90,9,9,997,972,923,929,999};
//        int []nums={0, 0, 0};
//        int []nums={90,908,89,898,10,101,1,8,9};
        int []nums={1, 11, 111, 1111};
        BiggestNumber b=new BiggestNumber();
        System.out.println(b.solution(nums));

    }
}
