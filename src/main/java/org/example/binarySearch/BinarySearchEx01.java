package org.example.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearchEx01 {

    static int[] nums = {1,2,3,34,4,5,67,8,89,10};
    static int cnt;

    public static void main(String[] args) {
        Arrays.sort(nums);

        int searchNum = 67;
        cnt = 1;

        binarySearch(searchNum, nums);
        System.out.println(cnt);
        // [1,2,3,4,5] [8,10,34,67,89]
        //
    }

    private static void binarySearch(int searchNum, int[] nums) {
        int start = 0;
        int end = nums.length-1;

        while (start<=end) {
            int mid = (start+end) /2;
            if (nums[mid] == searchNum) {
                return;
            } else if (nums[mid] < searchNum) {
                start = mid + 1;
                cnt++;
            } else {
                end = mid - 1;
                cnt++;
            }
        }

    }
}
