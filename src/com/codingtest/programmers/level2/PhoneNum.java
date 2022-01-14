package com.codingtest.programmers.level2;

import java.util.*;

//전화번호 목록
public class PhoneNum {
    public boolean solution(String[] phone_book) {
        //1.배열로 풀기
//        Arrays.sort(phone_book);    //오름차순 정렬
//        for (int i = 0; i < phone_book.length-1; i++) {
//            try {
//                if (phone_book[i + 1].startsWith(phone_book[i])) //앞 비교
//                    return false;
//            }catch (RuntimeException re)
//            {
//
//            }
//        }
//
//        return true;

        //2.해쉬로 풀기
        Map<String, String> map=new HashMap<>();
//        for (int i = 0; i < phone_book.length; i++) {
//            String match = "[^0-9]";
//            phone_book[i]=phone_book[i].replaceAll(match,"");
//        }
        Arrays.sort(phone_book);       //애매함..
        int len=phone_book[0].length();      //가장 짧은 문자열의 길이


//        int[] ints = Arrays.stream(phone_book).mapToInt(Integer::parseInt).toArray();
//        Arrays.sort(ints);
//        int len=Integer.toString(ints[0]).length();

        for (String s : phone_book) {
            try {
                String key = s.substring(0, len);
                String value = map.getOrDefault(key, s);
                if (!s.equals(value) && s.startsWith(value))    //접두사가 있다면
                    return false;
                map.put(key, value);
            }
            catch (RuntimeException re){
                return false;
            }
        }

//        System.out.println("캐치 OUT");
        return true;
    }

    public static void main(String[] args) {
        String []pb={"12367==&*(&(*&456", "78","3433"};
        PhoneNum p=new PhoneNum();
        System.out.println(p.solution(pb));
    }
}
