package org.example.algorithmSolution.backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


class Position{
    int row;
    int col;

    Position(int row, int col){
        this.row = row;
        this.col = col;
    }
}
public class BJ15686 {

    static int N, M;
    static int[][] graph;
    static ArrayList<Position> home;
    static ArrayList<Position> chicken;
    static boolean[] visited; // 오픈한 치킨집
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for(int i=0; i<N; i++){ // 좌표 정보 입력받고, 치킨집과 집에 대한 정보를 각각 list에 저장, 정보 담을 클래스를 생성(Position)
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 1){
                    home.add(new Position(i,j));
                }
                if(graph[i][j] == 2){
                    chicken.add(new Position(i,j));
                }
            }
        }

        visited = new boolean[chicken.size()];
        ans = Integer.MAX_VALUE;
        dfs(0,0);

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();

    }

    private static void dfs(int start, int idx){
        if(idx == M){ // M번(오픈한 총개수)의 반복을 했으면 모든 집에 대하여 오픈한 치킨집에 대한 최소 거리의 합 구함
            int res = 0;

            for(int i=0; i< home.size(); i++){
                int minValue = Integer.MAX_VALUE;
                for (int j=0; j< chicken.size(); j++){
                    if (visited[j]){
                        int chickenDistance = Math.abs(home.get(i).row - chicken.get(j).row)
                                + Math.abs(home.get(i).col - chicken.get(j).col);
                        minValue = Math.min(minValue, chickenDistance);
                    }
                }
                res += minValue;
            }
            ans = Math.min(ans, res);

        }

        for (int i=start; i< chicken.size(); i++){
            visited[i] = true;
            dfs(i+1, idx+1);
            visited[i] = false;
        } // 치킨집 개수만큼 백트래킹



    }
}
