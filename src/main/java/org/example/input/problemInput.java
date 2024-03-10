package org.example.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problemInput {
    static int[][] arr = new int[301][301];

    public static void main(String[] args) throws IOException {
        // ex: n행 m열 배열은 입력 + 받은 후 그대로 출력

        // BufferedReader를 통해, 시스템기본(키보드) 입력을 목적으로 InputStreamReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // br.readLine() 메서드로 한줄 읽고, " "를 기준으로 자름
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");


        /** StringTokenizer
         - 긴 문자열을 지정된 구분자(delimiter)를 기준으로 토큰(token)이라는 여러 개의 문자열로 잘라내는 데 사용
         - nextToken(): 객체에서 다음 토큰을 반환
         - nextToken(String delim): delim 기준으로 다음 토큰을 반환
         */


        // 자른 것 중 하나를 n에 저장 후, 그 다음 것을 m에 저장
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        // 그 다음 부터 행의 갯수만큼 라인을 입력받아서, StringTokenizer로 자름
        for (int i=0; i<n; i++){
            stk = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("n: " +n+ ", m: " +m).append('\n');

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);

    }
}

/**
 입력값
 4 3
 1 2 3
 3 4 5
 6 7 1
 1 2 3

 sb:
 1 2 3
 3 4 5
 6 7 1
 1 2 3

 */
