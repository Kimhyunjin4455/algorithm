package org.example.algorithmSolution.twoPointer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class TwoPointerEx1208 {
    // N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S
    // -> 꼭 연속하지 않은 수열이어도 상관없음, 부분수열이기만 하면 됨

    static ArrayList<Integer> left, right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];

        left = new ArrayList<>();
        right = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<nums.length; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }


        int start = 0;
        int end = right.size()-1;
        int sum = 0;
        long cnt = 0;

        // 두개의 배열로 분리하고, 각 배열마다 투포인터로 부분합 구함

        dfs(0, N/2, sum, left, nums);
        dfs(N/2, N, sum, right, nums);


        // 이진 탐색 위한것
        Collections.sort(left); // -10 -7 -3 0
        Collections.sort(right); // -2, 0, 3, 5, 6, 8, 11, 13


        // 하나는 앞에서, 하나는 뒤에서부터 시작해 각 값을 더해보고 S와 비교
        // S보다 합이 작다면 앞에서부터 시작한 리스트의 포인터를 1 증가, 만약 S보다 합이 크다면 뒤에서부터 시작한 리스트의 포인터를 1 감소
        while(start < left.size() && end >=0){ // 하나는 앞에서, 하나는 뒤에서부터 시작해 범위를 벗어나지 않도록
            int leftValue = left.get(start);
            int rightValue = right.get(end);

            // 만약 S와 합이 일치하다면 / 합을 이루는 값들이 각 리스트에 들어있는 개수를 세어 그 쌍을 이룰 수 있는 경우의 수를 구하고 + cnt
            /** 정렬이 되어있으므로 아래의 탐색 가능*/
            if(leftValue + rightValue == S){ // leftValue 와 rightValue의 중복쌍을 세기 위함
                long leftCnt = 0;
                while(start < left.size() && left.get(start) == leftValue){ // 범위를 벗어나지 않고, 현재값이 비교할값과 같다면
                    leftCnt++;
                    start++;
                }
                long rightCnt = 0;
                while(end >= 0 && right.get(end) == rightValue){
                    rightCnt++;
                    end--;
                }
                cnt += (leftCnt * rightCnt); // 두 배열의 경우의 수를 곱해야 쌍을 이루는 경우의 수가 구해짐
            }
            if(leftValue + rightValue <S){ // 아래의 두 조건식은 left와 right가 nums라는 수열로부터 분할되었기에 가능
                start++;
            }
            if (leftValue + rightValue >S) {
                end --;
            }


        }

        if(S==0){
            bw.write(String.valueOf(cnt-1)); // 합이 0일때는 부분수열에서 하나도 선택하지 않은경우(0,0 => 공집합 2개)도 포함하기에 -1
            // 문제는 크기가 양수인 부분수열을 구하는 문제!
        }else {
            bw.write(String.valueOf(cnt));
        }


        bw.flush();
        bw.close();
        br.close();

    }

    // 부분수열의 합을 구하는 재귀함수
    public static void dfs(int start, int end, int sum, ArrayList<Integer> list, int[] nums) {
        if(start == end){ // 더하거나 안더하면서 부분합들을 list에 더해나감
            list.add(sum);
            return;
        }

        dfs(start+1, end, sum+nums[start], list, nums);
        dfs(start+1, end, sum, list, nums);

    }
}
