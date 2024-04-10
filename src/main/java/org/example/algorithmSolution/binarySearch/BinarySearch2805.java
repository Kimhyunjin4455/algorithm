package org.example.algorithmSolution.binarySearch;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BinarySearch2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> trees = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            trees.add(Integer.parseInt(st.nextToken()));
        }

        trees.sort(null);

        int start = 0;
        int end = trees.get(trees.size()-1);


        int result = bs(start, end, trees, M);
        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();

    }

    private static int bs(int start, int end, ArrayList<Integer> trees, int M) {
        int mid = (start + end) / 2;

        while (start <= end) {
            mid = (start + end) / 2;
            long sum = 0;
            for (int length : trees) {
                if (length > mid) {
                    sum += (length - mid);
                }
            }
            //System.out.println("s: "+sum);
            if (sum > M) { // sum이 더 커져야 함 -> mid값이 더 작아져야 함
                start = mid +1;
            }else
                end = mid-1;

        }return start;
    }
}
