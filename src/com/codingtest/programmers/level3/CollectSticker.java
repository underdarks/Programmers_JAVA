package com.codingtest.programmers.level3;

//https://programmers.co.kr/learn/courses/30/lessons/12971
//스티커 모으기(2)
public class CollectSticker {

    public int solution(int sticker[]) {
        int leftDp[] = sticker.clone();//왼쪽 스티커를 처음 때어 냇을 때
        int rightDp[] = sticker.clone();   //오른쪽 스티커를 처음 때어 냈을 떄

        if (sticker.length == 1)
            return sticker[0];

        return Math.max(rightDp[0],leftDp[1]);
    }


    public static void main(String[] args) {
//        int[] sticker = {1, 3, 2, 5, 4};
        int[] sticker = {14, 6, 5, 11, 3, 9, 2, 10};
        CollectSticker c = new CollectSticker();
        int solution = c.solution(sticker);

        System.out.println("solution = " + solution);
    }
}
