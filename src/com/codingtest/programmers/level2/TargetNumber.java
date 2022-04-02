package com.codingtest.programmers.level2;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//https://programmers.co.kr/learn/courses/30/lessons/43165
//타겟 넘버
public class TargetNumber {

    static int counts =0;

    //DFS 탐색(Recursion)
    public void getTargetNumberRecursion(int[] numbers, int target, int sum, int idx){
        if(sum == target && numbers.length == idx)  //해당값이 같고 모든 수를 다 활용헀으면
            counts++;

        if(numbers.length == idx)    //반복문 끝이면 종료
            return;

        getTargetNumberRecursion(numbers,target,sum+numbers[idx],idx+1);
        getTargetNumberRecursion(numbers,target,sum+(numbers[idx]*-1),idx+1);
    }


    //DFS 탐색(Stack)
    public int getTargetNumberStack(int[] numbers,int target){
        int count=0;

        Stack<Integer []> stack=new Stack<>();
        stack.push(new Integer[]{0,0});    //값, 인덱스

        while(!stack.isEmpty()){
            Integer[] nums = stack.pop();

            if(nums[0] == target && nums[1] == numbers.length) {
                System.out.print("sum = " + nums[0]);
                System.out.println(", total index = " + nums[1]);
                count++;
            }

            if(nums[1] == numbers.length) continue;


            stack.push(new Integer[]{nums[0] + (numbers[nums[1]] * -1), nums[1] + 1});
            stack.push(new Integer[]{nums[0] + numbers[nums[1]], nums[1] + 1});

        }

        return count;
    }

    //BFS 탐색(Que)
    public int getTargetNumberQue(int[] numbers,int target){
        int count=0;

        Queue<Integer []> que =new LinkedList<>();
        que.add(new Integer[]{0,0});    //값, 인덱스

        while(!que.isEmpty()){
            Integer[] nums = que.poll();

            if(nums[0] == target && nums[1] == numbers.length) {
                System.out.print("sum = " + nums[0]);
                System.out.println(", total index = " + nums[1]);
                count++;
            }

            if(nums[1] == numbers.length) continue;


            que.offer(new Integer[]{nums[0] + (numbers[nums[1]] * -1), nums[1] + 1});
            que.offer(new Integer[]{nums[0] + numbers[nums[1]], nums[1] + 1});

        }

        return count;
    }



    public int solution(int[] numbers, int target) {


        //getTargetNumberRecursion(numbers,target,0,0);
//        int answer = getTargetNumberStack(numbers, target);

        int answer = getTargetNumberQue(numbers, target);
        return answer;

//        return counts;
    }

    public static void main(String[] args) {
        int []numbers={1, 1, 1, 1, 1};
//        int []numbers={4, 1, 2, 1};
        TargetNumber tn=new TargetNumber();
        int s = tn.solution(numbers, 3);

        System.out.println("s = " + s);

    }
}
