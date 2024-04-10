package org.example.algorithmSolution.binarySearch;

import java.io.*;
import java.util.StringTokenizer;

public class BinarySearch1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lines = new int[K];
        int max = 0;
        for(int i=0; i<K; i++){
            lines[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lines[i]);
        }

        //Arrays.sort(lines);

        long start = 1; // start 마저 0이면 divided by zero
        long end = max;

        while (start <= end){
            long cnt = 0;
            long mid = (start + end)/2;
            for (int i=0; i<K; i++){
                cnt += (lines[i] / mid);
                bw.flush();
            }
            if(cnt < N) end = mid-1;
            else start = mid+1;
        }

        bw.write(String.valueOf(start-1));

        bw.flush();
        bw.close();
        br.close();

    }
}
