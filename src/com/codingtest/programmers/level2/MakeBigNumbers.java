package com.codingtest.programmers.level2;

//큰수 만들기
public class MakeBigNumbers {

    public String solution(String number, int k) {
        StringBuilder stringBuilder = new StringBuilder();

        int len = number.length();
        int cut = len - k;
        int count = 0;
        int maxIdx = 0;
        int div = len / 2;

        char[] chars = number.toCharArray();
        char maxChar=chars[0];

        //1.맨 앞에서 반으로 짜른다
        //그중 가장 큰값을 찾는다.
        for (int i = 1; i < div; i++) {
            if (maxChar < chars[i]) {
                maxChar=chars[i];
                maxIdx = i;
            }
        }

        //앞에서 큰놈들을 구함
        for (int i = maxIdx; i < div; i++) {
            if (chars[i] >= chars[div]) {   //중간값보다 크면
                stringBuilder.append(chars[i]);
                count++;
            }
        }


        String answer = stringBuilder.toString();
        return answer;
    }

    public static void main(String[] args) {
        String number = "4177332841";
        int k = 4;

        MakeBigNumbers m = new MakeBigNumbers();
        String solution = m.solution(number, k);

        System.out.println("solution = " + solution);

    }
}
