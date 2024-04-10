package org.example.algorithmSolution.binarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            int problem = Integer.parseInt(st.nextToken());
            sb.append(upperBound(cards, problem) - lowerBound(cards, problem)).append(" ");
        }

        bw.write(String.valueOf(sb));

        bw.flush();
        bw.close();
        br.close();



    }

    private static int lowerBound(int[] cards, int problem) {
        int start = 0;
        int end = cards.length-1;

        while(start<=end){
            int mid = (start + end) /2;
            if(problem <= cards[mid]){
                end = mid-1;
            }else start = mid+1;
        }
        return end;
    }

    private static int upperBound(int[] cards, int problem) {
        int start = 0;
        int end = cards.length-1;

        while (start<=end){
            int mid = (start + end) /2;
            if(problem < cards[mid]){
                end = mid-1;
            }else start = mid+1;
        }
        return start-1;
    }
}
