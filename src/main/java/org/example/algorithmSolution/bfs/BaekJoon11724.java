package org.example.algorithmSolution.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon11724 {
    public static void main(String[] args) throws IOException {
        // 방문 안된것 없을때까지
        // bfs 돌며 한 그래프 처리시 cnt+1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N+1][N+1]; // 시작점이 1번이기 때문에 N+1로 설정
        boolean[] visited = new boolean[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        int cnt = 0;
        for (int i=1; i<visited.length; i++){
            if(visited[i] == false){
                bfs(i, graph, visited);
                cnt+=1;
            }

        }

        bw.write(String.valueOf(cnt));

        bw.flush();
        bw.close();
        br.close();




    }

    private static void bfs(int node, int[][] graph, boolean[] visited) {
        visited[node] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);



        while (!queue.isEmpty()){
            int n = queue.poll();
            for(int i=1; i< graph.length; i++){
                if(graph[n][i] == 1 && visited[i] == false){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }

    }
}
