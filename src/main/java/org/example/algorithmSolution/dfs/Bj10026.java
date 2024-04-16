package org.example.algorithmSolution.dfs;

import java.io.*;

public class Bj10026 {
    static int N;
    static boolean[][] visited;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int ans, grAns;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        String[][] graph = new String[N][N];
        String[][] grGraph = new String[N][N];

        for (int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                graph[i][j] = String.valueOf(str.charAt(j));
                grGraph[i][j] = String.valueOf(str.charAt(j));
                if(graph[i][j].equals("G")){
                    grGraph[i][j] = "R";
                }
            }
        }

        String startStr = graph[0][0];

        visited = new boolean[N][N];
        ans = 0;
        for(int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (visited[i][j] == false){
                    dfs(startStr, i,j, graph);
                    ans += 1;
                }
            }
        }
        visited = new boolean[N][N];
        grAns = 0;
        for(int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (visited[i][j] == false){
                    dfs(startStr, i,j, grGraph);
                    grAns += 1;
                }
            }
        }

        bw.write(ans +" "+grAns);
        bw.flush();
        bw.close();
        br.close();



    }


    private static void dfs(String startStr, int nowRow, int nowCol, String[][] graph) {
        visited[nowRow][nowCol] = true;

        for(int i=0; i<4; i++){
            int nr = nowRow + dr[i];
            int nc = nowCol + dc[i];
            if((0 <= nr && nr < N)  && (0 <= nc && nc <N)){
                if(visited[nr][nc] == false && ( graph[nowRow][nowCol].equals(graph[nr][nc]))){
                    startStr = graph[nr][nc];
                    dfs(startStr, nr, nc, graph);
                }
            }
        }
    }


}
