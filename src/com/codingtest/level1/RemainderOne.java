package com.codingtest.level1;

//나머지가 1이 되는 수
public class RemainderOne {
    public int solution(int n) {
        int answer = 0;

        for(int i=2;i<n;i++){
            if(n%i == 1) {
                answer= i;
                break;
            }
        }

        return answer;
    }
}
