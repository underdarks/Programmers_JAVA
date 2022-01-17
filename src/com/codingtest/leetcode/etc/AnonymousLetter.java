package com.codingtest.leetcode.etc;

import java.util.HashMap;
import java.util.Optional;

//p.251 익명의 편지 작성하기
public class AnonymousLetter {
    public boolean isLetterConstructibleFromMagazine(String letterText,String magazineText){
        HashMap<Character,Integer> map=new HashMap<>();

        //1.공백 제거
        letterText=letterText.replace(" ","");
        magazineText=magazineText.replace(" ","");

        if(letterText.length() > magazineText.length())
            return false;

        //2.잡지 문자열 해쉬화
        for (char key : letterText.toCharArray()) {
            Integer value = map.getOrDefault(key, 0);
            map.put(key,value+1);
        }

        //3.문자 매칭
        for (Character key : magazineText.toCharArray()) {
            Integer value = map.getOrDefault(key, 0);
            if(value <1)
                return false;

            map.put(key,value-1);
        }

        return true;
    }

    public static void main(String[] args) {
        String letterText="a p p   l  e";
        String magazineText="a p l e z";

        AnonymousLetter a=new AnonymousLetter();
        System.out.println(a.isLetterConstructibleFromMagazine(letterText,magazineText));

    }
}
