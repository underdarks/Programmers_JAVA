package com.codingtest.leetcode.easy;

//704. Binary Search
public class BinarySearch {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid=0;

        while(left <=right){
            mid=(left+right)/2;

            if(nums[mid] == target)
                return mid;

            else if(nums[mid] > target)
                right=mid-1;

            else
                left=mid+1;

        }

        return -1;
    }

    public static void main(String[] args) {
        int []nums={-1,0,3,5,9,12};
        int target=9;
        BinarySearch bs=new BinarySearch();
        int search = bs.search(nums, target);

        System.out.println("search = " + search);

    }
}
