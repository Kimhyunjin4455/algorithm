package org.example.algorithmSolution.problem;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class KnapsackGold1 {
    // test comment
//    static ArrayList<Integer> left, right;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        int N = Integer.parseInt(st.nextToken());   // N개의 물건을 가지고 있고, 최대 C만큼의 무게
//        int C = Integer.parseInt(st.nextToken());
//
//        int[] nums = new int[N];
//        st = new StringTokenizer(br.readLine(), " ");
//        for(int i=0; i<N; i++){
//            nums[i] = Integer.parseInt(st.nextToken());
//        }
//
//        // 두개의 배열 생성
//        left = new ArrayList<>();
//        right = new ArrayList<>();
//
//        int curSum = 0;
//
//        // 각 배열에 대해 부분합들을 구해 리스트에 추가
//        dfs(nums, curSum, 0, left.size(), left);
//        dfs(nums, curSum, 0, right.size(), right);
//
//        // 아래의 while문의 조건 계산을 위해 정렬
//        Collections.sort(left);
//        Collections.sort(right);
//
////        for (int i:left){
////            System.out.print(i+" ");
////        }
//
//        int start = 0;
//        int end = right.size()-1;
//        long cnt = 0;
//        while(start < left.size() && end >=0){
//            int leftValue = left.get(start);
//            int rightValue = right.get(end);
//            // 두 위치의 값의 합이 구하려는 무게와 같다면
//            if(leftValue+rightValue == C){
//                long leftCnt = 0;
//                long rightCnt = 0;
//
//                while(start < left.size() && left.get(start) == leftValue){
//                    leftCnt++;
//                    start++;
//                }
//
//                while (end >= 0 && right.get(end) == rightValue){
//                    rightCnt++;
//                    end--;
//                }
//
//                cnt += (leftCnt * rightCnt);
//
//
//            }
//            if(leftValue+rightValue < C){
//                cnt++;
//                start++;
//            }
//            // 합보다 크다면 더 작은 값 구하도록
//            if(leftValue+rightValue > C){
//                end--;
//            }
//        }
//
//        if(C==0){
//            bw.write(String.valueOf(cnt-1));
//        }else {
//            bw.write(String.valueOf(cnt));
//        }
//
//        bw.flush();
//        bw.close();
//        br.close();
//
//    }
//
//    private static void dfs(int[] nums, int sum, int start, int end, ArrayList<Integer> list) {
//        if(start == end){
//            list.add(sum);
//            return;
//        }
//        dfs(nums, sum + list.get(start), start+1, end, list);
//        dfs(nums, sum, start+1, end, list);
//    }

    static int S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        int sum = 0;

        // 배열을 두개의 리스트로 분리 후 부분합 저장
        dfs(0, N/2, sum, left, nums);
        dfs(N/2, N, sum, right, nums);

        // 이분 탐색을 위한 정렬
        Collections.sort(left);
        Collections.sort(right);

//        for(int i: left){
//            System.out.print(i+" ");
//        }
//        System.out.println();
//
//        for (int j:right){
//            System.out.print(j+" ");
//        }
//        System.out.println();


        int answer = 0;

        // 이진 탐색
        // ex: left[2,1,1,0] / right[0,1,1,2] / S == 2
        // 1. 하나의 리스트를 정렬시에는 left 리스트의 어느값에 대해 right에 더할수 있는 갯수를 구하면 됨 3개 <- 마지막 더할 위치의 인덱스+1
        // ex: left[0,1,1,2] / right[0,1,1,2] / S == 2
        // 2. 두가지를 정렬시켜도 마찬가지

        for(int i=0; i<left.size(); i++){
            int searchValue = (S -left.get(i)); // 찾아야 되는 값 -> right의 특정값을 찾기 위함
            answer += binarySearch(searchValue, right) + 1 ; // right의 값이 searchValue인 마지막 인덱스를 찾을 함수, 갯수는 인덱스에 1을 더한 값이므로 +1
        }

        bw.write(String.valueOf(answer));






        bw.flush();
        bw.close();
        br.close();
    }

    private static int binarySearch(int searchValue, ArrayList<Integer> list) {
        int start = 0;
        int end = list.size()-1;
        int cnt = 0;
        while (start <= end){
            int mid = (start+end) / 2;
            if(list.get(mid) <= searchValue){
                // ex: left[2,1,1,0] / right[0,1,1,2] / S == 2
                // 1. searchValue의 값이 1인 경우 right 리스트에서 list.get(mid) 의 값은 0,1,1이 될 수 있음
                // 2. 첫번째 mid의 값(0+3/2)은 1 -> right[mid]는 earchValue의 값 -> cnt는 1
                // 3. 두번째 start의 값은 mid+1(2) -> 두번째 mid의 값은 2(2+3/2) -> right[mid]는 searchValue의 값 -> cnt는 2
                // 4. start의 값은 mid+1(3) -> 다음 while에서 조건에 맞지 않기에 탈출
                cnt = mid; // 중간 지점이 찾고자 하는 값이 맞다면 그 값(위치)을 인덱스에 저장
                start = mid+1; //그 이후엔 그 값보다 같거나 큰 값만 있는 오른쪽 리스트만 보기 위해 start값 변경
            }
            else end = mid-1; // 찾는 값보다 크다면 그 다음 탐색의 범위는 그 값보다 작은 값이 마지막이 되도록
        }
        return cnt;

    }

    private static void dfs(int start, int end, int sum, ArrayList<Integer> list, int[] nums) {
        if (sum > S) return; // 쓸모 없는 반복을 줄일 수 있음

        if (start == end){
            list.add(sum);
            return; /**중요*/
        }
        dfs(start+1, end, sum+nums[start], list, nums);
        dfs(start+1, end, sum, list, nums);
    }


}
