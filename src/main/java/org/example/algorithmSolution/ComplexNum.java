package org.example.algorithmSolution;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.StringTokenizer;

public class ComplexNum {


    final static int MAX = 25 + 10; // 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)
                                    // 넉넉하게 +10
    static boolean[][] graph;
    static boolean[][] visited;
    static int countNowApart;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};

    static void dfs(int row, int col){
        visited[row][col] = true;                           // visited 배열 사용없이, graph를 0으로 변경하는 풀이도 가능
        countNowApart ++;

        for (int i=0; i<4; i++){
            int newR = row + dr[i];
            int newC = col + dc[i];
            if(!visited[newR][newC] && graph[newR][newC]){
                dfs(newR, newC);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int mapSize = Integer.parseInt(br.readLine());

        graph = new boolean[MAX][MAX];
        visited = new boolean[MAX][MAX];
        for(int i=1; i<=mapSize; i++){
            String s = br.readLine();
            for(int j=1; j<=mapSize; j++){
                graph[i][j] = (s.charAt(j-1) == '1');         // j는 1부터 n번째 이므로 -1 함, graph는 boolean값이 필요

            }
        }

        ArrayList<Integer> countList = new ArrayList<>();     // 각 단지가 몇개의 아파트를 가지고 있을 지 담을 리스트
        for(int i=1; i<=mapSize; i++){
            for(int j=1; j<=mapSize; j++){
                if(graph[i][j] && !visited[i][j]){
                    countNowApart = 0;                        // 새로운 dfs 시작시 초기화
                    dfs(i,j);
                    countList.add(countNowApart);
                }
            }
        }

        System.out.println(countList.size());
//        bw.write(String.valueOf(countList.size()));
//        bw.newLine();

        Collections.sort(countList);
        for(int i=0; i<countList.size(); i++){
            System.out.println(countList.get(i));
        }

//        for(int i=0; i<countList.size(); i++){
//            bw.write(String.valueOf(countList.get(i)));
//            bw.newLine();
//        }

//        bw.flush();
//        bw.close();
        br.close();
    }
}
