package org.example.algorithmSolution.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1697 {
    static int[] visited;
    static int N,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[100001];

        if (N==K){
            System.out.println(0);
        }else{
            bfs(N);
        }

        //bw.flush();
        //bw.close();
        br.close();
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        //visited[start] = 1;


        while (!queue.isEmpty()){
           int n = queue.poll();
           for(int i=0; i<3; i++){
               int next=0;
               if(i==0){
                   next = n-1;
               }
               if(i==1){
                   next = n+1;
               }
               if(i==2){
                   next = n*2;
               }
               if(next == K){
                   System.out.println(visited[n]+1);
                   return;
               }
               if( next >= 0 && next < visited.length && visited[next] == 0){
                   queue.offer(next);
                   visited[next] = visited[n]+1;
               }
           }

        }

    }
}
