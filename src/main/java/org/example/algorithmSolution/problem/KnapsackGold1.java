package org.example.algorithmSolution.problem;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class KnapsackGold1 {
    // test comment
    static ArrayList<Integer> left, right;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());   // N개의 물건을 가지고 있고, 최대 C만큼의 무게
        int C = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 두개의 배열 생성
        left = new ArrayList<>();
        right = new ArrayList<>();

        int curSum = 0;

        // 각 배열에 대해 부분합들을 구해 리스트에 추가
        dfs(nums, curSum, 0, left.size(), left);
        dfs(nums, curSum, 0, right.size(), right);

        // 아래의 while문의 조건 계산을 위해 정렬
        Collections.sort(left);
        Collections.sort(right);

//        for (int i:left){
//            System.out.print(i+" ");
//        }

        int start = 0;
        int end = right.size()-1;
        long cnt = 0;
        while(start < left.size() && end >=0){
            int leftValue = left.get(start);
            int rightValue = right.get(end);
            // 두 위치의 값의 합이 구하려는 무게와 같다면
            if(leftValue+rightValue == C){
                long leftCnt = 0;
                long rightCnt = 0;

                while(start < left.size() && left.get(start) == leftValue){
                    leftCnt++;
                    start++;
                }

                while (end >= 0 && right.get(end) == rightValue){
                    rightCnt++;
                    end--;
                }

                cnt += (leftCnt * rightCnt);


            }
            if(leftValue+rightValue < C){
                cnt++;
                start++;
            }
            // 합보다 크다면 더 작은 값 구하도록
            if(leftValue+rightValue > C){
                end--;
            }
        }

        if(C==0){
            bw.write(String.valueOf(cnt-1));
        }else {
            bw.write(String.valueOf(cnt));
        }

        bw.flush();
        bw.close();
        br.close();

    }

    private static void dfs(int[] nums, int sum, int start, int end, ArrayList<Integer> list) {
        if(start == end){
            list.add(sum);
            return;
        }
        dfs(nums, sum + list.get(start), start+1, end, list);
        dfs(nums, sum, start+1, end, list);
    }


}
