package com.codingtest.programmers.level2;


//https://programmers.co.kr/learn/courses/30/lessons/43165
//타겟 넘버
public class TargetNumber {

    static int counts =0;

    //DFS 탐색
    public void getTargetNumberDFS(int[] numbers, int target, int sum, int idx){
        if(sum == target && numbers.length == idx)  //해당값이 같고 모든 수를 다 활용헀으면
            counts++;

        if(numbers.length == idx)    //반복문 끝이면 종료
            return;

        getTargetNumberDFS(numbers,target,sum+numbers[idx],idx+1);
        getTargetNumberDFS(numbers,target,sum+(numbers[idx]*-1),idx+1);
    }



    public int solution(int[] numbers, int target) {
        getTargetNumberDFS(numbers,target,0,0);
        return counts;
    }

    public static void main(String[] args) {
//        int []numbers={1, 1, 1, 1, 1};
        int []numbers={4, 1, 2, 1};
        TargetNumber tn=new TargetNumber();
        int s = tn.solution(numbers, 4);

        System.out.println("s = " + s);

    }
}
