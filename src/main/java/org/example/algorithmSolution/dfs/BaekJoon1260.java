package org.example.algorithmSolution.dfs;

import java.io.*;
import java.util.*;

public class BaekJoon1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

//        ArrayList<Integer> dfsRank = new ArrayList<>();
//        ArrayList<Integer> bfsRank = new ArrayList<>();

        int[][] graph = new int[N+1][N+1]; // node가 1번부터 시작
        boolean[] visited = new boolean[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int node = Integer.parseInt(st.nextToken());
            int visitable = Integer.parseInt(st.nextToken());
            graph[node][visitable] = 1;
            graph[visitable][node] = 1;

        }

        dfs(V, visited, graph);

        System.out.println();

        visited = new boolean[N+1]; // bfs 를 위해 다시 탐색
        bfs(V, visited, graph);

    }

    private static void bfs(int v, boolean[] visited, int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;

        System.out.print(v+" ");

        while (!queue.isEmpty()){
            int n = queue.poll();
            for (int i=1; i< graph.length; i++){
                if(graph[n][i] == 1 && visited[i] == false){
                    visited[i] = true;
                    System.out.print(i+" ");
                    queue.offer(i);
                }

            }
        }
    }

    private static void dfs(int v, boolean[] visited, int[][] graph) {
        visited[v] = true;
        System.out.print(v+" ");


//        if (v==graph.length){
//            return; // 모든 정점을 다 돌았을 때
//        }

        for (int i=1; i<graph.length; i++){
            if (graph[v][i] == 1 && visited[i] == false){   // 연결 노드가 방문처리 되지 않았다면 그 노드에서 실행
                dfs(i, visited, graph);
            }
        }

    }


}
