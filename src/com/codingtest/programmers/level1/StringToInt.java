package com.codingtest.programmers.level1;


//문자열 정수로 바꾸기
public class StringToInt {
    public int solution(String s) {
        int answer = 0;
        char sign = s.charAt(0);

        //맨앞이 숫자가 아니면(부호이면)
        if (!Character.isDigit(sign)) {
            s = s.substring(1);
            answer = Integer.parseInt(sign + s);
        }

        else
            answer=Integer.parseInt(s);


        return answer;
    }

    public static void main(String[] args) {
        String s="-1234";
        System.out.println(Integer.parseInt(s));

        StringToInt stringToInt=new StringToInt();
//        System.out.println(stringToInt.solution(s));
    }
}
