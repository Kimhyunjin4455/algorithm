package org.example.algorithmSolution.problem;

import java.io.*;
import java.util.StringTokenizer;

public class KnapsackGold5 {
    static int[] W;
    static int[] V;

    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());   // 물품 수
        int k = Integer.parseInt(st.nextToken());   // 무게 제한

        dp = new int[n+1][k+1];    // 0개를 담을 때를 계산하기 위해 n + 1, 배낭의 무게는 0부터 k까지 총 k+1 의 길이로 초기화
        W = new int[n+1];   // 0개를 담을 때를 계산하기 위해 size + 1
        V = new int[n+1];



        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            W[i] = w;
            V[i] = v;

        }

        for(int i=1; i<=n; i++){
            for (int j=0; j<=k; j++){
                if(W[i] > j) dp[i][j] = dp[i-1][j]; // i-1(0일때 -1) 인덱스 오류 피하기 위해 배열을 초기화시 길이 +1 했음
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]] + V[i]);
                }
            }
        }

        bw.write(String.valueOf(dp[n][k]));


        bw.flush();
        bw.close();
        br.close();

    }
}
