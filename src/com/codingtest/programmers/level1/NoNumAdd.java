package com.codingtest.programmers.level1;

import java.util.Arrays;

//없는 숫자 더하기
public class NoNumAdd {

    public boolean binarySearch(int []nums,int findNum)
    {
        int startIndex=0;
        int finalIndex=nums.length-1;

        //이진탐색
        while(startIndex <= finalIndex){
            int mid=(startIndex+finalIndex)/2;

            if(nums[mid] == findNum)        //해당 숫자이면
                return true;

            else if(nums[mid] > findNum)    //중간값이 해당 숫자보다 크면
                finalIndex=mid-1;

            else                            //중간값이 해당 숫자보다 작으면
                startIndex=mid+1;
        }

        return false;
    }


    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);   //이진 탐색을 위한 오름차순 정렬

        for(int i=1;i<10;i++) {
            if(!binarySearch(numbers,i))
                answer+=i;

//            int j=i;
//            if (!Arrays.stream(numbers).anyMatch(val -> val == j)){
//                answer+=i;
            }

        return answer;
    }

    public static void main(String[] args) {
        int []numbers={1,2,3,4,6,7,8,0};
        NoNumAdd noNumAdd=new NoNumAdd();
        System.out.println(noNumAdd.solution(numbers));

    }
}
