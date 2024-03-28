package org.example.algorithmSolution.twoPointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoPointerEx2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        int[] solutions = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solutions);

        int start = 0;
        int end = solutions.length-1;
        int res = Integer.MAX_VALUE;
        int res1 = 0;
        int res2 = 0;

        while (start < end){
            int mid = solutions[start] + solutions[end];
            //res = Math.min(res, Math.abs(mid));

            if(Math.abs(mid) < res){
                res = Math.abs(mid);
                res1 = solutions[start];
                res2 = solutions[end];
                if(mid == 0){
                    break;
                }
            }

            if(mid < 0){
                start++;
            } else {
                end--;
            }




        }
        bw.write(String.valueOf(res1)+" "+String.valueOf(res2));

        bw.flush();
        bw.close();
        br.close();



    }
}
