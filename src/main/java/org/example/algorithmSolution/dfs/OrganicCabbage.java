package org.example.algorithmSolution.dfs;

import java.io.*;
import java.util.StringTokenizer;

public class OrganicCabbage {

    static int MAX = 50+10;
    static boolean[][] graph;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int result;

    static void dfs(int row, int col, int M, int N){
        graph[row][col] = false; // 방문처리

        for(int i=0; i<4; i++){
            int newR = row + dr[i];
            int newC = col + dc[i];
            if((0<= newR && newR<M) && (0<=newC && newC <N) &&graph[newR][newC]){ // 이동 가능하다면 다시 dfs
                dfs(newR, newC, M, N);
            }
        }

    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            graph = new boolean[M][N];  // 좌표는 0부터 시작
            for(int j=0; j<K; j++){
                StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
                int row = Integer.parseInt(st2.nextToken());
                int col = Integer.parseInt(st2.nextToken());
                graph[row][col] = true;
            }

            result = 0;
            for(int m=0; m<M; m++){
                for (int n=0; n<N; n++){
                    if (graph[m][n]){
                        dfs(m,n,M,N);
                        result++;
                    }
                }
            }

            bw.write(String.valueOf(result));
            bw.newLine();

//            for(boolean[] bArr: graph){   // 출력 테스트
//                for(boolean b: bArr){
//                    //bw.write(String.valueOf(b));
//                    System.out.print(b+" ");
//                }
//                System.out.println();
//            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
    
}
