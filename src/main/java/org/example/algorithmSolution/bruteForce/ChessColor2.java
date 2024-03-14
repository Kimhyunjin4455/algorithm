package org.example.algorithmSolution.bruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class ChessColor2 {

    // W(하얀색) 과 B(검은색)을 구분하기 위해 boolean 2차원 배열을 사용
    // W 일 때는 true, B 일때는 false 로 표현
    public static boolean[][] arr;
    public static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 경우의 수는 (가로 칸 개수 - 7) × (세로 칸 개수 - 7) x 2( 흰색인지 검은색인지 )
        // 최소 크기가 8×8 일 때 경우의 수가 1이기 때문에 각 가로 세로별 길이에 -7

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new boolean[N][M];

        for (int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                if (s.charAt(j)=='W'){
                    arr[i][j] = true;
                }else arr[i][j] = false;
            }
        }

        int nRow = N-7;
        int mCol = M-7;

        for(int i=0; i<nRow; i++){  /** N이 8일때 nRow의 값은 1이 되어, 1번의 반복을 수행할 수 있음 */
            for (int j=0; j<mCol; j++){
                find(i,j);
            }
        }
        //System.out.println(result);
        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }

    public static void find(int row, int col){
        int endRow = row+8;
        int endCol = col+8;
        int cnt = 0;

        boolean tf = arr[row][col];             // 첫 번째 칸의 색상

        for(int i=row; i<endRow; i++){
            for(int j=col; j<endCol; j++){
                if(arr[i][j] != tf){
                    cnt++;                      // 올바른 색이 아니면 cnt++
                }
                tf = (!tf);                     // 다음칸은 색이 변경되므로 tf값도 변경
            }
            tf = (!tf);
        }

        cnt = Math.min(cnt, 64-cnt);            // 첫 번째 칸을 기준으로 할 때의 색칠 할 개수 cnt
                                                // 첫 번째 칸의 색의 반대되는 색을 기준으로 할 때의 색칠 할 개수(64 - cnt) 중 최솟값을 cnt 에 저장
        result = Math.min(result, cnt);
    }
}
