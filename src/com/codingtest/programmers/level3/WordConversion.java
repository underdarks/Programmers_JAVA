package com.codingtest.programmers.level3;

import java.util.Arrays;

//단어 변환
public class WordConversion {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Arrays.sort(words);


        return answer;
    }

    public static void main(String[] args) {
        String begin="hit";
        String target="cog";
        String []words={"hot", "dot", "dog", "lot", "log", "cog"};

        WordConversion wc=new WordConversion();
        int solution = wc.solution(begin, target, words);

        System.out.println("solution = " + solution);
    }

}
