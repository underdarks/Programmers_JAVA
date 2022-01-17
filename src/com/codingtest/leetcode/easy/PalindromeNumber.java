package com.codingtest.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

//9.Palindrome Number
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;

        HashMap<Character,Integer> map=new HashMap<>();
        String s = Integer.toString(x);
        int len=s.length();

        List<Character> list = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        //중간값 삭제
        if(len%2!=0)
            list.remove(len/2);

        for (Character key : list) {
            Integer value = map.getOrDefault(key, 0);
            map.put(key,value+1);
        }

        for (Integer value : map.values()) {
            if(value%2 !=0)
                return false;
        }

        return true;

//        int first=0;
//        int last=chars.length-1;
//        while(first <= last){
//            if(chars[first++] != chars[last--])
//                return false;
//        }
//
//        return true;
    }
}
