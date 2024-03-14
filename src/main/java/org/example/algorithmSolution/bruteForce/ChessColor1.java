package org.example.algorithmSolution.bruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class ChessColor1{

    static String[] graph;
    static int result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new String[N];

        // 지도 입력
        for(int i=0; i<N; i++){
            graph[i] = br.readLine();
        }

        // 8X8사이즈로 이동하면서 색 바꿔야 하는 갯수 세기 + 다 세고 나서 최솟값보다 작으면 갱신
        // 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우
        result = Integer.MAX_VALUE;
        for (int i=0; i<=(N-8); i++){ /** 길이가 8일 때 1번 반복, 9일 때 2번 반복 위함 */
            for (int j=0; j<=(M-8); j++){
                int nowResult = getResult(i,j,graph);
                if (result > nowResult) result = nowResult;
            }
        }
//        System.out.println(result);
        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();


        // 풀이: min(체스판의 맨 왼쪽 위가 블랙일 경우 색 변경 갯수, 체스판의 맨 왼쪽 위가 화이트일 경우 색 변경 갯수)
        // 블랙일 경우 변경하는 색의 수 + 화이트일 경우 변경하는 색의 수 = 그 체스판의 사이즈( ex:8*8의 판일 경우 64 )

    }

    private static int getResult(int startRow, int startCol, String[] graph) {
        String[] chessBoard = {"BWBWBWBW", "WBWBWBWB"};
        int whiteResult = 0;
        for(int i=0; i<8; i++){
            int row = startRow + i;
            for(int j=0; j<8; j++){
                int col = startCol + j;
                if(graph[row].charAt(col) != chessBoard[row%2].charAt(j)) whiteResult++;
            }
        }
        return Math.min(whiteResult, 64-whiteResult);
    }
}


