package com.codingtest.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//242. Valid Anagram
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map=new HashMap<>();
        if (s.length() != t.length())
            return false;
        char[] c1=s.toCharArray();
        char[] c2=t.toCharArray();
        //오름차순 정렬
        Arrays.sort(c1);
        Arrays.sort(c2);

        for (int i = 0; i < c1.length; i++) {
            if(c1[i] != c2[i]) return false;
        }

        return true;
//        //해쉬로 풀기
//        //1.해쉬생성(문자열의 각 문자를 해쉬화)
//        for(char c: t.toCharArray()){
//            Integer value = map.getOrDefault(c, 0);
//            map.put(c,value+1);
//        }
//
//        //2.아나그램 비교
//        for(char c: t.toCharArray()){
//            Integer value = map.getOrDefault(c, 0);
//            if(value.equals(0))
//                return false;
//
//            else
//                map.put(c,value-1);
//        }
//
//        //3.
//        for (Character key : map.keySet()) {
//            if(map.get(key) > 0)
//                return false;
//        }
//
//        return true;
    }
}
