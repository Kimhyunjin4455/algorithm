package org.example.algorithmSolution;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Virus {
    static int node;
    static int edge;
    static boolean[][] graph;
    // static boolean[][] graph = new boolean[node+1][node+1];
    static boolean[] visited;
    static int cnt;

    public static void dfs(int index){

        cnt++;
        visited[index] = true;
        for (int i=1; i<=node; i++){ /** 배열의 크기는 node의 갯수보다 1크므로 1부터 node번째까지 설정*/
            if(visited[i]==false && graph[index][i] == true){

                dfs(i);
            }
        }

    }
    public static void main(String[] args) throws IOException {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        node = Integer.parseInt(br.readLine());
//        edge = Integer.parseInt(br.readLine());
        Scanner sc = new Scanner(System.in);

        node = sc.nextInt();
        edge = sc.nextInt();

        graph = new boolean[node+1][node+1];
        visited = new boolean[node+1];


        for(int i=0; i<edge; i++){
//            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//            int node1 = Integer.parseInt(st.nextToken());
//            int node2 = Integer.parseInt(st.nextToken());
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            graph[node1][node2] = graph[node2][node1] = true;
        }



        dfs(1); // 1번이 감염됨
        System.out.println(cnt-1);

        // 최종 범위 출력, 1번 노드는 처음부터 감염 되었으므로 -1
//        bw.write(String.valueOf(cnt-1));
//        bw.newLine();
//
//        bw.flush();
//        bw.close();
//        br.close();
    }

}
