package org.example.algorithmSolution.twoPointer;

public class TwoPointerSlidingWindow {
    public static void main(String[] args) {
        // 고정된 길이의 윈도우를 배열이나 리스트에서 슬라이딩하면서 특정 조건을 만족하는 부분 구간을 찾음
        // ex: 슬라이딩 윈도우를 이용하여 배열에서 k의 길이만큼의 합 중 최대 값을 찾기
        // 1. 초기 윈도우의 합을 계산
        // 2. 윈도우를 이동하며 최대값을 찾고, 출력

        int[] nums = {2,3,4,2,4,5,6,1};
        int k = 3;
        int maxSum =0;
        int curSum =0;

        // 초기 윈도우 값 계산
        for (int i=0; i<k; i++){
            curSum+=nums[i];
        }

        maxSum = curSum;

        // 윈도우 이동하며 최대값 구하기
        for(int i=k; i< nums.length; i++){
            curSum = (curSum - nums[i-k]) + nums[i];
            // i==3일때, 현재합계에서 nums[0]을 빼고 nums[1] 더함
            // i==4일때, 현재합에서 nums[1]을 빼고 nums[4] 더함
            maxSum = Math.max(curSum, maxSum);
        }

        System.out.println(maxSum);
    }
}
