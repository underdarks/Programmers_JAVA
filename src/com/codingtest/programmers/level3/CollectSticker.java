package com.codingtest.programmers.level3;

//https://programmers.co.kr/learn/courses/30/lessons/12971
//스티커 모으기(2)
public class CollectSticker {

    public int solution(int sticker[]) {
        int leftDp[] = new int[sticker.length];//왼쪽 스티커를 처음 때어 냇을 때
        int rightDp[] = new int[sticker.length];   //오른쪽 스티커를 처음 때어 냈을 떄

        if (sticker.length == 1)
            return sticker[0];

        leftDp[1] = leftDp[0] = sticker[0];



        rightDp[0] = 0;
        rightDp[1] = sticker[1];


        //왼쪽 스티커 처음 땔 때
        for (int i = 2; i < sticker.length - 1; i++)
            leftDp[i] = Math.max(sticker[i] + leftDp[i - 2], leftDp[i - 1]);

        //오른쪽 스티커를 처음 떌 때
        for (int i = 2; i < sticker.length; i++)
            rightDp[i] = Math.max(sticker[i] + rightDp[i - 2], rightDp[i - 1]);


        return Math.max(leftDp[leftDp.length - 1], rightDp[rightDp.length-2]);
    }


    public static void main(String[] args) {
//        int[] sticker = {1, 3, 2, 5, 4};
        int[] sticker = {14, 6, 5, 11, 3, 9, 2, 10};
        CollectSticker c = new CollectSticker();
        int solution = c.solution(sticker);

        System.out.println("solution = " + solution);
    }
}
