package com.codingtest.level1;

//양수 음수 더하기
public class NegposAdd {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i=0;i<absolutes.length;i++){
            int value=absolutes[i];
            if(!signs[i]) //부호가 false 이면
                value*=-1;

            answer+=value;
        }

        return answer;
    }

}
