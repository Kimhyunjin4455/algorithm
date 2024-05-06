package org.example.algorithmSolution.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon7576 {
    static int N,M;
    static int[][] tomatoGraph;
    static Queue<int[]> queue= new LinkedList<>();
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomatoGraph = new int[N][M];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<M; j++){
                tomatoGraph[i][j] = Integer.parseInt(st.nextToken());
                if(tomatoGraph[i][j] == 1)
                    queue.offer(new int[]{i,j});
            }
        }


        bw.write(String.valueOf(bfs()));
        bw.flush();
        bw.close();
        br.close();

    }

    private static int bfs() {
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int row = poll[0];
            int col = poll[1];

            int[] dr = {-1,0,1,0};
            int[] dc = {0,1,0,-1};

            for (int i=0; i<4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];
                if (nr>=0 && nr<N && nc >=0 && nc <M){
                    if(tomatoGraph[nr][nc] == 0){
                        tomatoGraph[nr][nc] = tomatoGraph[row][col]+1;
                        queue.offer(new int[]{nr,nc});
                    }

                }
            }
        }

        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (tomatoGraph[i][j] == 0){
                    return -1;
                }
                result = Math.max(tomatoGraph[i][j], result);
            }
        }

        if (result == 1){
            return 0;
        }else {
            return result-1;
        }

    }
}
