package org.example.algorithmSolution.twoPointer;


public class TwoPointerSum {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};   // 정렬된 배열
        int target = 8;
        int count = 0;

        int start = 0;
        int end = nums.length-1;

        while(start<end){
            int sum = nums[start] + nums[end];
            if(sum == target){ // 아래 조건은 정렬된 배열이라는 선행 조건이 필요함
                System.out.println(nums[start]+" "+nums[end]);
                count++;
                start++;
                end--;
            } else if (sum < target) {
                start++;
            }else end--;
        }

        System.out.println(count);
    }
}
