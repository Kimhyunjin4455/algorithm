package org.example.algorithmSolution.bruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class ChessColor3 {

    static int result = Integer.MAX_VALUE;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new String[N];

        for (int i=0; i<N; i++){
            arr[i] = br.readLine();
        }

        bw.write(String.valueOf(count(arr, N, M)));


        bw.flush();
        bw.close();
        br.close();

    }

    public static int count(String[] arr, int N, int M ){

        // 0부터 N - 7행 전까지, 0부터 M - 7열 전까지 탐색
        // 8 * 8 보드를 조각낼 수 있는 경우의 수 ( ex: 9x9 크기의 보드에서는 8x8 크기를 4개 )
        for(int i=0; i<N-7; i++){
            for (int j=0; j< M-7; j++){
                for(int k=0; k<2; k++){
                    // 처음 탐색 기준을 W로 할지 B로 할지
                    char start = (k == 0? 'W':'B');

                    int count =0 ;
                    for(int n=i; n<i+8; n++){
                        for(int m=j; m<j+8; m++){
                            if (start != arr[n].charAt(m)){
                                count++;
                            }
                            start = (start == 'W'? 'B':'W');
                        }
                        start = (start == 'W'?'B':'W');
                    }

                    result = Math.min(result, count);

                    if (result == 0){
                        return 0;
                    }
                }
            }
        }

        return result;
    }
}
