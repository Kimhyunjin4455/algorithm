package org.example.algorithmSolution.twoPointer;

public class TwoPointerSorting {
    public static void main(String[] args) {
        // 정렬된 두 개의 배열이나 리스트를 병합
        // 투 포인터를 사용하여 정렬된 두 배열을 한 번에 비교하고, 작은 값을 새로운 배열에 추가하는 방식
        int[] nums1 = {1,2,3,4,5,6,7,8,16};
        int[] nums2 = {10,11,12,13,14,15};

        int[] merged = new int[nums1.length + nums2.length];

        int i=0;
        int j=0;
        int k=0;

        // i와 j 포인터를 사용하여 nums1과 nums2 배열을 하나씩 비교하여 i, j가 더 작은 경우 종료
        while(i < nums1.length && j < nums2.length){    // i나 j중 하나라도 범위 벗어나면 종료
            // num2 배열의 값이 큰 경우 : merged 배열에 num1 값을 넣고 i를 증가
            if(nums1[i] < nums2[j]) {
                merged[k] = nums1[i];
                i++;
            }else {
                merged[k] = nums2[j];
                j++;
            }
            // 한번의 루프가 종료될때 k 값을 증가
            k++;
        }

//         i가 num1의 길이보다 작으면 num1의 나머지 요소들은 merged에 할당하고 i와 k를 증가 (위 whlie의 병합 끝내고 남은 요소 처리)
        while(i<nums1.length){
            merged[k] = nums1[i];
            i++;
            k++;
        }

        while (j<nums2.length){
            merged[k] = nums2[j];
            j++;
            k++;
        }

        for(int num : merged){
            System.out.print(num+" ");
        }
        System.out.println();
    }
}
