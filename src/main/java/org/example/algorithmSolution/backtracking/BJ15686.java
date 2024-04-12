package org.example.algorithmSolution.backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Posotion{
    int row;
    int col;

    Posotion(int row, int col){
        this.row = row;
        this.col = col;
    }
}


public class BJ15686 {
    static int N,M;
    static int[][] graph;
    static ArrayList<Posotion> homeList;
    static ArrayList<Posotion> chickenList;
    static boolean[] visited;
    static int ans;
    public static void main(String[] args) throws IOException {
        // 0빈칸, 1집, 2치킨
        // M개만 운영
        // 도시의 치킨거리: 각 집에서의 치킨거리(최소 거리)의 합
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        homeList = new ArrayList<>();
        chickenList = new ArrayList<>();


        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 1){
                    homeList.add(new Posotion(i,j));
                }else if (graph[i][j] == 2){
                    chickenList.add(new Posotion(i,j));
                }
            }
        }

        visited = new boolean[chickenList.size()];
        // 치킨집이 운영중일 떄, 모든 집에서 최소거리를 구함
        ans = Integer.MAX_VALUE;
        dfs(0,0);

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();


    }


    private static void dfs(int start, int idx) { // start는 어떤 치킨가게를 오픈할지 경우의 수를 뜻함, idx는 오픈한 치킨가게가 M이 될때까지 추가
        if(idx == M){
            int res = 0;
            for(int i=0; i< homeList.size(); i++){
                int minValue = Integer.MAX_VALUE;
                for (int j=0; j< chickenList.size(); j++){
                    if(visited[j]){
                        // 각 집에서 운영중인 치킨집에 대해 최소 치킨거리를 구함
                        int chickenDistance = Math.abs(homeList.get(i).row - chickenList.get(j).row)
                                    + Math.abs(homeList.get(i).col - chickenList.get(j).col);
                        minValue = Math.min(minValue, chickenDistance);
                    }
                }
                res += minValue;    // 도시의 치킨 거리 합산
            }
            ans = Math.min(ans, res); // 도시의 최소 치킨 거리 구하기
        }

        for (int i = start; i< chickenList.size(); i++){
            visited[i] = true; // 어느 한집을 운영중이라하고 다음 인덱스 부터 dfs 진행
            dfs(i+1, idx+1);
            visited[i] = false;
        }

    }


}
