package com.codingtest.level1;

//소수 구하기
public class PrimeNum {
    //소수 판별 알고리즘
    public boolean isPrimeNum(int num){
        for(int i=2;i<Math.sqrt(num)+1;i++){
            if(num%i == 0) return false;
        }

        return true;
    }

    public int solution(int[] nums) {
        int answer = 0;

        //O(N^3)
        //개선 포인트(어떻게 하면 개선할 수 있을까...???)
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++) {
                    int num = nums[i] + nums[j] + nums[k];
                    if (isPrimeNum(num))
                        answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int []nums={1,2,3,4};
        PrimeNum primeNum=new PrimeNum();
        System.out.println(primeNum.solution(nums));
    }
}
