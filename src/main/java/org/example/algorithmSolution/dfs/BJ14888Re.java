package org.example.algorithmSolution.dfs;

import java.io.*;
import java.util.StringTokenizer;

public class BJ14888Re {
    static int N;
    static int[] nums;
    static int minValue = Integer.MAX_VALUE;
    static int maxValue = Integer.MIN_VALUE;
    static int addCnt, subCnt, mulCnt, divCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i< nums.length; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }


        st = new StringTokenizer(br.readLine(), " ");
        addCnt = Integer.parseInt(st.nextToken());
        subCnt = Integer.parseInt(st.nextToken());
        mulCnt = Integer.parseInt(st.nextToken());
        divCnt = Integer.parseInt(st.nextToken());


        int nowValue = nums[0];
        dfs(0, nowValue);

        bw.write(String.valueOf(maxValue));
        bw.flush();
        System.out.println();
        bw.write(String.valueOf(minValue));
        bw.flush();

        bw.close();
        br.close();


    }

    private static void dfs(int idx, int nowValue) {
        if(idx == N-1){
            maxValue = Integer.max(nowValue, maxValue);
            minValue = Integer.min(nowValue, minValue);
        }

        // 백트래킹 실행으로 결괴값들의 최대와 최소를 구함
        if(addCnt>0){
            addCnt--;
            dfs(idx+1, nowValue+nums[idx+1]);
            addCnt++;
        }
        if(subCnt>0){
            subCnt--;
            dfs(idx+1, nowValue-nums[idx+1]);
            subCnt++;
        }
        if (mulCnt>0){
            mulCnt--;
            dfs(idx+1, nowValue*nums[idx+1]);
            mulCnt++;
        }
        if (divCnt>0){
            divCnt--;
            dfs(idx+1, nowValue/nums[idx+1]);
            divCnt++;
        }
    }
}
