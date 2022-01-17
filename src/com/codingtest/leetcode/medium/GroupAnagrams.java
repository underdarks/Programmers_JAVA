package com.codingtest.leetcode.medium;

import java.util.*;

//49. Group Anagrams
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list=new ArrayList<>();
        HashMap<String,List<String>> map=new HashMap<>();

        //1.정렬 후 map에 담기
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key= String.valueOf(chars);  //char[] -> string 변환

            List<String> values = map.getOrDefault(key, new ArrayList<>());
            values.add(strs[i]);
            map.put(key,values);
        }

        //2.맵에서 꺼내서 담기
        for (String key : map.keySet())
            list.add(map.get(key));

        return list;
    }

    public static void main(String[] args) {
        String []strs={"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams g=new GroupAnagrams();
        g.groupAnagrams(strs);
    }
}
