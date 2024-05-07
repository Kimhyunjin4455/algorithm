package org.example.algorithmSolution.dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon1987 {
    static int R,C;
    static String[][] routeGraph;
    static int result;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        routeGraph = new String[R][C];
        visited = new boolean[R][C];

        for (int i=0; i<R; i++){
            String str = br.readLine();
            for (int j=0; j<C; j++){
                routeGraph[i][j] = String.valueOf(str.charAt(j));
            }
        }

        dfs(0,0,1, routeGraph[0][0]);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();



    }

    private static void dfs(int row, int col, int nowResult, String str) {

        result = Math.max(result, nowResult);



        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        for (int i=0; i<4; i++){
            int nr = row+dr[i];
            int nc = col+dc[i];
            if(nr>=0 && nr < R && nc >=0 && nc < C && !visited[nr][nc]){
                if (!str.contains(routeGraph[nr][nc])){
                    visited[nr][nc] = true;
                    dfs(nr,nc,nowResult+1, str+routeGraph[nr][nc]);
                    visited[nr][nc] = false;
                }
            }

        }

    }
}
