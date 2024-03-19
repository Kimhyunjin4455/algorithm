package org.example.algorithmSolution.problem;

import java.io.*;
import java.util.StringTokenizer;

public class KnapsackGold1 {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());   // N개의 물건을 가지고 있고, 최대 C만큼의 무게
        int C = Integer.parseInt(st.nextToken());




        bw.flush();
        bw.close();
        br.close();


    }


}
