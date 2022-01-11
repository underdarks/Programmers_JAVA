package com.codingtest.level1;

//카카오 아이디 추천
public class Kakao_NewId {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        String answer = "";

        //1.대문자를 소문자로 변환
        new_id = new_id.toLowerCase();

        //2.알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");

        int len = new_id.length();
        //3.마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        for (int i = 0; i < len; i++) {
            char now = new_id.charAt(i);
            char after = 0;
            if (i + 1 < len)
                after = new_id.charAt(i + 1);

            //마침표가 2번 연속이면
            if (now == after && now == '.')
                ;

            else
                sb.append(now);
        }


        if (sb.length() > 0) {
            //4.마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
            if (sb.charAt(0) == '.')
                sb.deleteCharAt(0);

            if (sb.charAt(sb.length() - 1) == '.')
                sb.deleteCharAt(sb.length() - 1);
        }

        new_id = sb.toString();
        //5.빈 문자열이라면, new_id에 "a"를 대입합니다.
        if (new_id.isEmpty())
            new_id = "a";

        //6.길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        if (new_id.length() > 15)
            new_id = new_id.substring(0, 15);

        //7.new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if (new_id.length() < 3) {
            for (int i = new_id.length() - 1; i < 3 && new_id.length() < 3; i++) {
                char after = new_id.charAt(i);
                new_id += after;
            }
        }

        return new_id;
    }


    public static void main(String[] args) {
        String str = "...!@BaT#*..y.abcdefghijklm\"";

        Kakao_NewId newId = new Kakao_NewId();
        System.out.println(newId.solution(str));
    }
}
