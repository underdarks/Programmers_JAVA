package com.codingtest.level1;

//중간문자 찾기
public class MidString {
    public String solution(String s) {
        String answer = "";
        int len=s.length();
        int index=len/2;
        if (len % 2 == 0) {   //짝수이면
            answer = s.substring(index-1,index+1);
        }

        else
            answer=s.substring(index,index+1);

        return answer;
    }
}
